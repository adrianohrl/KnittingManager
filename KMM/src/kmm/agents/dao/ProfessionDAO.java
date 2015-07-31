/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.Profession;
import kmm.dao.ComplexObjectRelated;
import kmm.dao.NameableObjectDAO;

/**
 *
 * @author adrianohrl
 */
public class ProfessionDAO extends NameableObjectDAO<Profession> implements ComplexObjectRelated<Profession> {

    public ProfessionDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void creatingFullfilled(Profession profession) {
        if (profession == null) {
            return;
        }
        em.persist(profession);
    }
    
}
