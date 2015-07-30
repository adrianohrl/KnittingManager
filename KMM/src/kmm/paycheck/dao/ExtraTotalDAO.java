/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck.dao;

import javax.persistence.EntityManager;
import kmm.dao.DAO;
import kmm.paycheck.ExtraTotal;

/**
 *
 * @author adrianohrl
 */
public class ExtraTotalDAO extends DAO<ExtraTotal, Long> {

    public ExtraTotalDAO(EntityManager em) {
        super(em);
    }
    
}
