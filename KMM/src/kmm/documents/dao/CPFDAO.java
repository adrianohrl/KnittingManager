/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.documents.CPF;

/**
 *
 * @author adrianohrl
 */
public class CPFDAO extends IndividualDocumentDAO<CPF> {

    public CPFDAO(EntityManager em) {
        super(em, CPF.class);
    }
    
    @Override
    public void remove(CPF cpf) {
        if (cpf == null) {
            return;
        }
        /*Person person = cpf.getIndividual();
        person.setCpf(null);
        CNH cnh = person.getCnh();
        if (cnh != null) {
            cnh.setCpf(null);
            CNHDAO cnhDAO = new CNHDAO(em);
            cnhDAO.update(cnh);
        }*/
        super.remove(cpf);
    }
    
}
