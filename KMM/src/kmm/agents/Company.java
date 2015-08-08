/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author adrianohrl
 */
@Entity
public class Company implements Serializable {
    
    @Id
    private String businessName;
    private String fantasyName;
    private String phone;
    private String fax;
    @Temporal(TemporalType.DATE)
    private Calendar foundationDate;
    private String cnpj;
    private String ie;
    private String im;
    @OneToOne
    private CompanyType type;
    @OneToOne
    private Address address;

    public Company() {
    }

    public Company(String fantasyName, String businessName, String phone, String fax, String cnpj, Address address) {
        this.fantasyName = fantasyName;
        this.businessName = businessName;
        this.phone = phone;
        this.fax = fax;
        this.cnpj = cnpj;
        this.address = address;
    }

    public Company(String fantasyName, String businessName, String phone, String fax, Calendar foundationDate, String cnpj, String ie, String im, CompanyType type, Address address) {
        this.fantasyName = fantasyName;
        this.businessName = businessName;
        this.phone = phone;
        this.fax = fax;
        this.foundationDate = foundationDate;
        this.cnpj = cnpj;
        this.ie = ie;
        this.im = im;
        this.type = type;
        this.address = address;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Calendar getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(Calendar foundationDate) {
        this.foundationDate = foundationDate;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getIm() {
        return im;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public CompanyType getType() {
        return type;
    }

    public void setType(CompanyType type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
}
