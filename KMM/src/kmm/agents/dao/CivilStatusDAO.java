/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.CivilStatus;
import kmm.dao.NameableObjectDAO;

/**
 *
 * @author adrianohrl
 */
public class CivilStatusDAO extends NameableObjectDAO<CivilStatus> {

    public CivilStatusDAO(EntityManager em) {
        super(em, CivilStatus.class);
    }
    
}
