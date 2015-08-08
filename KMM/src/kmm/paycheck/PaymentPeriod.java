/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck;

import javax.persistence.Entity;
import kmm.DescriptableObject;

/**
 *
 * @author adrianohrl
 */
@Entity
public class PaymentPeriod extends DescriptableObject {
    
    private boolean temporal = true;
    private float conversionFactor = 1; // per hour

    public PaymentPeriod() {
    }

    public PaymentPeriod(boolean temporal, float conversionFactor, String name, String description) {
        super(name, description);
        this.temporal = temporal;
        this.conversionFactor = conversionFactor;
    }

    public boolean isTemporal() {
        return temporal;
    }

    public void setTemporal(boolean temporal) {
        this.temporal = temporal;
    }

    public float getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(float conversionFactor) {
        this.conversionFactor = conversionFactor;
    }
    
}
