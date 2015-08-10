/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.documents.CarteiraDeTrabalho;

/**
 *
 * @author adrianohrl
 */
public class CarteiraDeTrabalhoDAO extends IndividualDocumentDAO<CarteiraDeTrabalho> {

    public CarteiraDeTrabalhoDAO(EntityManager em) {
        super(em, CarteiraDeTrabalho.class);
    }

}
