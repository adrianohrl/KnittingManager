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
        super(em);
    }

    @Override
    public void createFullfilled(SalaryAlteration salaryAlteration) {
        if (salaryAlteration == null) { 
            return;
        }
        em.getTransaction().begin();
        em.persist(salaryAlteration);
        EmployeeDAO employeeDAO = new EmployeeDAO(em);
        employeeDAO.creatingFullfilled(salaryAlteration.getResponsible());
        em.merge(salaryAlteration);
        em.getTransaction().commit();
    }

    @Override
    public void creatingFullfilled(SalaryAlteration salaryAlteration) {
        if (salaryAlteration == null) { 
            return;
        }
        em.persist(salaryAlteration);
        EmployeeDAO employeeDAO = new EmployeeDAO(em);
        employeeDAO.creatingFullfilled(salaryAlteration.getResponsible());
        em.merge(salaryAlteration);
    }
    
}
