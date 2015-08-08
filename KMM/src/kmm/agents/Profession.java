/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import kmm.NameableObject;
import javax.persistence.Entity;

/**
 *
 * @author adrianohrl
 */
@Entity
public class Profession extends NameableObject {
    
    private int registration;
    private long cboAndMteNumber;

    public Profession() {
    }

    public Profession(String profession, int registration, long cboAndMteNumber) {
        super(profession);
        this.registration = registration;
        this.cboAndMteNumber = cboAndMteNumber;
    }

    public int getRegistration() {
        return registration;
    }

    public void setRegistration(int registration) {
        this.registration = registration;
    }

    public long getCboAndMteNumber() {
        return cboAndMteNumber;
    }

    public void setCboAndMteNumber(long cboAndMteNumber) {
        this.cboAndMteNumber = cboAndMteNumber;
    }
    
}
