/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.Log;
import kmm.dao.DAO;

/**
 *
 * @author adrianohrl
 */
public class LogDAO extends DAO<Log, Long> {

    public LogDAO(EntityManager em) {
        super(em, Log.class);
    }

    @Override
    public boolean isRegistered(Log log) {
        return super.find(log.getCode()) != null;
    }

}
