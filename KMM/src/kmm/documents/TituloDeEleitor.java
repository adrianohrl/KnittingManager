/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents;

import java.util.Calendar;
import javax.persistence.Entity;
import kmm.agents.Person;

/**
 *
 * @author adrianohrl
 */
@Entity
public class TituloDeEleitor extends IndividualDocument {

    private String zoneNumber;
    private String sectionNumber;
    
    public TituloDeEleitor() {
    }

    public TituloDeEleitor(String zone, String section, Person individual, String number) {
        super(individual, number);
        this.zoneNumber = zone;
        this.sectionNumber = section;
    }

    public TituloDeEleitor(String zone, String section, Person individual, String number, Calendar emissionDate) {
        super(individual, number, emissionDate);
        this.zoneNumber = zone;
        this.sectionNumber = section;
    }

    public String getZoneNumber() {
        return zoneNumber;
    }

    public void setZoneNumber(String zone) {
        this.zoneNumber = zone;
    }

    public String getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(String section) {
        this.sectionNumber = section;
    }
    
}
