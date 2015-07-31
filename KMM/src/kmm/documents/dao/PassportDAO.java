/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.dao.ComplexObjectRelated;
import kmm.documents.Passport;

/**
 *
 * @author adrianohrl
 */
public class PassportDAO extends IndividualDocumentDAO<Passport> implements ComplexObjectRelated<Passport> {

    public PassportDAO(EntityManager em) {
        super(em);
    }
    
}
