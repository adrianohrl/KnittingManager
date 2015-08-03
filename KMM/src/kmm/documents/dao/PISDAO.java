/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.agents.dao.BankDAO;
import kmm.documents.PIS;

/**
 *
 * @author adrianohrl
 */
public class PISDAO extends IndividualDocumentDAO<PIS> {

    public PISDAO(EntityManager em) {
        super(em, PIS.class);
    }

    @Override
    public void persist(Object beingCreated, PIS pis) {
        if (pis == null) {
            return;
        }
        super.persist(beingCreated, pis);
        BankDAO bankDAO = new BankDAO(em);
        bankDAO.creatingFullfilled(beingCreated, pis.getBank());
        em.merge(pis);
    }

}
