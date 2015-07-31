/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.PeriodicalExam;
import kmm.dao.ComplexObjectRelated;
import kmm.dao.DAO;

/**
 *
 * @author adrianohrl
 */
public class PeriodicalExamDAO extends DAO<PeriodicalExam, Long> implements ComplexObjectRelated<PeriodicalExam> {

    public PeriodicalExamDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void creatingFullfilled(PeriodicalExam exam) {
        if (exam == null) {
            return;
        }
        em.persist(exam);
    }
    
}
