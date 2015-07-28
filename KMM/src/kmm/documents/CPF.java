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
public class CPF extends IndividualDocument {

    public CPF() {
    }

    public CPF(Person individual, String number) {
        super(individual, number);
    }

    public CPF(Person individual, String number, Calendar emissionDate) {
        super(individual, number, emissionDate);
    }
    
}
