/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.WorkingPeriod;
import kmm.dao.NameableObjectDAO;

/**
 *
 * @author adrianohrl
 */
public class WorkingPeriodDAO extends NameableObjectDAO<WorkingPeriod> {

    public WorkingPeriodDAO(EntityManager em) {
        super(em, WorkingPeriod.class);
    }
    
}
