/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.dao.ComplexObjectRelated;
import kmm.documents.RG;

/**
 *
 * @author adrianohrl
 */
public class RGDAO extends IndividualDocumentDAO<RG> implements ComplexObjectRelated<RG> {

    public RGDAO(EntityManager em) {
        super(em);
    }
    
}
