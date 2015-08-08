/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck;

import java.io.Serializable;
import javax.persistence.Entity;
import kmm.DescriptableObject;

/**
 *
 * @author adrianohrl
 */
@Entity
public class DayType extends DescriptableObject implements Serializable {
    
    private char identifier;
    private boolean specialDay = false;

    public DayType() {
    }

    public DayType(char identifier, boolean specialDay, String name, String description) {
        super(name, description);
        this.identifier = identifier;
        this.specialDay = specialDay;
    }

    public char getIdentifier() {
        return identifier;
    }

    public void setIdentifier(char identifier) {
        this.identifier = identifier;
    }

    public boolean isSpecialDay() {
        return specialDay;
    }

    public void setSpecialDay(boolean specialDay) {
        this.specialDay = specialDay;
    }
    
}
