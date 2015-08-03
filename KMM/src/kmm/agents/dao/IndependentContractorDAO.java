/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.IndependentContractor;
import kmm.agents.PersonWithSkills;

/**
 *
 * @author adrianohrl
 */
public class IndependentContractorDAO extends PersonWithSkillsDAO<PersonWithSkills> {

    public IndependentContractorDAO(EntityManager em) {
        super(em, IndependentContractor.class);
    }
    
}
