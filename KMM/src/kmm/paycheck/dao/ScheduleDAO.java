/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck.dao;

import java.util.List;
import javax.persistence.EntityManager;
import kmm.agents.dao.EmployeeDAO;
import kmm.dao.ComplexObject;
import kmm.dao.ComplexObjectRelated;
import kmm.dao.DAO;
import kmm.paycheck.DailyEstablishedHour;
import kmm.paycheck.Schedule;

/**
 *
 * @author adrianohrl
 */
public class ScheduleDAO extends DAO<Schedule, String> implements ComplexObject<Schedule>, ComplexObjectRelated<Schedule> {

    public ScheduleDAO(EntityManager em) {
        super(em, Schedule.class);
    }

    @Override
    public void createFullfilled(Schedule schedule) {
        if (schedule == null) {
            return;
        }
        em.getTransaction().begin();
        this.persist(schedule);
        em.getTransaction().commit();
    }

    @Override
    public void persist(Schedule schedule) {
        this.persist(schedule, schedule);
    }

    @Override
    public void creatingFullfilled(Object beingCreated, Schedule schedule) {
        if (beingCreated.equals(schedule)) {
            em.merge(schedule);
            return;
        }
        this.persist(beingCreated, schedule);
    }

    @Override
    public void persist(Object beingCreated, Schedule schedule) {
        if (schedule == null) {
            return;
        }
        if (!isRegistered(schedule)) {
            em.persist(schedule);
        }
        EmployeeDAO employeeDAO = new EmployeeDAO(em);
        //employeeDAO.creatingFullfilled(beingCreated, schedule.getEmployee());
        DailyEstablishedHourDAO dailyEstablishedHourDAO = new DailyEstablishedHourDAO(em);
        for (DailyEstablishedHour dailyEstablishedHour : schedule.getBankOfHours()) {
            dailyEstablishedHourDAO.creatingFullfilled(beingCreated, dailyEstablishedHour);
        }
        em.merge(schedule);
    }

    @Override
    public boolean isRegistered(Schedule schedule) {
        return super.find(schedule.getEmployeeName()) != null;
    }
    
    public void remove(Schedule schedule) {
        if (schedule == null || !isRegistered(schedule)) {
            return;
        }
        schedule.setEmployee(null);
        DailyEstablishedHourDAO dailyEstablishedHourDAO = new DailyEstablishedHourDAO(em);
        List<DailyEstablishedHour> dailyEstablishedHours = schedule.getBankOfHours();
        for (DailyEstablishedHour dailyEstablishedHour : dailyEstablishedHours) {
            dailyEstablishedHours.remove(dailyEstablishedHour);
            dailyEstablishedHourDAO.remove(dailyEstablishedHour.getCode());
        }
        super.update(schedule);
        super.remove(schedule.getEmployeeName());
    }

}
