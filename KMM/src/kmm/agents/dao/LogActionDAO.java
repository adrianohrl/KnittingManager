/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.LogAction;
import kmm.dao.ComplexObjectRelated;
import kmm.dao.DescriptableObjectDAO;

/**
 *
 * @author adrianohrl
 */
public class LogActionDAO extends DescriptableObjectDAO<LogAction> implements ComplexObjectRelated<LogAction>  {

    public LogActionDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void creatingFullfilled(LogAction action) {
        if (action == null) {
            return;
        }
        em.persist(action);
    }
    
}
