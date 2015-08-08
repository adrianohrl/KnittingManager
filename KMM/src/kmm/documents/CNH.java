/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import kmm.agents.Person;

/**
 *
 * @author adrianohrl
 */
@Entity
public class CNH extends IndividualDocument {

    private String rgNumber;
    private String cpfNumber;
    private String category;
    @Temporal(TemporalType.DATE)
    private Calendar firstCNH;
    @Temporal(TemporalType.DATE)
    private Calendar expirationDate;
    private boolean permission = false;
    private boolean acc = false;
    private String observations;

    public CNH() {
    }

    public CNH(Person individual, String number) {
        super(individual, number);
    }

    public CNH(Person individual, String number, Calendar emissionDate) {
        super(individual, number, emissionDate);
    }

    public CNH(String category, Calendar expirationDate, Person individual, String number) {
        super(individual, number);
        RG rg = individual.getRg();
        if (rg != null) {
            this.rgNumber = rg.getNumber();
        }
        CPF cpf = individual.getCpf();
        if (cpf != null) {
            this.cpfNumber = cpf.getNumber();
        }
        this.category = category;
        this.expirationDate = expirationDate;
    }

    public CNH(String category, Calendar expirationDate, Person individual, String number, Calendar emissionDate) {
        this(category, expirationDate, individual, number);
        super.setEmissionDate(emissionDate);
    }

    public CNH(String category, Calendar firstCNH, Calendar expirationDate, String observations, Person individual, String number, Calendar emissionDate) {
        this(category, expirationDate, individual, number, emissionDate);
        this.firstCNH = firstCNH;
        this.observations = observations;
    }

    public CNH(String category, Calendar firstCNH, Calendar expirationDate, String observations, Person individual, String number, Calendar emissionDate, boolean permission, boolean acc) {
        this(category, firstCNH, expirationDate, observations, individual, number, emissionDate);
        this.permission = permission;
        this.acc = acc;
    }

    public void setRg(RG rg) {
        this.rgNumber = rg.getNumber();
    }

    public void setCpf(CPF cpf) {
        this.cpfNumber = cpf.getNumber();
    }

    public String getRgNumber() {
        return rgNumber;
    }

    public void setRgNumber(String rgNumber) {
        this.rgNumber = rgNumber;
    }

    public String getCpfNumber() {
        return cpfNumber;
    }

    public void setCpfNumber(String cpfNumber) {
        this.cpfNumber = cpfNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Calendar getFirstCNH() {
        return firstCNH;
    }

    public void setFirstCNH(Calendar firstCNH) {
        this.firstCNH = firstCNH;
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public boolean isAcc() {
        return acc;
    }

    public void setAcc(boolean acc) {
        this.acc = acc;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

}
