/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import kmm.agents.Person;

/**
 *
 * @author adrianohrl
 */
@Entity
public class CarteiraDeReservista extends IndividualDocument implements Serializable {
    
    private String serie;
    private long ra;

    public CarteiraDeReservista() {
    }

    public CarteiraDeReservista(String serie, long ra, Person individual, String number) {
        super(individual, number);
        this.serie = serie;
        this.ra = ra;
    }

    public CarteiraDeReservista(String serie, long ra, Person individual, String number, Calendar emissionDate) {
        super(individual, number, emissionDate);
        this.serie = serie;
        this.ra = ra;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public long getRa() {
        return ra;
    }

    public void setRa(long ra) {
        this.ra = ra;
    }
    
}
