/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.KMMUser;

/**
 *
 * @author adrianohrl
 */
public class KMMUserDAO extends EmployeeDAO<KMMUser> {

    public KMMUserDAO(EntityManager em) {
        super(em, KMMUser.class);
    }

}
