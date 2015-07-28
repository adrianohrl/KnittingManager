/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kmm.documents.CNH;
import kmm.documents.CPF;
import kmm.documents.CarteiraDeReservista;
import kmm.documents.CarteiraDeTrabalho;
import kmm.documents.PIS;
import kmm.documents.RG;
import kmm.documents.TituloDeEleitor;
import kmm.paycheck.Salary;
import kmm.paycheck.Schedule;

/**
 *
 * @author adrianohrl
 */
public class Employee extends Person {
    
    private int bookNumber;
    private int pageNumber;
    private Calendar hiringDate;
    private Calendar firingDate;
    private float workload;
    private Profession profession;
    private WorkingPeriod period;
    private List<PeriodicalExam> exams = new ArrayList<>();
    private PeriodicalExam lastExam;
    private CarteiraDeTrabalho carteiraDeTrabalho;
    private PIS pis;
    private List<Skill> skills = new ArrayList<>();
    private List<Dependent> dependents = new ArrayList<>();
    private Salary salary;
    private Schedule schedule;

    public Employee() {
    }
    
    public Employee(Employee employee) {
        super(employee);
        this.bookNumber = employee.bookNumber;
        this.pageNumber = employee.pageNumber;
        this.hiringDate = employee.hiringDate;
        this.firingDate = employee.firingDate;
        this.workload = employee.workload;
        this.profession = employee.profession;
        this.period = employee.period;
        this.exams = employee.exams;
        this.lastExam = employee.lastExam;
        this.carteiraDeTrabalho = employee.carteiraDeTrabalho;
        this.pis = employee.pis;
        this.skills = employee.skills;
        this.dependents = employee.dependents;
        this.salary = employee.salary;
        this.schedule = employee.schedule;
    }

    public Employee(int bookNumber, int pageNumber, Calendar hiringDate, Calendar firingDate, float workload, Profession profession, WorkingPeriod period, CarteiraDeTrabalho carteiraDeTrabalho, PIS pis, Salary salary, Schedule schedule, Person person) {
        super(person);
        this.bookNumber = bookNumber;
        this.pageNumber = pageNumber;
        this.hiringDate = hiringDate;
        this.firingDate = firingDate;
        this.workload = workload;
        this.profession = profession;
        this.period = period;
        this.carteiraDeTrabalho = carteiraDeTrabalho;
        this.pis = pis;
        this.salary = salary;
        this.schedule = schedule;
    }

    public Employee(int bookNumber, int pageNumber, Calendar hiringDate, Calendar firingDate, float workload, Profession profession, WorkingPeriod period, CarteiraDeTrabalho carteiraDeTrabalho, PIS pis, Salary salary, Schedule schedule, String name, Calendar dob, String phone, String fatherName, String motherName, String nationality, String email, Gender gender, CivilStatus civilStatus, Address address, RG rg, CPF cpf, CNH cnh, TituloDeEleitor tituloDeEleitor, CarteiraDeReservista reservista) {
        super(name, dob, phone, fatherName, motherName, nationality, email, gender, civilStatus, address, rg, cpf, cnh, tituloDeEleitor, reservista);
        this.bookNumber = bookNumber;
        this.pageNumber = pageNumber;
        this.hiringDate = hiringDate;
        this.firingDate = firingDate;
        this.workload = workload;
        this.profession = profession;
        this.period = period;
        this.carteiraDeTrabalho = carteiraDeTrabalho;
        this.pis = pis;
        this.salary = salary;
        this.schedule = schedule;
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

    public WorkingPeriod getPeriod() {
        return period;
    }

    public void setPeriod(WorkingPeriod period) {
        this.period = period;
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

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
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
