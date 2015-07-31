/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.Gender;
import kmm.dao.ComplexObjectRelated;
import kmm.dao.NameableObjectDAO;

/**
 *
 * @author adrianohrl
 */
public class GenderDAO extends NameableObjectDAO<Gender> implements ComplexObjectRelated<Gender> {

    public GenderDAO(EntityManager em) {
        super(em);
    }
    
    @Override
    public void creatingFullfilled(Gender gender) {
        if (gender == null) {
            return;
        }
        em.persist(gender);
    }
    
}
