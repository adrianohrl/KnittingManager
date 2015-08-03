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
        super(em, Address.class);
    }

    @Override
    public void creatingFullfilled(Object beingCreated, Address address) {
        this.persist(beingCreated, address);
    }

    @Override
    public void persist(Object beingCreated, Address address) {
        if (address == null) {
            return;
        }
        if (!isRegistered(address)) {
            em.persist(address);
        }
    }

    @Override
    public boolean isRegistered(Address address) {
        return super.find(address.getCode()) != null;
    }

}
