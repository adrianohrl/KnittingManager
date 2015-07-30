/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.Person;
import kmm.dao.DAO;

/**
 *
 * @author adrianohrl
 * @param <P>
 */
public class PersonDAO<P extends Person> extends DAO<P, String> {

    public PersonDAO(EntityManager em) {
        super(em);
    }
    
}
