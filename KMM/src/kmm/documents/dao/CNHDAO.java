/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.documents.CNH;

/**
 *
 * @author adrianohrl
 */
public class CNHDAO extends IndividualDocumentDAO<CNH> {

    public CNHDAO(EntityManager em) {
        super(em, CNH.class);
    }

    @Override
    public void persist(Object beingCreated, CNH cnh) {
        if (cnh == null) {
            return;
        }
        super.persist(beingCreated, cnh);
        RGDAO rgDAO = new RGDAO(em);
        rgDAO.creatingFullfilled(beingCreated, cnh.getRg());
        CPFDAO cpfDAO = new CPFDAO(em);
        cpfDAO.creatingFullfilled(beingCreated, cnh.getCpf());
        em.merge(cnh);
    }

}
