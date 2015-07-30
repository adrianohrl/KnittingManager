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
public class WorkingPeriod extends NameableObject implements Serializable {

    public WorkingPeriod() {
    }

    public WorkingPeriod(String period) {
        super(period);
    }
    
}
