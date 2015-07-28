/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents;

import java.util.Calendar;
import kmm.agents.Company;
import kmm.agents.Profession;

/**
 *
 * @author adrianohrl
 */
public class EmploymentContract {
    
    private long code;
    private Calendar hiringDate;
    private float salary;
    private Company company;
    private Profession profession;

    public EmploymentContract() {
    }

    public EmploymentContract(Calendar hiringDate, float salary, Company company, Profession profession) {
        this.hiringDate = hiringDate;
        this.salary = salary;
        this.company = company;
        this.profession = profession;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Calendar getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Calendar hiringDate) {
        this.hiringDate = hiringDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }
    
}
