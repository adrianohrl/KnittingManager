/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.PersonWithSkills;

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
    
}
