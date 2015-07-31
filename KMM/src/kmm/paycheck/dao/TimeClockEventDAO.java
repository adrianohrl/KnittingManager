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
import kmm.paycheck.TimeClockEvent;

/**
 *
 * @author adrianohrl
 */
public class TimeClockEventDAO extends DAO<TimeClockEvent, Long> implements ComplexObject<TimeClockEvent>, ComplexObjectRelated<TimeClockEvent> {

    public TimeClockEventDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void createFullfilled(TimeClockEvent timeClockEvent) {
        if (timeClockEvent == null) { 
            return;
        }
        em.getTransaction().begin();
        em.persist(timeClockEvent);
        EmployeeDAO employeeDAO = new EmployeeDAO(em);
        employeeDAO.creatingFullfilled(timeClockEvent.getEmployee());
        em.merge(timeClockEvent);
        em.getTransaction().commit();
    }

    @Override
    public void creatingFullfilled(TimeClockEvent timeClockEvent) {
        if (timeClockEvent == null) {
            return;
        }
        em.persist(timeClockEvent);
        EmployeeDAO employeeDAO = new EmployeeDAO(em);
        employeeDAO.creatingFullfilled(timeClockEvent.getEmployee());
        em.merge(timeClockEvent);
    }
    
}
