/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.documents.PIS;

/**
 *
 * @author adrianohrl
 */
public class PISDAO extends IndividualDocumentDAO<PIS> {

    public PISDAO(EntityManager em) {
        super(em);
    }
    
}
