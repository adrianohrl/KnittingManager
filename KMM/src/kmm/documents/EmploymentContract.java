/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import kmm.agents.Company;
import kmm.agents.Profession;

/**
 *
 * @author adrianohrl
 */
@Entity
public class EmploymentContract implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long code;
    @Temporal(TemporalType.DATE)
    private Calendar hiringDate;
    private float salary;
    private String companyName;
    private String professionName;

    public EmploymentContract() {
    }

    public EmploymentContract(Calendar hiringDate, float salary, Company company, Profession profession) {
        this.hiringDate = hiringDate;
        this.salary = salary;
        this.companyName = company.getBusinessName();
        this.professionName = profession.getName();
    }

    public void setCompany(Company company) {
        this.companyName = company.getBusinessName();
    }

    public void setProfession(Profession profession) {
        this.professionName = profession.getName();
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }
    
}
