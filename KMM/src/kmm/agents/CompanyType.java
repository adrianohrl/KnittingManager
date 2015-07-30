/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import kmm.NameableObject;
import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author adrianohrl
 */
@Entity
public class CompanyType extends NameableObject implements Serializable {
    
    private String abbreviation;

    public CompanyType() {
    }

    public CompanyType(String type, String abbreviation) {
        super(type);
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    
}
