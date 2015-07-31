/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.dao;

/**
 *
 * @author adrianohrl
 * @param <O>
 */
public interface ComplexObject<O> {
    
    public abstract void createFullfilled(O o);
    
}
