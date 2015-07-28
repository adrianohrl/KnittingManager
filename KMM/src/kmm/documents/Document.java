/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents;

import java.util.Calendar;

/**
 *
 * @author adrianohrl
 */
public abstract class Document {
    
    private long code;
    private String number;
    private Calendar emissionDate;

    public Document() {
    }

    public Document(String number) {
        this.number = number;
    }

    public Document(String number, Calendar emissionDate) {
        this.number = number;
        this.emissionDate = emissionDate;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Calendar getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(Calendar emissionDate) {
        this.emissionDate = emissionDate;
    }
    
}
