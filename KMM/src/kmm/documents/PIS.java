/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents;

import java.util.Calendar;
import kmm.agents.Bank;
import kmm.agents.Person;

/**
 *
 * @author adrianohrl
 */
public class PIS extends IndividualDocument {
    
    private Bank bank;

    public PIS(Bank bank, Person individual, String number) {
        super(individual, number);
        this.bank = bank;
    }

    public PIS(Bank bank, Person individual, String number, Calendar emissionDate) {
        super(individual, number, emissionDate);
        this.bank = bank;
    }

    public PIS() {
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
    
}
