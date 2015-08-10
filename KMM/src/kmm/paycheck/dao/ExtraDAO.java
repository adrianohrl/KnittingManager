/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck.dao;

import javax.persistence.EntityManager;
import kmm.dao.DAO;
import kmm.paycheck.Extra;

/**
 *
 * @author adrianohrl
 */
public class ExtraDAO extends DAO<Extra, Long> {

    public ExtraDAO(EntityManager em) {
        super(em, Extra.class);
    }

    @Override
    public boolean isRegistered(Extra entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
