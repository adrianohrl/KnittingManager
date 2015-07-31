/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.Privilege;
import kmm.dao.ComplexObjectRelated;
import kmm.dao.DescriptableObjectDAO;

/**
 *
 * @author adrianohrl
 */
public class PrivilegeDAO extends DescriptableObjectDAO<Privilege> implements ComplexObjectRelated<Privilege> {

    public PrivilegeDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void creatingFullfilled(Privilege privilege) {
        if (privilege == null) {
            return;
        }
        em.persist(privilege);
    }
    
}
