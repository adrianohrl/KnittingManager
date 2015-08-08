/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.agents.Person;
import kmm.dao.ComplexObjectRelated;
import kmm.documents.CNH;
import kmm.documents.RG;

/**
 *
 * @author adrianohrl
 */
public class RGDAO extends IndividualDocumentDAO<RG> implements ComplexObjectRelated<RG> {

    public RGDAO(EntityManager em) {
        super(em, RG.class);
    }
    
    @Override
    public void remove(RG rg) {
        if (rg == null) {
            return;
        }
        /*Person person = rg.getIndividual();
        person.setRg(null);
        CNH cnh = person.getCnh();
        if (cnh != null) {
            cnh.setRg(null);
            CNHDAO cnhDAO = new CNHDAO(em);
            cnhDAO.update(cnh);
        }*/
        super.remove(rg);
    }
    
}
