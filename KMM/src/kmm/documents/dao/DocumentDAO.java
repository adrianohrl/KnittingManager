/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.dao.DAO;
import kmm.documents.Document;

/**
 *
 * @author adrianohrl
 * @param <D>
 */
public abstract class DocumentDAO<D extends Document> extends DAO<D, String> {

    public DocumentDAO(EntityManager em) {
        super(em);
    }
    
}
