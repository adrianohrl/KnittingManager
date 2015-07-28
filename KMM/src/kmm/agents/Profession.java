/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

/**
 *
 * @author adrianohrl
 */
public class Profession {
    
    private long code;
    private String profession;
    private int registration;
    private long cboAndMteNumber;

    public Profession() {
    }

    public Profession(String profession, int registration, long cboAndMteNumber) {
        this.profession = profession;
        this.registration = registration;
        this.cboAndMteNumber = cboAndMteNumber;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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
