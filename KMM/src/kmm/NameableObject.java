/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author adrianohrl
 */
@Entity
public class NameableObject implements Serializable {
    
    @Id
    private String name;

    public NameableObject() {
    }

    public NameableObject(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
