/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import kmm.agents.Person;

/**
 *
 * @author adrianohrl
 */
@Entity
public abstract class IndividualDocument extends Document implements Serializable {
    
    @OneToOne
    private Person individual;

    public IndividualDocument() {
    }

    public IndividualDocument(Person individual, String number) {
        super(number);
        this.individual = individual;
    }

    public IndividualDocument(Person individual, String number, Calendar emissionDate) {
        super(number, emissionDate);
        this.individual = individual;
    }
    
    public Person getIndividual() {
        return individual;
    }

    public void setIndividual(Person individual) {
        this.individual = individual;
    }
    
}
