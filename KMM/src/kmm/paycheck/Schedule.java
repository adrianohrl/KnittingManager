/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import kmm.agents.Employee;
import kmm.agents.EmployeeRelated;

/**
 *
 * @author adrianohrl
 */
@Entity
public class Schedule implements Serializable, EmployeeRelated {
    
    @Id
    private String employeeName;
    private float workload; //in minutes
    @OneToMany
    private List<DailyEstablishedHour> bankOfHours = new ArrayList<>();
    public static final int NUMBER_OF_MINUTES_PER_HOUR = 60;
    public static final int NUMBER_OF_WEEKS_PER_MONTH = 5;
    public static final int NUMBER_OF_HOURS_PER_WEEK = 44;
    public static final int NUMBER_OF_HOURS_PER_MONTH = 220;

    public Schedule() {
    }

    public Schedule(Employee employee, List<DailyEstablishedHour> bankOfHours) {
        this.employeeName = employee.getName();
        this.bankOfHours = bankOfHours;
        this.calculateWorkload();
    }

    //in a mounth
    private void calculateWorkload() {
        float workload = 0;
        for (DailyEstablishedHour dailyBankOfHours : bankOfHours) {
            workload += dailyBankOfHours.getWorkload();
        }
        workload *= NUMBER_OF_WEEKS_PER_MONTH;
        this.workload = workload;
    }

    @Override
    public void setEmployee(Employee employee) {
        this.employeeName = employee.getName();
    }

    public float getWorkload() {
        return workload;
    }

    public void setWorkload(float workload) {
        this.workload = workload;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<DailyEstablishedHour> getBankOfHours() {
        return bankOfHours;
    }

    public void setBankOfHours(List<DailyEstablishedHour> bankOfHours) {
        this.bankOfHours = bankOfHours;
    }
    
}
