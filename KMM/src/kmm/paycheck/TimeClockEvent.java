/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck;

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
public class TimeClockEvent implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long code;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar eventDate;
    @OneToOne
    private Employee employee;

    public TimeClockEvent() {
    }

    public TimeClockEvent(Calendar eventDate, Employee employee) {
        this.eventDate = eventDate;
        this.employee = employee;
    }
    
    /*public TimeClockEvent(String ddmmyyyyhhmmIIIIII) {
        if (ddmmyyyyhhmmIIIIII.length() == 18) {
            int day = Integer.parseInt(ddmmyyyyhhmmIIIIII.substring(0, 1));
            int month = Integer.parseInt(ddmmyyyyhhmmIIIIII.substring(2, 3));
            int year = Integer.parseInt(ddmmyyyyhhmmIIIIII.substring(4, 7));
            int hour = Integer.parseInt(ddmmyyyyhhmmIIIIII.substring(8, 9));
            int minute = Integer.parseInt(ddmmyyyyhhmmIIIIII.substring(10, 11));
            int employeeIdentifier = Integer.parseInt(ddmmyyyyhhmmIIIIII.substring(12, 17));
            eventDate = new GregorianCalendar(year, month, day, hour, minute);
        }
    }*/
    
    public boolean before(TimeClockEvent when) {
        return this.eventDate.before(when.eventDate);
    }
    
    public boolean after(TimeClockEvent when) {
        return this.eventDate.before(when.eventDate);
    }
    
    public static float differenceInMinutes(TimeClockEvent minuend, TimeClockEvent subtrahend) { 
        return (minuend.getEventDate().getTimeInMillis() - subtrahend.getEventDate().getTimeInMillis()) / 60000;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Calendar getEventDate() {
        return eventDate;
    }

    public void setEventDate(Calendar eventDate) {
        this.eventDate = eventDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
}
