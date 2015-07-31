/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.Log;
import kmm.dao.ComplexObject;
import kmm.dao.DAO;

/**
 *
 * @author adrianohrl
 */
public class LogDAO extends DAO<Log, Long> implements ComplexObject<Log> {

    public LogDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void createFullfilled(Log log) {
        if (log == null) {
            return;
        }
        em.getTransaction().begin();
        em.persist(log);
        KMMUserDAO userDAO = new KMMUserDAO(em);
        userDAO.creatingFullfilled(log.getUser());
        LogActionDAO logActionDAO = new LogActionDAO(em);
        logActionDAO.creatingFullfilled(log.getAction());
        em.merge(log);
        em.getTransaction().commit();
    }
    
}
