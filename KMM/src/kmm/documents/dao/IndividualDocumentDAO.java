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
        super(em, IndividualDocument.class);
    }

    protected IndividualDocumentDAO(EntityManager em, Class clazz) {
        super(em, clazz);
    }

    @Override
    public void createFullfilled(ID individualDocument) {
        if (individualDocument == null) {
            return;
        }
        em.getTransaction().begin();
        this.persist(individualDocument);
        em.getTransaction().commit();
    }

    @Override
    public void persist(ID individualDocument) {
        this.persist(individualDocument, individualDocument);
    }

    @Override
    public void creatingFullfilled(Object beingCreated, ID individualDocument) {
        if (beingCreated.equals(individualDocument)) {
            em.merge(individualDocument);
            return;
        }
        this.persist(beingCreated, individualDocument);
    }

    @Override
    public void persist(Object beingCreated, ID individualDocument) {
        if (individualDocument == null) {
            return;
        }
        if (!isRegistered(individualDocument)) {
            em.persist(individualDocument);
        }
        PersonDAO personDAO = new PersonDAO(em);
        //personDAO.creatingFullfilled(beingCreated, individualDocument.getIndividual());
        em.merge(individualDocument);
    }
    
    public void remove(ID individualDocument) {
        if (individualDocument == null || !isRegistered(individualDocument)) {
            return;
        }
        //individualDocument.setIndividual(null);
        super.update(individualDocument);
        super.remove(individualDocument.getNumber());
    }

}
