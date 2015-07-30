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
public class TituloDeEleitor extends IndividualDocument implements Serializable {

    private int zoneNumber;
    private int sectionNumber;
    
    public TituloDeEleitor() {
    }

    public TituloDeEleitor(int zone, int section, Person individual, String number) {
        super(individual, number);
        this.zoneNumber = zone;
        this.sectionNumber = section;
    }

    public TituloDeEleitor(int zone, int section, Person individual, String number, Calendar emissionDate) {
        super(individual, number, emissionDate);
        this.zoneNumber = zone;
        this.sectionNumber = section;
    }

    public int getZoneNumber() {
        return zoneNumber;
    }

    public void setZoneNumber(int zone) {
        this.zoneNumber = zone;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int section) {
        this.sectionNumber = section;
    }
    
}
