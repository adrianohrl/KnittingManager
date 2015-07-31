/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.Company;
import kmm.dao.ComplexObject;
import kmm.dao.ComplexObjectRelated;
import kmm.dao.DAO;

/**
 *
 * @author adrianohrl
 * @param <C>
 */
public class CompanyDAO<C extends Company> extends DAO<C, String> implements ComplexObject<C>, ComplexObjectRelated<C> {

    public CompanyDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void createFullfilled(C company) {
        if (company == null) {
            return;
        }
        em.getTransaction().begin();
        em.persist(company);
        AddressDAO addressDAO = new AddressDAO(em);
        addressDAO.creatingFullfilled(company.getAddress());
        CompanyTypeDAO companyTypeDAO = new CompanyTypeDAO(em);
        companyTypeDAO.creatingFullfilled(company.getType());
        em.merge(company);
        em.getTransaction().commit();
    }

    @Override
    public void creatingFullfilled(C company) {
        if (company == null) {
            return;
        }
        em.persist(company);
        AddressDAO addressDAO = new AddressDAO(em);
        addressDAO.creatingFullfilled(company.getAddress());
        CompanyTypeDAO companyTypeDAO = new CompanyTypeDAO(em);
        companyTypeDAO.creatingFullfilled(company.getType());
        em.merge(company);
    }
    
}
