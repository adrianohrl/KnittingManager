/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import kmm.NameableObject;

/**
 *
 * @author adrianohrl
 */
@Entity
public class Extra extends NameableObject implements Serializable {
    
    private float percentage;
    private float valuePerHour;
    @OneToOne
    private DayType dayType;

    public Extra() {
    }

    public Extra(String extra, float percentage, float valuePerHour, DayType dayType) {
        super(extra);
        this.percentage = percentage;
        this.valuePerHour = valuePerHour;
        this.dayType = dayType;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public float getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(float valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public DayType getDayType() {
        return dayType;
    }

    public void setDayType(DayType dayType) {
        this.dayType = dayType;
    }
    
}
