/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.Privilege;
import kmm.dao.DAO;

/**
 *
 * @author adrianohrl
 */
public class PrivilegeDAO extends DAO<Privilege, String> {

    public PrivilegeDAO(EntityManager em) {
        super(em, Privilege.class);
    }

    @Override
    public boolean isRegistered(Privilege privilege) {
        return super.find(privilege.getPrivilege()) != null;
    }

}
