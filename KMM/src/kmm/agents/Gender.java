/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import kmm.NameableObject;
import javax.persistence.Entity;

/**
 *
 * @author adrianohrl
 */
@Entity
public class Gender extends NameableObject {
    
    private boolean male = false;

    public Gender() {
    }

    public Gender(String gender, boolean male) {
        super(gender);
        this.male = male;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }
    
}
