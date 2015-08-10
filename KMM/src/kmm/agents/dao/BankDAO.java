/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.Bank;
import kmm.dao.DAO;

/**
 *
 * @author adrianohrl
 */
public class BankDAO extends DAO<Bank, String> {

    public BankDAO(EntityManager em) {
        super(em, Bank.class);
    }

    @Override
    public boolean isRegistered(Bank bank) {
        return super.find(bank.getName()) != null;
    }

}
