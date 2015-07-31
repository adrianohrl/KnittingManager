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
public class SalaryDAO extends DAO<Salary, Long> implements ComplexObject<Salary>, ComplexObjectRelated<Salary> {

    public SalaryDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void createFullfilled(Salary salary) {
        if (salary == null) { 
            return;
        }
        em.getTransaction().begin();
        em.persist(salary);
        EmployeeDAO employeeDAO = new EmployeeDAO(em);
        employeeDAO.creatingFullfilled(salary.getEmployee());
        ExtraDAO extraDAO = new ExtraDAO(em);
        for (Extra extra : salary.getExtras()) {
            extraDAO.creatingFullfilled(extra);
        }
        em.merge(salary);
        em.getTransaction().commit();
    }

    @Override
    public void creatingFullfilled(Salary salary) {
        if (salary == null) {
            return;
        }
        em.persist(salary);
        EmployeeDAO employeeDAO = new EmployeeDAO(em);
        employeeDAO.creatingFullfilled(salary.getEmployee());
        ExtraDAO extraDAO = new ExtraDAO(em);
        for (Extra extra : salary.getExtras()) {
            extraDAO.creatingFullfilled(extra);
        }
        em.merge(salary);
    }
    
}
