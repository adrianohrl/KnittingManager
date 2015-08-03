/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.agents.dao.EmployeeDAO;
import kmm.dao.ComplexObject;
import kmm.dao.ComplexObjectRelated;
import kmm.dao.DAO;
import kmm.documents.VacationNote;

/**
 *
 * @author adrianohrl
 */
public class VacationNoteDAO extends DAO<VacationNote, Long> implements ComplexObject<VacationNote>, ComplexObjectRelated<VacationNote> {

    public VacationNoteDAO(EntityManager em) {
        super(em, VacationNote.class);
    }

    @Override
    public void createFullfilled(VacationNote vacationNote) {
        if (vacationNote == null) {
            return;
        }
        em.getTransaction().begin();
        this.persist(vacationNote);
        em.getTransaction().commit();
    }

    @Override
    public void persist(VacationNote vacationNote) {
        this.persist(vacationNote, vacationNote);
    }

    @Override
    public void creatingFullfilled(Object beingCreated, VacationNote vacationNote) {
        if (beingCreated.equals(vacationNote)) {
            em.merge(vacationNote);
            return;
        }
        this.persist(beingCreated, vacationNote);
    }

    @Override
    public void persist(Object beingCreated, VacationNote vacationNote) {
        if (vacationNote == null) {
            return;
        }
        if (!isRegistered(vacationNote)) {
            em.persist(vacationNote);
        }
        EmployeeDAO employeeDAO = new EmployeeDAO(em);
        employeeDAO.creatingFullfilled(beingCreated, vacationNote.getResponsible());
        em.merge(vacationNote);
    }

    @Override
    public boolean isRegistered(VacationNote vacationNote) {
        return super.find(vacationNote.getCode()) != null;
    }

}
