/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.documents.CarteiraDeTrabalho;
import kmm.documents.EmploymentContract;
import kmm.documents.SalaryAlteration;
import kmm.documents.VacationNote;

/**
 *
 * @author adrianohrl
 */
public class CarteiraDeTrabalhoDAO extends IndividualDocumentDAO<CarteiraDeTrabalho> {

    public CarteiraDeTrabalhoDAO(EntityManager em) {
        super(em, CarteiraDeReservistaDAO.class);
    }

    @Override
    public void persist(Object beingCreated, CarteiraDeTrabalho carteiraDeTrabalho) {
        if (carteiraDeTrabalho == null) {
            return;
        }
        super.persist(beingCreated, carteiraDeTrabalho);
        EmploymentContractDAO contractDAO = new EmploymentContractDAO(em);
        for (EmploymentContract contract : carteiraDeTrabalho.getContracts()) {
            contractDAO.creatingFullfilled(beingCreated, contract);
        }
        SalaryAlterationDAO salaryAlterationDAO = new SalaryAlterationDAO(em);
        for (SalaryAlteration salaryAlteration : carteiraDeTrabalho.getSalaryAlterations()) {
            salaryAlterationDAO.creatingFullfilled(beingCreated, salaryAlteration);
        }
        VacationNoteDAO vacationNoteDAO = new VacationNoteDAO(em);
        for (VacationNote vacationNote : carteiraDeTrabalho.getVacationNotes()) {
            vacationNoteDAO.creatingFullfilled(beingCreated, vacationNote);
        }
        em.merge(carteiraDeTrabalho);
    }

}
