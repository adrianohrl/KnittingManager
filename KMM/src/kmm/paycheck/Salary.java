/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import kmm.agents.Employee;

/**
 *
 * @author adrianohrl
 */
@Entity
public class Salary implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long code;
    private float amount;
    private boolean perUnit = false;
    private String periodOfTime;
    @Temporal(TemporalType.DATE)
    private Calendar assignedDate;
    public static final int NUMBER_OF_WEEKS_PER_MONTH = 5;
    public static final int NUMBER_OF_HOURS_PER_WEEK = 44;
    public static final int NUMBER_OF_HOURS_PER_MONTH = 220;
    @OneToOne
    private Employee employee;
    @OneToMany
    private List<Extra> extras = new ArrayList<>();

    public Salary(float amount, boolean perUnit, String periodOfTime, Calendar assignedDate, Employee employee, List<Extra> extras) {
        this.amount = amount;
        this.perUnit = perUnit;
        this.periodOfTime = periodOfTime;
        this.assignedDate = assignedDate;
        this.employee = employee;
        this.extras = extras;
    }

    public Salary() {
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public boolean isPerUnit() {
        return perUnit;
    }

    public void setPerUnit(boolean perUnit) {
        this.perUnit = perUnit;
    }

    public String getPeriodOfTime() {
        return periodOfTime;
    }

    public void setPeriodOfTime(String periodOfTime) {
        this.periodOfTime = periodOfTime;
    }

    public Calendar getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Calendar assignedDate) {
        this.assignedDate = assignedDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }
    
}
