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
public class SalaryDAO extends DAO<Salary, String> {

    public SalaryDAO(EntityManager em) {
        super(em, Salary.class);
    }

    @Override
    public boolean isRegistered(Salary salary) {
        return super.find(salary.getEmployeeName()) != null;
    }

}
