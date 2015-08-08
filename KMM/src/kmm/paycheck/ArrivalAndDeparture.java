/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck;

import com.mysql.jdbc.NotImplemented;
import java.sql.Time;
import java.time.MonthDay;
import java.util.List;
import kmm.agents.Employee;

/**
 *
 * @author adrianohrl
 */
public class ArrivalAndDeparture {
    
    private Employee employee;
    private MonthDay day;
    private final TimeClockEvent arrival;
    private final TimeClockEvent departure;
    private Time previousArrival;
    private Time nextDeparture;
    private List<Workload> workload;
    
    public ArrivalAndDeparture(TimeClockEvent arrival, TimeClockEvent departure) {
        /////////////// gerar o restante tbm
        this.arrival = arrival;
        this.departure = departure;
        this.calculateWorkload();
    }
    
    private void calculateWorkload() {
        //this.workload = TimeClockEvent.differenceInMinutes(arrival, departure);
    }

    public Employee getEmployee() {
        return employee;
    }

    public MonthDay getDay() {
        return day;
    }

    public TimeClockEvent getArrival() {
        return arrival;
    }

    public TimeClockEvent getDeparture() {
        return departure;
    }

    public List<Workload> getWorkload() {
        return workload;
    }

    public Time getPreviousArrival() {
        return previousArrival;
    }

    public Time getNextDeparture() {
        return nextDeparture;
    }
    
}
