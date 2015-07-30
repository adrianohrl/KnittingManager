/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck;

/**
 *
 * @author adrianohrl
 */
public class ArrivalAndDeparture {
    
    private float workload;
    private final TimeClockEvent arrival;
    private final TimeClockEvent departure;

    public ArrivalAndDeparture(TimeClockEvent arrival, TimeClockEvent departure) {
        this.arrival = arrival;
        this.departure = departure;
        this.calculateWorkload();
    }
    
    private void calculateWorkload() {
        this.workload = TimeClockEvent.differenceInMinutes(arrival, departure);
    }

    public float getWorkload() {
        return workload;
    }
    
}
