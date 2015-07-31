/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.CompanyType;
import kmm.dao.ComplexObjectRelated;
import kmm.dao.NameableObjectDAO;

/**
 *
 * @author adrianohrl
 */
public class CompanyTypeDAO extends NameableObjectDAO<CompanyType> implements ComplexObjectRelated<CompanyType> {

    public CompanyTypeDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void creatingFullfilled(CompanyType companyType) {
        if (companyType == null) {
            return;
        }
        em.persist(companyType);
    }
    
}
