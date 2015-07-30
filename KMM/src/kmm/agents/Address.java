/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author adrianohrl
 */
@Entity
public class Address implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long code;
    private String street;
    private String identifier;
    private String district;
    private String zip;
    private String city;
    private String county;
    private String stateName;
    private String country;
    private String complement;

    public Address() {
    }

    public Address(String street, String identifier, String district, String zip, String city, String state, String country, String complement) {
        this.street = street;
        this.identifier = identifier;
        this.district = district;
        this.zip = zip;
        this.city = city;
        this.stateName = state;
        this.country = country;
        this.complement = complement;
    }

    public Address(String street, String identifier, String district, String zip, String city, String county, String state, String country, String complement) {
        this(street, identifier, district, zip, city, state, country, complement);
        this.county = county;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String state) {
        this.stateName = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
   
}
