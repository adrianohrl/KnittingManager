/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.PersonWithSkills;
import kmm.agents.Skill;

/**
 *
 * @author adrianohrl
 * @param <P>
 */
public abstract class PersonWithSkillsDAO<P extends PersonWithSkills> extends PersonDAO<P> {

    public PersonWithSkillsDAO(EntityManager em) {
        super(em, PersonWithSkills.class);
    }
    
    protected PersonWithSkillsDAO(EntityManager em, Class clazz) {
        super(em, clazz);
    }
    
    @Override
    public void persist(Object beingCreated, P personWithSkills) {
        if (personWithSkills == null) {
            return;
        }
        super.persist(beingCreated, personWithSkills);
        SkillDAO skillDAO = new SkillDAO(em);
        for (Skill skill : personWithSkills.getSkills()) {
            skillDAO.creatingFullfilled(beingCreated, skill);
        }
        em.merge(personWithSkills);
    }
    
}
