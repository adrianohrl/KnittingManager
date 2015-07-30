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
public class CPF extends IndividualDocument implements Serializable {

    public CPF() {
    }

    public CPF(Person individual, String number) {
        super(individual, number);
    }

    public CPF(Person individual, String number, Calendar emissionDate) {
        super(individual, number, emissionDate);
    }
    
}
