/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author adrianohrl
 */
@Entity
public class Bank implements Serializable {
    
    @Id
    private String name;
    private String number;
    private String agency;
    private String comments;
    @OneToOne
    private Address address;

    public Bank() {
    }

    public Bank(String name, String number, String agency) {
        this.name = name;
        this.number = number;
        this.agency = agency;
    }

    public Bank(String name, String number, String agency, String comments, Address address) {
        this.name = name;
        this.number = number;
        this.agency = agency;
        this.comments = comments;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
}
