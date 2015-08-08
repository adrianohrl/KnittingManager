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
        super(em, EmploymentContract.class);
    }

    @Override
    public void createFullfilled(EmploymentContract contract) {
        if (contract == null) {
            return;
        }
        em.getTransaction().begin();
        this.persist(contract);
        em.getTransaction().commit();
    }

    @Override
    public void persist(EmploymentContract contract) {
        this.persist(contract, contract);
    }

    @Override
    public void creatingFullfilled(Object beingCreated, EmploymentContract contract) {
        if (beingCreated.equals(contract)) {
            em.merge(contract);
            return;
        }
        this.persist(beingCreated, contract);
    }

    @Override
    public void persist(Object beingCreated, EmploymentContract contract) {
        if (contract == null) {
            return;
        }
        if (!isRegistered(contract)) {
            em.persist(contract);
        }
        CompanyDAO companyDAO = new CompanyDAO(em);
        //companyDAO.creatingFullfilled(beingCreated, contract.getCompany());
        ProfessionDAO professionDAO = new ProfessionDAO(em);
        //professionDAO.creatingFullfilled(beingCreated, contract.getProfession());
        em.merge(contract);
    }

    @Override
    public boolean isRegistered(EmploymentContract contract) {
        return super.find(contract.getCode()) != null;
    }

}
