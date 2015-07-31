/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.Dependent;
import kmm.agents.Employee;
import kmm.agents.PeriodicalExam;
import kmm.dao.ComplexObjectRelated;
import kmm.documents.dao.CarteiraDeTrabalhoDAO;
import kmm.documents.dao.PISDAO;
import kmm.paycheck.dao.SalaryDAO;
import kmm.paycheck.dao.ScheduleDAO;

/**
 *
 * @author adrianohrl
 * @param <E>
 */
public class EmployeeDAO<E extends Employee> extends PersonWithSkillsDAO<E> implements ComplexObjectRelated<E> {

    public EmployeeDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void createFullfilled(E employee) {
        this.creatingFullfilled(employee);
        em.getTransaction().commit();
    }

    @Override
    public void creatingFullfilled(E employee) {
        super.creatingFullfilled(employee);
        ProfessionDAO professionDAO = new ProfessionDAO(em);
        professionDAO.creatingFullfilled(employee.getProfession());
        WorkingPeriodDAO periodDAO = new WorkingPeriodDAO(em);
        periodDAO.creatingFullfilled(employee.getPeriod());
        PeriodicalExamDAO examDAO = new PeriodicalExamDAO(em);
        for (PeriodicalExam exam : employee.getExams()) {
            examDAO.creatingFullfilled(exam);
        }
        examDAO.creatingFullfilled(employee.getLastExam());
        CarteiraDeTrabalhoDAO carteiraDeTrabalhoDAO = new CarteiraDeTrabalhoDAO(em);
        carteiraDeTrabalhoDAO.creatingFullfilled(employee.getCarteiraDeTrabalho());
        PISDAO pisDAO = new PISDAO(em);
        pisDAO.creatingFullfilled(employee.getPis());
        DependentDAO dependentDAO = new DependentDAO(em);
        for (Dependent dependent: employee.getDependents()) {
            dependentDAO.creatingFullfilled(dependent);
        }
        SalaryDAO salaryDAO = new SalaryDAO(em);
        salaryDAO.creatingFullfilled(employee.getSalary());
        ScheduleDAO scheduleDAO = new ScheduleDAO(em);
        scheduleDAO.creatingFullfilled(employee.getSchedule());
        em.merge(employee);
    }
    
}
