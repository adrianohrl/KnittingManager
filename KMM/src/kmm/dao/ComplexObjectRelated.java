/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.dao;

/**
 *
 * @author adrianohrl
 * @param <T>
 */
public interface ComplexObjectRelated<T> {
    
    public abstract void creatingFullfilled(Object beingCreated, T t);
    
    public abstract void persist(Object beingCreated, T t);
    
}
