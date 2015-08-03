/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.documents.TituloDeEleitor;

/**
 *
 * @author adrianohrl
 */
public class TituloDeEleitorDAO extends IndividualDocumentDAO<TituloDeEleitor> {

    public TituloDeEleitorDAO(EntityManager em) {
        super(em, TituloDeEleitor.class);
    }
    
}
