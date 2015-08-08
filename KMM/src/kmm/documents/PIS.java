/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import kmm.agents.Bank;
import kmm.agents.Employee;
import kmm.agents.EmployeeRelated;
import kmm.agents.Person;

/**
 *
 * @author adrianohrl
 */
@Entity
public class PIS extends IndividualDocument implements EmployeeRelated {
    
    @OneToOne
    private Bank bank;

    public PIS() {
    }

    public PIS(Bank bank, Person individual, String number) {
        super(individual, number);
        this.bank = bank;
    }

    public PIS(Bank bank, Person individual, String number, Calendar emissionDate) {
        super(individual, number, emissionDate);
        this.bank = bank;
    }

    @Override
    public void setEmployee(Employee employee) {
        super.setPerson(employee);
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
    
}
