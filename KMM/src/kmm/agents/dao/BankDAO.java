/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.Bank;
import kmm.dao.ComplexObject;
import kmm.dao.ComplexObjectRelated;
import kmm.dao.DAO;

/**
 *
 * @author adrianohrl
 */
public class BankDAO extends DAO<Bank, String> implements ComplexObject<Bank>, ComplexObjectRelated<Bank> {

    public BankDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void createFullfilled(Bank bank) {
        if (bank == null) {
            return;
        }
        em.getTransaction().begin();
        em.persist(bank);
        AddressDAO addressDAO = new AddressDAO(em);
        addressDAO.creatingFullfilled(bank.getAddress());
        em.merge(bank);
        em.getTransaction().commit();
    }

    @Override
    public void creatingFullfilled(Bank bank) {
        if (bank == null) {
            return;
        }
        em.persist(bank);
    }
    
}
