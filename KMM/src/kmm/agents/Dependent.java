/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import javax.persistence.Entity;

/**
 *
 * @author adrianohrl
 */
@Entity
public class Dependent extends Person implements EmployeeRelated {
    
    private String employeeName;
    private String kinship;

    public Dependent() {
    }
    
    public Dependent(Person dependent) {
        super(dependent);
    }
    
    public Dependent(Dependent dependent) {
        super(dependent);
        this.employeeName = dependent.employeeName;
        this.kinship = dependent.kinship;
    }

    public Dependent(Employee employee, Kinship kinship, Person person) {
        super(person);
        this.employeeName = employee.getName();
        this.kinship = kinship.getName();
    }

    public void setKinship(Kinship kinship) {
        this.kinship = kinship.getName();
    }

    @Override
    public void setEmployee(Employee employee) {
        this.employeeName = employee.getName();
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getKinship() {
        return kinship;
    }

    public void setKinship(String kinship) {
        this.kinship = kinship;
    }
    
}
