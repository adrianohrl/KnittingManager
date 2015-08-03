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
        super(em, Company.class);
    }
    
    protected CompanyDAO(EntityManager em, Class clazz) {
        super(em, clazz);
    }

    @Override
    public void createFullfilled(C company) {
        if (company == null) {
            return;
        }
        em.getTransaction().begin();
        this.persist(company);
        em.getTransaction().commit();
    }

    @Override
    public void persist(C company) {
        this.persist(company, company);
    }

    @Override
    public void creatingFullfilled(Object beingCreated, C company) {
        if (beingCreated.equals(company)) {
            em.merge(company);
            return;
        }
        this.persist(beingCreated, company);
    }

    @Override
    public void persist(Object beingCreated, C company) {
        if (company == null) {
            return;
        }
        if (!isRegistered(company)) {
            em.persist(company);
        }
        AddressDAO addressDAO = new AddressDAO(em);
        addressDAO.creatingFullfilled(beingCreated, company.getAddress());
        CompanyTypeDAO companyTypeDAO = new CompanyTypeDAO(em);
        companyTypeDAO.creatingFullfilled(beingCreated, company.getType());
        em.merge(company);
    }

    @Override
    public boolean isRegistered(C company) {
        return super.find(company.getBusinessName()) != null;
    }

}
