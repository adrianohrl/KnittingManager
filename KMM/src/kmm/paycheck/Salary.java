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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import kmm.agents.Employee;
import kmm.agents.EmployeeRelated;

/**
 *
 * @author adrianohrl
 */
@Entity
public class Salary implements Serializable, EmployeeRelated {
    
    @Id
    private String employeeName;
    private float amount;
    private boolean perUnit = false;
    @OneToOne
    private PaymentPeriod paymentPeriod;
    @Temporal(TemporalType.DATE)
    private Calendar assignedDate;
    public static final int NUMBER_OF_WEEKS_PER_MONTH = 5;
    public static final int NUMBER_OF_HOURS_PER_WEEK = 44;
    public static final int NUMBER_OF_HOURS_PER_MONTH = 220;
    @OneToMany
    private List<Extra> extras = new ArrayList<>();

    public Salary() {
    }

    public Salary(float amount, boolean perUnit, PaymentPeriod period, Calendar assignedDate, Employee employee, List<HourType> types) {
        this.amount = amount;
        this.perUnit = perUnit;
        this.paymentPeriod = period;
        this.assignedDate = assignedDate;
        this.employeeName = employee.getName();
        for (HourType type : types) {
            float extraAmount = (1 + type.getPercentage()) * this.amount;
            extras.add(new Extra(extraAmount, type));
        }
    }

    @Override
    public void setEmployee(Employee employee) {
        this.employeeName = employee.getName();
    }
    
    public void setExtrasUsingTypes(List<HourType> types) {
        if (!paymentPeriod.isTemporal()) {
            return;
        }
        for (HourType type : types) {
            float extraAmount = (1 + type.getPercentage()) * getAmountPerHours();
            extras.add(new Extra(extraAmount, type));
        }
    }
    
    private float getAmountPerHours() {
        return paymentPeriod.getConversionFactor() * amount / NUMBER_OF_HOURS_PER_MONTH;
    }

    public void setAssignedDate(Calendar assignedDate) {
        this.assignedDate = assignedDate;
    }

    public String getEmployeeName() {
        return employeeName;
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

    public PaymentPeriod getPaymentPeriod() {
        return paymentPeriod;
    }

    public void setPaymentPeriod(PaymentPeriod paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
    }

    public Calendar getAssignedDate() {
        return assignedDate;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }
    
}
