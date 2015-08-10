/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.Skill;
import kmm.dao.DAO;

/**
 *
 * @author adrianohrl
 */
public class SkillDAO extends DAO<Skill, String> {
    
    public SkillDAO(EntityManager em) {
        super(em, Skill.class);
    }

    @Override
    public boolean isRegistered(Skill skill) {
        return super.find(skill.getSkill()) != null;
    }
    
}
