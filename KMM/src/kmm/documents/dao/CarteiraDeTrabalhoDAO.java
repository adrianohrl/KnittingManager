/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents.dao;

import javax.persistence.EntityManager;
import kmm.dao.ComplexObject;
import kmm.dao.ComplexObjectRelated;
import kmm.documents.CarteiraDeTrabalho;
import kmm.documents.EmploymentContract;
import kmm.documents.SalaryAlteration;
import kmm.documents.VacationNote;

/**
 *
 * @author adrianohrl
 */
public class CarteiraDeTrabalhoDAO extends IndividualDocumentDAO<CarteiraDeTrabalho> implements ComplexObject<CarteiraDeTrabalho>, ComplexObjectRelated<CarteiraDeTrabalho> {

    public CarteiraDeTrabalhoDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void createFullfilled(CarteiraDeTrabalho carteiraDeTrabalho) {
        this.creatingFullfilled(carteiraDeTrabalho);
        em.getTransaction().commit();
    }

    @Override
    public void creatingFullfilled(CarteiraDeTrabalho carteiraDeTrabalho) {
        super.creatingFullfilled(carteiraDeTrabalho);
        EmploymentContractDAO contractDAO = new EmploymentContractDAO(em);
        for (EmploymentContract contract: carteiraDeTrabalho.getContracts()) {
            contractDAO.creatingFullfilled(contract);
        }
        SalaryAlterationDAO salaryAlterationDAO = new SalaryAlterationDAO(em);
        for (SalaryAlteration salaryAlteration : carteiraDeTrabalho.getSalaryAlterations()) {
            salaryAlterationDAO.creatingFullfilled(salaryAlteration);
        }
        VacationNoteDAO vacationNoteDAO = new VacationNoteDAO(em);
        for (VacationNote vacationNote : carteiraDeTrabalho.getVacationNotes()) {
            vacationNoteDAO.creatingFullfilled(vacationNote);
        }
        em.merge(carteiraDeTrabalho);
    }
    
}
