/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.agents.dao.PersonDAO;
import kmm.dao.ComplexObject;
import kmm.dao.ComplexObjectRelated;
import kmm.documents.IndividualDocument;

/**
 *
 * @author adrianohrl
 * @param <ID>
 */
public abstract class IndividualDocumentDAO<ID extends IndividualDocument> extends DocumentDAO<ID> implements ComplexObject<ID>, ComplexObjectRelated<ID> {

    public IndividualDocumentDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void createFullfilled(ID individualDocument) {
        if (individualDocument == null) {
            return;
        }
        em.getTransaction().begin();
        em.persist(individualDocument);
        PersonDAO personDAO = new PersonDAO(em);
        personDAO.creatingFullfilled(individualDocument.getIndividual());
        em.merge(individualDocument);
        em.getTransaction().commit();        
    }

    @Override
    public void creatingFullfilled(ID individualDocument) {
        if (individualDocument == null) { 
            return;
        }
        em.persist(individualDocument);
        PersonDAO personDAO = new PersonDAO(em);
        personDAO.creatingFullfilled(individualDocument.getIndividual());
        em.merge(individualDocument);
    }
    
}
