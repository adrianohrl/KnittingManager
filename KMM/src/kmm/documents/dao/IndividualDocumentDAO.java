/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.documents.IndividualDocument;

/**
 *
 * @author adrianohrl
 * @param <ID>
 */
public abstract class IndividualDocumentDAO<ID extends IndividualDocument> extends DocumentDAO<ID> {

    public IndividualDocumentDAO(EntityManager em) {
        super(em);
    }
    
}
