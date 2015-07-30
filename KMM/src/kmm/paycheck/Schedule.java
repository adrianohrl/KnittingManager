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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import kmm.agents.Employee;

/**
 *
 * @author adrianohrl
 */
@Entity
public class Schedule implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long code;
    private float workload; //in minutes
    @OneToOne
    private Employee employee;
    @OneToMany
    private List<DailyEstablishedHour> bankOfHours = new ArrayList<>();
    public static final int NUMBER_OF_MINUTES_PER_HOUR = 60;
    public static final int NUMBER_OF_WEEKS_PER_MONTH = 5;
    public static final int NUMBER_OF_HOURS_PER_WEEK = 44;
    public static final int NUMBER_OF_HOURS_PER_MONTH = 220;

    public Schedule() {
    }

    public Schedule(Employee employee, List<DailyEstablishedHour> bankOfHours) {
        this.employee = employee;
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

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public float getWorkload() {
        return workload;
    }

    public void setWorkload(float workload) {
        this.workload = workload;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<DailyEstablishedHour> getBankOfHours() {
        return bankOfHours;
    }

    public void setBankOfHours(List<DailyEstablishedHour> bankOfHours) {
        this.bankOfHours = bankOfHours;
    }
    
}
