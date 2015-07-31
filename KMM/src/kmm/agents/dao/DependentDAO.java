/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.Dependent;
import kmm.dao.ComplexObjectRelated;

/**
 *
 * @author adrianohrl
 */
public class DependentDAO extends PersonDAO<Dependent> implements ComplexObjectRelated<Dependent> {

    public DependentDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void createFullfilled(Dependent dependent) {
        this.creatingFullfilled(dependent); 
        em.getTransaction().commit();
    }

    @Override
    public void creatingFullfilled(Dependent dependent) {
        super.creatingFullfilled(dependent); 
        EmployeeDAO employeeDAO = new EmployeeDAO(em);
        employeeDAO.creatingFullfilled(dependent.getEmployee());
        KinshipDAO kinshipDAO = new KinshipDAO(em);
        kinshipDAO.creatingFullfilled(dependent.getKinship());
        em.merge(dependent);
    }
    
}
