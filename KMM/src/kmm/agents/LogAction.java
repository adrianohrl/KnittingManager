/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import kmm.DescriptableObject;
import javax.persistence.Entity;

/**
 *
 * @author adrianohrl
 */
@Entity
public class LogAction extends DescriptableObject {

    public LogAction() {
    }

    public LogAction(String action, String details) {
        super(action, details);
    }
    
}
