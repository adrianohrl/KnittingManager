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
        super(em, Employee.class);
    }

    protected EmployeeDAO(EntityManager em, Class clazz) {
        super(em, clazz);
    }

    @Override
    public void persist(Object beingCreated, E employee) {
        if (employee == null) {
            return;
        }
        super.persist(beingCreated, employee);
        ProfessionDAO professionDAO = new ProfessionDAO(em);
        professionDAO.creatingFullfilled(beingCreated, employee.getProfession());
        WorkingPeriodDAO periodDAO = new WorkingPeriodDAO(em);
        periodDAO.creatingFullfilled(beingCreated, employee.getPeriod());
        PeriodicalExamDAO examDAO = new PeriodicalExamDAO(em);
        for (PeriodicalExam exam : employee.getExams()) {
            examDAO.creatingFullfilled(beingCreated, exam);
        }
        examDAO.creatingFullfilled(beingCreated, employee.getLastExam());
        CarteiraDeTrabalhoDAO carteiraDeTrabalhoDAO = new CarteiraDeTrabalhoDAO(em);
        carteiraDeTrabalhoDAO.creatingFullfilled(beingCreated, employee.getCarteiraDeTrabalho());
        PISDAO pisDAO = new PISDAO(em);
        pisDAO.creatingFullfilled(beingCreated, employee.getPis());
        DependentDAO dependentDAO = new DependentDAO(em);
        for (Dependent dependent : employee.getDependents()) {
            dependentDAO.creatingFullfilled(beingCreated, dependent);
        }
        SalaryDAO salaryDAO = new SalaryDAO(em);
        salaryDAO.creatingFullfilled(beingCreated, employee.getSalary());
        ScheduleDAO scheduleDAO = new ScheduleDAO(em);
        scheduleDAO.creatingFullfilled(beingCreated, employee.getSchedule());
        em.merge(employee);
    }

}
