/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.documents.CarteiraDeReservista;

/**
 *
 * @author adrianohrl
 */
public class CarteiraDeReservistaDAO extends IndividualDocumentDAO<CarteiraDeReservista> {

    public CarteiraDeReservistaDAO(EntityManager em) {
        super(em, CarteiraDeReservista.class);
    }

    @Override
    public void remove(CarteiraDeReservista reservista) {
        if (reservista == null) {
            return;
        }
        //reservista.getIndividual().setReservista(null);
        super.remove(reservista); 
    }
    
}
