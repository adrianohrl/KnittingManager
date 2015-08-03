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
        super(em, KMMUser.class);
    }

    @Override
    public void persist(Object beingCreated, KMMUser user) {
        if (user == null) {
            return;
        }
        super.persist(beingCreated, user);
        PrivilegeDAO privilegeDAO = new PrivilegeDAO(em);
        for (Privilege privilege : user.getPrivileges()) {
            privilegeDAO.creatingFullfilled(beingCreated, privilege);
        }
        em.merge(user);
    }

}
