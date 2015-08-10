/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.Dependent;

/**
 *
 * @author adrianohrl
 */
public class DependentDAO extends PersonDAO<Dependent> {

    public DependentDAO(EntityManager em) {
        super(em, Dependent.class);
    }
    
}
