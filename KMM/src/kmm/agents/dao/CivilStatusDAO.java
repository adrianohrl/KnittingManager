/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.CivilStatus;
import kmm.dao.ComplexObjectRelated;
import kmm.dao.NameableObjectDAO;

/**
 *
 * @author adrianohrl
 */
public class CivilStatusDAO extends NameableObjectDAO<CivilStatus> implements ComplexObjectRelated<CivilStatus> {

    public CivilStatusDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void creatingFullfilled(CivilStatus civilStatus) {
        if (civilStatus == null) {
            return;
        }
        em.persist(civilStatus);
    }
    
}
