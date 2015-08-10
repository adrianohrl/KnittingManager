/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.dao.DAO;
import kmm.documents.SalaryAlteration;

/**
 *
 * @author adrianohrl
 */
public class SalaryAlterationDAO extends DAO<SalaryAlteration, Long> {

    public SalaryAlterationDAO(EntityManager em) {
        super(em, SalaryAlteration.class);
    }

    @Override
    public boolean isRegistered(SalaryAlteration salaryAlteration) {
        return super.find(salaryAlteration.getCode()) != null;
    }

}
