/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.KMMUser;
import kmm.agents.Privilege;
import kmm.dao.ComplexObjectRelated;

/**
 *
 * @author adrianohrl
 */
public class KMMUserDAO extends EmployeeDAO<KMMUser> implements ComplexObjectRelated<KMMUser> {

    public KMMUserDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void createFullfilled(KMMUser user) {
        this.creatingFullfilled(user);
        em.getTransaction().commit();
    }

    @Override
    public void creatingFullfilled(KMMUser user) {
        super.createFullfilled(user);
        PrivilegeDAO privilegeDAO = new PrivilegeDAO(em);
        for (Privilege privilege : user.getPrivileges()) {
            privilegeDAO.creatingFullfilled(privilege);
        }
        em.merge(user);
    }
    
}
