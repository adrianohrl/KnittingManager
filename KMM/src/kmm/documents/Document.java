/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author adrianohrl
 */
@Entity
public abstract class Document implements Serializable {
    
    @Id
    private String number;
    @Temporal(TemporalType.DATE)
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
    
    @Override
    public String toString() {
        return number;
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
