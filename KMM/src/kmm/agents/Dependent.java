/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author adrianohrl
 */
@Entity
public class Dependent extends Person implements Serializable {
    
    @ManyToOne
    private Employee employee;
    @OneToOne
    private Kinship kinship;

    public Dependent() {
    }
    
    public Dependent(Dependent dependent) {
        super(dependent);
        this.employee = dependent.employee;
        this.kinship = dependent.kinship;
    }

    public Dependent(Employee employee, Kinship kinship, Person person) {
        super(person);
        this.employee = employee;
        this.kinship = kinship;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Kinship getKinship() {
        return kinship;
    }

    public void setKinship(Kinship kinship) {
        this.kinship = kinship;
    }
    
}
