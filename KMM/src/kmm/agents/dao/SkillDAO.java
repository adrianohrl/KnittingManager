/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.Skill;
import kmm.dao.ComplexObjectRelated;
import kmm.dao.DAO;

/**
 *
 * @author adrianohrl
 */
public class SkillDAO extends DAO<Skill, String> implements ComplexObjectRelated<Skill> {
    
    public SkillDAO(EntityManager em) {
        super(em, Skill.class);
    }

    @Override
    public void creatingFullfilled(Object beingCreated, Skill skill) {
        this.persist(beingCreated, skill);
    }

    @Override
    public void persist(Object beingCreated, Skill skill) {
        if (skill == null) {
            return;
        }
        if (!isRegistered(skill)) {
            em.persist(skill);
        }
        em.merge(skill);
    }

    @Override
    public boolean isRegistered(Skill skill) {
        return super.find(skill.getSkill()) != null;
    }
    
}
