/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.dao.ComplexObjectRelated;
import kmm.dao.DAO;
import kmm.documents.Document;

/**
 *
 * @author adrianohrl
 * @param <D>
 */
public abstract class DocumentDAO<D extends Document> extends DAO<D, String> implements ComplexObjectRelated<D> {

    public DocumentDAO(EntityManager em) {
        super(em, Document.class);
    }

    protected DocumentDAO(EntityManager em, Class clazz) {
        super(em, clazz);
    }

    @Override
    public void creatingFullfilled(Object beingCreated, D document) {
        if (document == null) {
            return;
        }
        if (!isRegistered(document)) {
            em.persist(document);
        }
    }

    @Override
    public abstract void persist(Object beingCreated, D document);

    @Override
    public boolean isRegistered(D document) {
        return super.find(document.getNumber()) != null;
    }

}
