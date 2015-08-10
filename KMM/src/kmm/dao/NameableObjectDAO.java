/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.dao;

import javax.persistence.EntityManager;
import kmm.NameableObject;

/**
 *
 * @author adrianohrl
 * @param <N>
 */
public abstract class NameableObjectDAO<N extends NameableObject> extends DAO<N, String> {

    public NameableObjectDAO(EntityManager em) {
        super(em, NameableObject.class);
    }

    protected NameableObjectDAO(EntityManager em, Class clazz) {
        super(em, clazz);
    }

    @Override
    public boolean isRegistered(N nameable) {
        return super.find(nameable.getName()) != null;
    }

}
