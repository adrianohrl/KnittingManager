/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author adrianohrl
 */
@Entity
public abstract class DescriptableObject extends NameableObject implements Serializable {
    
    private String description;

    public DescriptableObject() {
    }

    public DescriptableObject(String name) {
        super(name);
    }

    public DescriptableObject(String description, String name) {
        super(name);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
