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
public class Extra implements Serializable {
    
    @Id
    private long code;
    private float valuePerHour;
    @OneToOne
    private HourType type;

    public Extra() {
    }

    public Extra(float valuePerHour, HourType type) {
        this.valuePerHour = valuePerHour;
        this.type = type;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public float getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(float valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public HourType getType() {
        return type;
    }

    public void setType(HourType type) {
        this.type = type;
    }
    
}
