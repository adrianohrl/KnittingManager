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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import kmm.agents.Employee;

/**
 *
 * @author adrianohrl
 */
@Entity
public class SalaryAlteration implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long code;    
    private float newSalary;
    @Temporal(TemporalType.DATE)
    private Calendar alterationDate;
    private String reason;
    @OneToOne
    private Employee responsible;

    public SalaryAlteration() {
    }

    public SalaryAlteration(float newSalary, Calendar alterationDate, String reason, Employee responsible) {
        this.newSalary = newSalary;
        this.alterationDate = alterationDate;
        this.reason = reason;
        this.responsible = responsible;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public float getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(float newSalary) {
        this.newSalary = newSalary;
    }

    public Calendar getAlterationDate() {
        return alterationDate;
    }

    public void setAlterationDate(Calendar alterationDate) {
        this.alterationDate = alterationDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Employee getResponsible() {
        return responsible;
    }

    public void setResponsible(Employee responsible) {
        this.responsible = responsible;
    }
    
}
