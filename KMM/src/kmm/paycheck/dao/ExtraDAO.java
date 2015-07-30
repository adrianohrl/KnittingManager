/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck.dao;

import javax.persistence.EntityManager;
import kmm.dao.NameableObjectDAO;
import kmm.paycheck.Extra;

/**
 *
 * @author adrianohrl
 */
public class ExtraDAO extends NameableObjectDAO<Extra> {

    public ExtraDAO(EntityManager em) {
        super(em);
    }
    
}
