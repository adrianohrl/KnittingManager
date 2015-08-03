/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck.dao;

import javax.persistence.EntityManager;
import kmm.dao.ComplexObjectRelated;
import kmm.dao.DAO;
import kmm.paycheck.DailyEstablishedHour;

/**
 *
 * @author adrianohrl
 */
public class DailyEstablishedHourDAO extends DAO<DailyEstablishedHour, Long> implements ComplexObjectRelated<DailyEstablishedHour> {

    public DailyEstablishedHourDAO(EntityManager em) {
        super(em, DailyEstablishedHour.class);
    }

    @Override
    public void creatingFullfilled(Object beingCreated, DailyEstablishedHour dailyEstablishedHour) {
        this.persist(beingCreated, dailyEstablishedHour);
    }

    @Override
    public void persist(Object beingCreated, DailyEstablishedHour dailyEstablishedHour) {
        if (dailyEstablishedHour == null) {
            return;
        }
        if (!isRegistered(dailyEstablishedHour)) {
            em.persist(dailyEstablishedHour);
        }
    }

    @Override
    public boolean isRegistered(DailyEstablishedHour dailyEstablishedHour) {
        return super.find(dailyEstablishedHour.getCode()) != null;
    }

}
