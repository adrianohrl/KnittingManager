/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck.dao;

import javax.persistence.EntityManager;
import kmm.dao.DescriptableObjectDAO;
import kmm.paycheck.DayType;

/**
 *
 * @author adrianohrl
 */
public class DayTypeDAO extends DescriptableObjectDAO<DayType> {

    public DayTypeDAO(EntityManager em) {
        super(em);
    }
    
}
