/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck.dao;

import javax.persistence.EntityManager;
import kmm.dao.DAO;
import kmm.paycheck.Schedule;

/**
 *
 * @author adrianohrl
 */
public class ScheduleDAO extends DAO<Schedule, String> {

    public ScheduleDAO(EntityManager em) {
        super(em, Schedule.class);
    }

    @Override
    public boolean isRegistered(Schedule schedule) {
        return super.find(schedule.getEmployeeName()) != null;
    }

}
