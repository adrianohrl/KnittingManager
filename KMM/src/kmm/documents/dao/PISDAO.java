/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.agents.dao.BankDAO;
import kmm.dao.ComplexObject;
import kmm.dao.ComplexObjectRelated;
import kmm.documents.PIS;

/**
 *
 * @author adrianohrl
 */
public class PISDAO extends IndividualDocumentDAO<PIS> implements ComplexObject<PIS>, ComplexObjectRelated<PIS> {

    public PISDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void createFullfilled(PIS pis) {
        this.creatingFullfilled(pis);
        em.getTransaction().commit();
    }

    @Override
    public void creatingFullfilled(PIS pis) {
        super.creatingFullfilled(pis);
        BankDAO bankDAO = new BankDAO(em);
        bankDAO.creatingFullfilled(pis.getBank());
        em.merge(pis);
    }
    
}
