/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents;

import java.util.Calendar;
import kmm.agents.Employee;

/**
 *
 * @author adrianohrl
 */
public class SalaryAlteration {
    
    private long code;    
    private float newSalary;
    private Calendar alterationDate;
    private String reason;
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
