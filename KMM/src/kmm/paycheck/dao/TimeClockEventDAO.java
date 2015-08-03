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
        super(em, TimeClockEvent.class);
    }

    @Override
    public void createFullfilled(TimeClockEvent timeClockEvent) {
        if (timeClockEvent == null) {
            return;
        }
        em.getTransaction().begin();
        this.persist(timeClockEvent);
        em.getTransaction().commit();
    }

    @Override
    public void persist(TimeClockEvent timeClockEvent) {
        this.persist(timeClockEvent, timeClockEvent);
    }

    @Override
    public void creatingFullfilled(Object beingCreated, TimeClockEvent timeClockEvent) {
        if (beingCreated.equals(timeClockEvent)) {
            em.merge(timeClockEvent);
            return;
        }
        this.persist(timeClockEvent);
    }

    @Override
    public void persist(Object beingCreated, TimeClockEvent timeClockEvent) {
        if (timeClockEvent == null) {
            return;
        }
        if (!isRegistered(timeClockEvent)) {
            em.persist(timeClockEvent);
        }
        EmployeeDAO employeeDAO = new EmployeeDAO(em);
        employeeDAO.creatingFullfilled(beingCreated, timeClockEvent.getEmployee());
        em.merge(timeClockEvent);
    }

    @Override
    public boolean isRegistered(TimeClockEvent timeClockEvent) {
        return super.find(timeClockEvent.getCode()) != null;
    }

}
