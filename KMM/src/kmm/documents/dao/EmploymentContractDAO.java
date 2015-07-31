/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.agents.dao.CompanyDAO;
import kmm.agents.dao.ProfessionDAO;
import kmm.dao.ComplexObject;
import kmm.dao.ComplexObjectRelated;
import kmm.dao.DAO;
import kmm.documents.EmploymentContract;

/**
 *
 * @author adrianohrl
 */
public class EmploymentContractDAO extends DAO<EmploymentContract, Long> implements ComplexObject<EmploymentContract>, ComplexObjectRelated<EmploymentContract> {

    public EmploymentContractDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void createFullfilled(EmploymentContract contract) {
        if (contract == null) { 
            return;
        }
        em.getTransaction().begin();
        em.persist(contract);
        CompanyDAO companyDAO = new CompanyDAO(em);
        companyDAO.creatingFullfilled(contract.getCompany());
        ProfessionDAO professionDAO = new ProfessionDAO(em);
        professionDAO.creatingFullfilled(contract.getProfession());
        em.merge(contract);
        em.getTransaction().commit();
    }

    @Override
    public void creatingFullfilled(EmploymentContract contract) {
        if (contract == null) { 
            return;
        }
        em.persist(contract);
        CompanyDAO companyDAO = new CompanyDAO(em);
        companyDAO.creatingFullfilled(contract.getCompany());
        ProfessionDAO professionDAO = new ProfessionDAO(em);
        professionDAO.creatingFullfilled(contract.getProfession());
        em.merge(contract);
    }
    
}
