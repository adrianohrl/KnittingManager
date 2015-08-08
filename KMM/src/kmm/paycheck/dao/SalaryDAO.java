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
import kmm.paycheck.Extra;
import kmm.paycheck.Salary;

/**
 *
 * @author adrianohrl
 */
public class SalaryDAO extends DAO<Salary, String> implements ComplexObject<Salary>, ComplexObjectRelated<Salary> {

    public SalaryDAO(EntityManager em) {
        super(em, Salary.class);
    }

    @Override
    public void createFullfilled(Salary salary) {
        if (salary == null) {
            return;
        }
        em.getTransaction().begin();
        this.persist(salary);
        em.getTransaction().commit();
    }

    @Override
    public void persist(Salary salary) {
        this.persist(salary, salary);
    }

    @Override
    public void creatingFullfilled(Object beingCreated, Salary salary) {
        if (beingCreated.equals(salary)) {
            em.merge(salary);
            return;
        }
        this.persist(beingCreated, salary);
    }

    @Override
    public void persist(Object beingCreated, Salary salary) {
        if (salary == null) {
            return;
        }
        if (!isRegistered(salary)) {
            em.persist(salary);
        }
        EmployeeDAO employeeDAO = new EmployeeDAO(em);
        //employeeDAO.creatingFullfilled(beingCreated, salary.getEmployee());
        ExtraDAO extraDAO = new ExtraDAO(em);
        for (Extra extra : salary.getExtras()) {
            extraDAO.creatingFullfilled(beingCreated, extra);
        }
        em.merge(salary);
    }

    @Override
    public boolean isRegistered(Salary salary) {
        return super.find(salary.getEmployeeName()) != null;
    }
    
    public void remove(Salary salary) {
        if (salary == null || !isRegistered(salary)) {
            return;
        }
        salary.setEmployee(null);
        salary.getExtras().clear();
        super.update(salary);
        super.remove(salary.getEmployeeName());
    }

}
