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
public class Kinship extends NameableObject {
    
    private boolean child;
    private boolean spouse;

    public Kinship() {
    }

    public Kinship(boolean child, boolean spouse, String name) {
        super(name);
        this.child = child;
        this.spouse = spouse;
    }

    public boolean isChild() {
        return child;
    }

    public void setChild(boolean child) {
        this.child = child;
    }

    public boolean isSpouse() {
        return spouse;
    }

    public void setSpouse(boolean spouse) {
        this.spouse = spouse;
    }
    
}
