/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.dao.DAO;
import kmm.documents.VacationNote;

/**
 *
 * @author adrianohrl
 */
public class VacationNoteDAO extends DAO<VacationNote, Long> {

    public VacationNoteDAO(EntityManager em) {
        super(em);
    }
    
}
