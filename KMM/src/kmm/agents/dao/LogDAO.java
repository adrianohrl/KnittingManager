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
        super(em, Log.class);
    }

    @Override
    public void createFullfilled(Log log) {
        if (log == null) {
            return;
        }
        em.getTransaction().begin();
        this.persist(log);
        em.getTransaction().commit();
    }

    @Override
    public void persist(Log log) {
        if (log == null) {
            return;
        }
        if (!isRegistered(log)) {
            em.persist(log);
        }
        KMMUserDAO userDAO = new KMMUserDAO(em);
        userDAO.creatingFullfilled(log, log.getUser());
        LogActionDAO logActionDAO = new LogActionDAO(em);
        logActionDAO.creatingFullfilled(log, log.getAction());
        em.merge(log);
    }

    @Override
    public boolean isRegistered(Log log) {
        return super.find(log.getCode()) != null;
    }

}
