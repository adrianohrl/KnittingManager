/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.paycheck;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import kmm.DescriptableObject;

/**
 *
 * @author adrianohrl
 */
@Entity
public class DayType extends DescriptableObject implements Serializable {
    
    private char identifier;
    @OneToOne
    private Extra extra;

    public DayType() {
    }

    public DayType(char identifier, Extra extra, String type, String description) {
        super(type, description);
        this.identifier = identifier;
        this.extra = extra;
    }

    public char getIdentifier() {
        return identifier;
    }

    public void setIdentifier(char identifier) {
        this.identifier = identifier;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }
    
}
