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
public class RG extends IndividualDocument {

    public RG() {
    }

    public RG(Person individual, String number) {
        super(individual, number);
    }

    public RG(Person individual, String number, Calendar emissionDate) {
        super(individual, number, emissionDate);
    }
    
}
