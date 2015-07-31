/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.Address;
import kmm.dao.ComplexObjectRelated;
import kmm.dao.DAO;

/**
 *
 * @author adrianohrl
 */
public class AddressDAO extends DAO<Address, Long> implements ComplexObjectRelated<Address> {

    public AddressDAO(EntityManager em) {
        super(em);
    }
    
    @Override
    public void creatingFullfilled(Address address) {
        if (address == null) {
            return;
        }
        em.persist(address);
    }
    
}
