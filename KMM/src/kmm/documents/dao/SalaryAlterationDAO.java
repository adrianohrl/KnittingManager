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
import kmm.documents.SalaryAlteration;

/**
 *
 * @author adrianohrl
 */
public class SalaryAlterationDAO extends DAO<SalaryAlteration, Long> implements ComplexObject<SalaryAlteration>, ComplexObjectRelated<SalaryAlteration> {

    public SalaryAlterationDAO(EntityManager em) {
        super(em, SalaryAlteration.class);
    }

    @Override
    public void createFullfilled(SalaryAlteration salaryAlteration) {
        if (salaryAlteration == null) {
            return;
        }
        em.getTransaction().begin();
        this.persist(salaryAlteration);
        em.getTransaction().commit();
    }

    @Override
    public void persist(SalaryAlteration salaryAlteration) {
        this.persist(salaryAlteration, salaryAlteration);
    }

    @Override
    public void creatingFullfilled(Object beingCreated, SalaryAlteration salaryAlteration) {
        if (beingCreated.equals(salaryAlteration)) {
            em.merge(salaryAlteration);
            return;
        }
        this.persist(beingCreated, salaryAlteration);
    }

    @Override
    public void persist(Object beingCreated, SalaryAlteration salaryAlteration) {
        if (salaryAlteration == null) {
            return;
        }
        if (!isRegistered(salaryAlteration)) {
            em.persist(salaryAlteration);
        }
        EmployeeDAO employeeDAO = new EmployeeDAO(em);
        employeeDAO.creatingFullfilled(beingCreated, salaryAlteration.getResponsible());
        em.merge(salaryAlteration);
    }

    @Override
    public boolean isRegistered(SalaryAlteration salaryAlteration) {
        return super.find(salaryAlteration.getCode()) != null;
    }

}
