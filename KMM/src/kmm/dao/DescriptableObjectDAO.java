/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.dao;

import javax.persistence.EntityManager;
import kmm.DescriptableObject;

/**
 *
 * @author adrianohrl
 * @param <D>
 */
public abstract class DescriptableObjectDAO<D extends DescriptableObject> extends NameableObjectDAO<D> {

    public DescriptableObjectDAO(EntityManager em) {
        super(em, DescriptableObject.class);
    }
    
    protected DescriptableObjectDAO(EntityManager em, Class clazz) {
        super(em, clazz);
    }
    
}
