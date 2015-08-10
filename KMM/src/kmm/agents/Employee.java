/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import kmm.documents.CarteiraDeTrabalho;
import kmm.documents.PIS;
import kmm.paycheck.Salary;
import kmm.paycheck.Schedule;

/**
 *
 * @author adrianohrl
 */
@Entity
public class Employee extends PersonWithSkills {
    
    private int bookNumber;
    private int pageNumber;
    @Temporal(TemporalType.DATE)
    private Calendar hiringDate;
    @Temporal(TemporalType.DATE)
    private Calendar firingDate;
    private float workload;
    @ManyToOne
    private Profession profession;
    @ManyToOne
    private WorkingPeriod workingPeriod;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PeriodicalExam> exams = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    private PeriodicalExam lastExam;
    @OneToOne(cascade = CascadeType.ALL)
    private CarteiraDeTrabalho carteiraDeTrabalho;
    @OneToOne(cascade = CascadeType.ALL)
    private PIS pis;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dependent> dependents = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    private Salary salary;
    @OneToOne(cascade = CascadeType.ALL)
    private Schedule schedule;

    public Employee() {
    }
    
    public Employee(Person employee) {
        super(employee);
    }
    
    public Employee(Employee employee) {
        super(employee);
        this.bookNumber = employee.bookNumber;
        this.pageNumber = employee.pageNumber;
        this.hiringDate = employee.hiringDate;
        this.firingDate = employee.firingDate;
        this.workload = employee.workload;
        this.profession = employee.profession;
        this.workingPeriod = employee.workingPeriod;
        this.exams = employee.exams;
        this.lastExam = employee.lastExam;
        this.carteiraDeTrabalho = employee.carteiraDeTrabalho;
        this.pis = employee.pis;
        this.dependents = employee.dependents;
        this.salary = employee.salary;
        this.schedule = employee.schedule;
    }

    public Employee(int bookNumber, int pageNumber, Calendar hiringDate, Calendar firingDate, float workload, Profession profession, WorkingPeriod period, CarteiraDeTrabalho carteiraDeTrabalho, PIS pis, Salary salary, Schedule schedule, List<Skill> skills, Person person) {
        super(skills, person);
        this.bookNumber = bookNumber;
        this.pageNumber = pageNumber;
        this.hiringDate = hiringDate;
        this.firingDate = firingDate;
        this.workload = workload;
        this.profession = profession;
        this.workingPeriod = period;
        this.carteiraDeTrabalho = carteiraDeTrabalho;
        this.pis = pis;
        this.salary = salary;
        this.schedule = schedule;
    }
    
    public PeriodicalExam calculateLastExam() {
        PeriodicalExam lastExam = null;
        for (PeriodicalExam exam : exams) {
            if (lastExam == null || exam.after(lastExam)) {
                lastExam = exam;
            }
        }
        return lastExam;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Calendar getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Calendar hiringDate) {
        this.hiringDate = hiringDate;
    }

    public Calendar getFiringDate() {
        return firingDate;
    }

    public void setFiringDate(Calendar firingDate) {
        this.firingDate = firingDate;
    }

    public float getWorkload() {
        return workload;
    }

    public void setWorkload(float workload) {
        this.workload = workload;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public WorkingPeriod getWorkingPeriod() {
        return workingPeriod;
    }

    public void setWorkingPeriod(WorkingPeriod workingPeriod) {
        this.workingPeriod = workingPeriod;
    }

    public List<PeriodicalExam> getExams() {
        return exams;
    }

    public void setExams(List<PeriodicalExam> exams) {
        this.exams = exams;
    }

    public PeriodicalExam getLastExam() {
        return lastExam;
    }

    public void setLastExam(PeriodicalExam lastExam) {
        this.lastExam = lastExam;
    }

    public CarteiraDeTrabalho getCarteiraDeTrabalho() {
        return carteiraDeTrabalho;
    }

    public void setCarteiraDeTrabalho(CarteiraDeTrabalho carteiraDeTrabalho) {
        this.carteiraDeTrabalho = carteiraDeTrabalho;
    }

    public PIS getPis() {
        return pis;
    }

    public void setPis(PIS pis) {
        this.pis = pis;
    }

    public List<Dependent> getDependents() {
        return dependents;
    }

    public void setDependents(List<Dependent> dependents) {
        this.dependents = dependents;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    
}
