/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck.dao;

import javax.persistence.EntityManager;
import kmm.dao.DAO;
import kmm.paycheck.TimeClockEvent;

/**
 *
 * @author adrianohrl
 */
public class TimeClockEventDAO extends DAO<TimeClockEvent, Long> {

    public TimeClockEventDAO(EntityManager em) {
        super(em);
    }
    
}
