/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author adrianohrl
 */
@Entity
public class DailyEstablishedHour implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long code;
    private boolean onMonday = false;
    private boolean onTuesday = false;
    private boolean onWednesday = false;
    private boolean onThursday = false;
    private boolean onFriday = false;
    private boolean onSaturday = false;
    private boolean onSunday = false;
    private int numberOfDays = 0;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar firstArrival;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar firstDeparture;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar secondArrival;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar secondDeparture;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar thirdArrival;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar thirdDeparture;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar forthArrival;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar forthDeparture;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fifthArrival;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fifthDeparture;
    private float workload; // in minutes

    private enum Cardinal {

        First(1), Second(2), Third(3), Forth(4), Fifth(5);

        private final int cardinal;

        Cardinal(int cardinal) {
            this.cardinal = cardinal;
        }

        public int getCardinal() {
            return cardinal;
        }

    };

    public DailyEstablishedHour() {
    }

    public DailyEstablishedHour(List<DayOfWeek> weekDays, Calendar firstArrival, Calendar firstDeparture, Calendar secondArrival, Calendar secondDeparture, Calendar thirdArrival, Calendar thirdDeparture, Calendar forthArrival, Calendar forthDeparture, Calendar fifthArrival, Calendar fifthDeparture) throws ScheduleException {
        this.setWeekDays(weekDays);
        this.setArrivalsAndDepartures(firstArrival, firstDeparture, secondArrival, secondDeparture, thirdArrival, thirdDeparture, forthArrival, forthDeparture, fifthArrival, fifthDeparture);
        this.calculateWorkload();
    }

    public DailyEstablishedHour(boolean onMonday, boolean onTuesday, boolean onWednesday, boolean onThursday, boolean onFriday, boolean onSaturday, boolean onSunday, Calendar firstArrival, Calendar firstDeparture, Calendar secondArrival, Calendar secondDeparture, Calendar thirdArrival, Calendar thirdDeparture, Calendar forthArrival, Calendar forthDeparture, Calendar fifthArrival, Calendar fifthDeparture) throws ScheduleException {
        this.onMonday = onMonday;
        this.onTuesday = onTuesday;
        this.onWednesday = onWednesday;
        this.onThursday = onThursday;
        this.onFriday = onFriday;
        this.onSaturday = onSaturday;
        this.onSunday = onSunday;
        this.calculateNumberOfDays();
        this.setArrivalsAndDepartures(firstArrival, firstDeparture, secondArrival, secondDeparture, thirdArrival, thirdDeparture, forthArrival, forthDeparture, fifthArrival, fifthDeparture);
        this.calculateWorkload();
    }

    private void calculateNumberOfDays() {
        int numberOfDays = 0;
        if (onMonday) { numberOfDays++; }
        if (onTuesday) { numberOfDays++; }
        if (onWednesday) { numberOfDays++; }
        if (onThursday) { numberOfDays++; }
        if (onFriday) { numberOfDays++; }
        if (onSaturday) { numberOfDays++; }
        if (onSunday) { numberOfDays++; }
        this.numberOfDays = numberOfDays;
    }

    private void calculateWorkload() {
        float workload = 0;
        workload += calculateDifference(firstArrival, firstDeparture);
        workload += calculateDifference(secondArrival, secondDeparture);
        workload += calculateDifference(thirdArrival, thirdDeparture);
        workload += calculateDifference(forthArrival, forthDeparture);
        workload += calculateDifference(fifthArrival, fifthDeparture);
        workload *= numberOfDays;
        this.workload = workload;
    }

    private float calculateDifference(Calendar arrival, Calendar departure) {
        return (departure.getTimeInMillis() - arrival.getTimeInMillis()) / 60000;
    }

    private void setWeekDays(List<DayOfWeek> weekDays) {
        for (DayOfWeek weekDay : weekDays) {
            switch (weekDay) {
                case MONDAY:
                    onMonday = true;
                    break;
                case TUESDAY:
                    onTuesday = true;
                    break;
                case WEDNESDAY:
                    onWednesday = true;
                    break;
                case THURSDAY:
                    onThursday = true;
                    break;
                case FRIDAY:
                    onFriday = true;
                    break;
                case SATURDAY:
                    onSaturday = true;
                    break;
                case SUNDAY:
                    onSunday = true;
            }
        }
        this.calculateNumberOfDays();
    }

    private void setArrivalsAndDepartures(Calendar firstArrival, Calendar firstDeparture, Calendar secondArrival, Calendar secondDeparture, Calendar thirdArrival, Calendar thirdDeparture, Calendar forthArrival, Calendar forthDeparture, Calendar fifthArrival, Calendar fifthDeparture) throws ScheduleException {
        if (firstArrival == null) {
            throw new ScheduleException("First Arrival must not be null!!!");
        }
        setArrivalAndDeparture(firstArrival, firstDeparture, Cardinal.First);
        setArrivalAndDeparture(secondArrival, secondDeparture, Cardinal.Second);
        setArrivalAndDeparture(thirdArrival, thirdDeparture, Cardinal.Third);
        setArrivalAndDeparture(forthArrival, forthDeparture, Cardinal.Forth);
        setArrivalAndDeparture(fifthArrival, fifthDeparture, Cardinal.Fifth);
    }

    private void setArrivalAndDeparture(Calendar arrival, Calendar departure, Cardinal cardinal) throws ScheduleException {
        if (arrival != null) {
            if (departure == null) {
                throw new ScheduleException(cardinal.name() + " Departure must not be null, because " + cardinal.name() + " Arrival is not null!!!");
            }
            if (!arrival.before(departure)) {
                throw new ScheduleException(cardinal.name() + " Arrival must happen before " + cardinal.name() + " Departure!!!");
            }
            switch (cardinal) {
                case First:
                    firstArrival = arrival;
                    firstDeparture = departure;
                    break;
                case Second:
                    secondArrival = arrival;
                    secondDeparture = departure;
                    break;
                case Third:
                    thirdArrival = arrival;
                    thirdDeparture = departure;
                    break;
                case Forth:
                    forthArrival = arrival;
                    forthDeparture = departure;
                    break;
                case Fifth:
                    fifthArrival = arrival;
                    fifthDeparture = departure;
                    break;
            }
        }
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public boolean isOnMonday() {
        return onMonday;
    }

    public void setOnMonday(boolean onMonday) {
        this.onMonday = onMonday;
    }

    public boolean isOnTuesday() {
        return onTuesday;
    }

    public void setOnTuesday(boolean onTuesday) {
        this.onTuesday = onTuesday;
    }

    public boolean isOnWednesday() {
        return onWednesday;
    }

    public void setOnWednesday(boolean onWednesday) {
        this.onWednesday = onWednesday;
    }

    public boolean isOnThursday() {
        return onThursday;
    }

    public void setOnThursday(boolean onThursday) {
        this.onThursday = onThursday;
    }

    public boolean isOnFriday() {
        return onFriday;
    }

    public void setOnFriday(boolean onFriday) {
        this.onFriday = onFriday;
    }

    public boolean isOnSaturday() {
        return onSaturday;
    }

    public void setOnSaturday(boolean onSaturday) {
        this.onSaturday = onSaturday;
    }

    public boolean isOnSunday() {
        return onSunday;
    }

    public void setOnSunday(boolean onSunday) {
        this.onSunday = onSunday;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Calendar getFirstArrival() {
        return firstArrival;
    }

    public void setFirstArrival(Calendar firstArrival) {
        this.firstArrival = firstArrival;
    }

    public Calendar getFirstDeparture() {
        return firstDeparture;
    }

    public void setFirstDeparture(Calendar firstDeparture) {
        this.firstDeparture = firstDeparture;
    }

    public Calendar getSecondArrival() {
        return secondArrival;
    }

    public void setSecondArrival(Calendar secondArrival) {
        this.secondArrival = secondArrival;
    }

    public Calendar getSecondDeparture() {
        return secondDeparture;
    }

    public void setSecondDeparture(Calendar secondDeparture) {
        this.secondDeparture = secondDeparture;
    }

    public Calendar getThirdArrival() {
        return thirdArrival;
    }

    public void setThirdArrival(Calendar thirdArrival) {
        this.thirdArrival = thirdArrival;
    }

    public Calendar getThirdDeparture() {
        return thirdDeparture;
    }

    public void setThirdDeparture(Calendar thirdDeparture) {
        this.thirdDeparture = thirdDeparture;
    }

    public Calendar getForthArrival() {
        return forthArrival;
    }

    public void setForthArrival(Calendar forthArrival) {
        this.forthArrival = forthArrival;
    }

    public Calendar getForthDeparture() {
        return forthDeparture;
    }

    public void setForthDeparture(Calendar forthDeparture) {
        this.forthDeparture = forthDeparture;
    }

    public Calendar getFifthArrival() {
        return fifthArrival;
    }

    public void setFifthArrival(Calendar fifthArrival) {
        this.fifthArrival = fifthArrival;
    }

    public Calendar getFifthDeparture() {
        return fifthDeparture;
    }

    public void setFifthDeparture(Calendar fifthDeparture) {
        this.fifthDeparture = fifthDeparture;
    }

    public float getWorkload() {
        return workload;
    }

    public void setWorkload(float wokload) {
        this.workload = wokload;
    }

}
