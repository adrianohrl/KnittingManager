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
        super(em);
    }

    @Override
    public void createFullfilled(VacationNote vacationNote) {
        if (vacationNote == null) { 
            return;
        }
        em.getTransaction().begin();
        em.persist(vacationNote);
        EmployeeDAO employeeDAO = new EmployeeDAO(em);
        employeeDAO.creatingFullfilled(vacationNote.getResponsible());
        em.merge(vacationNote);
        em.getTransaction().commit();
    }

    @Override
    public void creatingFullfilled(VacationNote vacationNote) {
        if (vacationNote == null) {
            return;
        }
        em.persist(vacationNote);
        EmployeeDAO employeeDAO = new EmployeeDAO(em);
        employeeDAO.creatingFullfilled(vacationNote.getResponsible());
        em.merge(vacationNote);
    }
    
}
