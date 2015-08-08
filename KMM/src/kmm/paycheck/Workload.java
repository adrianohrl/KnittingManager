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
public class Workload {
    
    private float amount = 0;
    private PaymentPeriod period;
    private HourType hourType;

    public Workload(float amount, PaymentPeriod period, HourType hourType) {
        this.amount = amount;
        this.period = period;
        this.hourType = hourType;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public PaymentPeriod getPeriod() {
        return period;
    }

    public void setPeriod(PaymentPeriod period) {
        this.period = period;
    }

    public HourType getHourType() {
        return hourType;
    }

    public void setHourType(HourType hourType) {
        this.hourType = hourType;
    }
    
}
