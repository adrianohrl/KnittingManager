/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.dao.ComplexObject;
import kmm.dao.ComplexObjectRelated;
import kmm.documents.CNH;

/**
 *
 * @author adrianohrl
 */
public class CNHDAO extends IndividualDocumentDAO<CNH> implements ComplexObject<CNH>, ComplexObjectRelated<CNH> {

    public CNHDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void createFullfilled(CNH cnh) {
        this.creatingFullfilled(cnh);
        em.getTransaction().commit();
    }

    @Override
    public void creatingFullfilled(CNH cnh) {
        super.createFullfilled(cnh);
        RGDAO rgDAO = new RGDAO(em);
        rgDAO.creatingFullfilled(cnh.getRg());
        CPFDAO cpfDAO = new CPFDAO(em);
        cpfDAO.creatingFullfilled(cnh.getCpf());
        em.merge(cnh);
    }
    
}
