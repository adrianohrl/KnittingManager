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
        super(em, Dependent.class);
    }

    @Override
    public void persist(Object beingCreated, Dependent dependent) {
        if (dependent == null) {
            return;
        }
        super.persist(beingCreated, dependent);
        EmployeeDAO employeeDAO = new EmployeeDAO(em);
        employeeDAO.creatingFullfilled(beingCreated, dependent.getEmployee());
        KinshipDAO kinshipDAO = new KinshipDAO(em);
        kinshipDAO.creatingFullfilled(beingCreated, dependent.getKinship());
        em.merge(dependent);
    }

}
