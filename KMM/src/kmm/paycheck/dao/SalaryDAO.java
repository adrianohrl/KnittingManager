/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck.dao;

import javax.persistence.EntityManager;
import kmm.dao.DAO;
import kmm.paycheck.Salary;

/**
 *
 * @author adrianohrl
 */
public class SalaryDAO extends DAO<Salary, Long> {

    public SalaryDAO(EntityManager em) {
        super(em);
    }
    
}
