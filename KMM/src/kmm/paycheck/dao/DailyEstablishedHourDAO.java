/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck.dao;

import javax.persistence.EntityManager;
import kmm.dao.DAO;
import kmm.paycheck.DailyEstablishedHour;

/**
 *
 * @author adrianohrl
 */
public class DailyEstablishedHourDAO extends DAO<DailyEstablishedHour, Long> {

    public DailyEstablishedHourDAO(EntityManager em) {
        super(em, DailyEstablishedHour.class);
    }

    @Override
    public boolean isRegistered(DailyEstablishedHour dailyEstablishedHour) {
        return super.find(dailyEstablishedHour.getCode()) != null;
    }

}
