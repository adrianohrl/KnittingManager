/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.Company;
import kmm.dao.DAO;

/**
 *
 * @author adrianohrl
 * @param <C>
 */
public abstract class CompanyDAO<C extends Company> extends DAO<C, String> {

    public CompanyDAO(EntityManager em) {
        super(em);
    }
    
}
