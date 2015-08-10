/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents;

import java.util.Calendar;
import javax.persistence.Entity;
import kmm.agents.Person;
import kmm.agents.PersonRelated;

/**
 *
 * @author adrianohrl
 */
@Entity
public abstract class IndividualDocument extends Document implements PersonRelated {
    
    private String individualName;

    public IndividualDocument() {
    }

    public IndividualDocument(Person individual, String number) {
        super(number);
        this.individualName = individual.getName();
    }

    public IndividualDocument(Person individual, String number, Calendar emissionDate) {
        super(number, emissionDate);
        this.individualName = individual.getName();
    }
    
    public String getIndividual() {
        return individualName;
    }

    public void setPerson(String individualName) {
        this.individualName = individualName;
    }

    @Override
    public void setPerson(Person individual) {
        this.individualName = individual.getName();
    }
    
}
