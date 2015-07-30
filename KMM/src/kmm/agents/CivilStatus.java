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
public class CivilStatus extends NameableObject implements Serializable {
    
    private boolean married = false;

    public CivilStatus() {
    }

    public CivilStatus(String status, boolean married) {
        super(status);
        this.married = married;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }
    
}
