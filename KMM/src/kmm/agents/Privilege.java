/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import kmm.DescriptableObject;
import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author adrianohrl
 */
@Entity
public class Privilege extends DescriptableObject implements Serializable {

    public Privilege() {
    }

    public Privilege(String privilege, String description) {
        super(privilege, description);
    }
    
}
