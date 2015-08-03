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
        super(em, Bank.class);
    }

    @Override
    public void createFullfilled(Bank bank) {
        if (bank == null) {
            return;
        }
        em.getTransaction().begin();
        this.persist(bank);
        em.getTransaction().commit();
    }

    @Override
    public void persist(Bank bank) {
        this.persist(bank, bank);
    }

    @Override
    public void creatingFullfilled(Object beingCreated, Bank bank) {
        if (beingCreated.equals(bank)) {
            em.merge(bank);
            return;
        }
        this.persist(beingCreated, bank);
    }

    @Override
    public void persist(Object beingCreated, Bank bank) {
        if (bank == null) {
            return;
        }
        if (!isRegistered(bank)) {
            em.persist(bank);
        }
        AddressDAO addressDAO = new AddressDAO(em);
        addressDAO.creatingFullfilled(beingCreated, bank.getAddress());
        em.merge(bank);
    }

    @Override
    public boolean isRegistered(Bank bank) {
        return super.find(bank.getName()) != null;
    }

}
