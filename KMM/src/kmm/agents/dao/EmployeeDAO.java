/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.Employee;

/**
 *
 * @author adrianohrl
 * @param <E>
 */
public class EmployeeDAO<E extends Employee> extends PersonWithSkillsDAO<E> {

    public EmployeeDAO(EntityManager em) {
        super(em, Employee.class);
    }

    protected EmployeeDAO(EntityManager em, Class clazz) {
        super(em, clazz);
    }

}
