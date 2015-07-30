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
public class Passport extends IndividualDocument {

    private String type;
    private String issuingCountry;
    
    public Passport() {
    }

    public Passport(String type, String issuingCountry, Person individual, String number, Calendar emissionDate) {
        super(individual, number, emissionDate);
        this.type = type;
        this.issuingCountry = issuingCountry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }

    public void setIssuingCountry(String issuingCountry) {
        this.issuingCountry = issuingCountry;
    }
    
}
