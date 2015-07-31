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
        super(em);
    }

    @Override
    public void createFullfilled(P personWithSkills) {
        this.creatingFullfilled(personWithSkills);
        em.getTransaction().commit();
    }

    @Override
    public void creatingFullfilled(P personWithSkills) {
        super.creatingFullfilled(personWithSkills);
        SkillDAO skillDAO = new SkillDAO(em);
        for (Skill skill : personWithSkills.getSkills()) {
            skillDAO.creatingFullfilled(skill);
        }
        em.merge(personWithSkills);
    }
    
}
