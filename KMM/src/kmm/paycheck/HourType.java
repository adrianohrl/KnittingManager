/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author adrianohrl
 */
@Entity
public class HourType implements Serializable {

    @Id
    private String name;
    private char identifier;
    private float percentage = 0;
    private boolean forSpecialDays = false;
    @OneToOne
    private DayType dayType;

    public HourType() {
    }

    public HourType(String name, char identifier, float percentage, DayType dayType) {
        this.name = name;
        this.identifier = identifier;
        this.percentage = percentage;
        if (dayType != null) {
            this.forSpecialDays = dayType.isSpecialDay();
        }
        this.dayType = dayType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getIdentifier() {
        return identifier;
    }

    public void setIdentifier(char identifier) {
        this.identifier = identifier;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public boolean isForSpecialDays() {
        return forSpecialDays;
    }

    public void setForSpecialDays(boolean forSpecialDays) {
        this.forSpecialDays = forSpecialDays;
    }

    public DayType getDayType() {
        return dayType;
    }

    public void setDayType(DayType dayType) {
        if (dayType != null) {
            this.forSpecialDays = dayType.isSpecialDay();
        }
        this.dayType = dayType;
    }

}
