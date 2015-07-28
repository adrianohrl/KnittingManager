/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents;

import java.util.Calendar;
import kmm.agents.Person;

/**
 *
 * @author adrianohrl
 */
public class TituloDeEleitor extends IndividualDocument {

    private int zone;
    private int section;
    
    public TituloDeEleitor() {
    }

    public TituloDeEleitor(int zone, int section, Person individual, String number) {
        super(individual, number);
        this.zone = zone;
        this.section = section;
    }

    public TituloDeEleitor(int zone, int section, Person individual, String number, Calendar emissionDate) {
        super(individual, number, emissionDate);
        this.zone = zone;
        this.section = section;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }
    
}
