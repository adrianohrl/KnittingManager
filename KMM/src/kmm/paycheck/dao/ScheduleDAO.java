/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck.dao;

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
public class ScheduleDAO extends DAO<Schedule, Long> implements ComplexObject<Schedule>, ComplexObjectRelated<Schedule> {

    public ScheduleDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void createFullfilled(Schedule schedule) {
        if (schedule == null) { 
            return;
        }
        em.getTransaction().begin();
        em.persist(schedule);
        EmployeeDAO employeeDAO = new EmployeeDAO(em);
        employeeDAO.creatingFullfilled(schedule.getEmployee());
        DailyEstablishedHourDAO dailyEstablishedHourDAO = new DailyEstablishedHourDAO(em);
        for (DailyEstablishedHour dailyEstablishedHour : schedule.getBankOfHours()) {
            dailyEstablishedHourDAO.creatingFullfilled(dailyEstablishedHour);
        }
        em.merge(schedule);
        em.getTransaction().commit();
    }

    @Override
    public void creatingFullfilled(Schedule schedule) {
        if (schedule == null) {
            return;
        }
        em.persist(schedule);
        EmployeeDAO employeeDAO = new EmployeeDAO(em);
        employeeDAO.creatingFullfilled(schedule.getEmployee());
        DailyEstablishedHourDAO dailyEstablishedHourDAO = new DailyEstablishedHourDAO(em);
        for (DailyEstablishedHour dailyEstablishedHour : schedule.getBankOfHours()) {
            dailyEstablishedHourDAO.creatingFullfilled(dailyEstablishedHour);
        }
        em.merge(schedule);
    }
    
}
