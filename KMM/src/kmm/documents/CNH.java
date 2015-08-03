/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import kmm.agents.Person;

/**
 *
 * @author adrianohrl
 */
@Entity
public class CNH extends IndividualDocument implements Serializable {

    @OneToOne
    private RG rg;
    @OneToOne
    private CPF cpf;
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
        this.rg = individual.getRg();
        this.cpf = individual.getCpf();
        this.category = category;
        this.expirationDate = expirationDate;
    }

    public CNH(String category, Calendar expirationDate, Person individual, String number, Calendar emissionDate) {
        super(individual, number, emissionDate);
        this.rg = individual.getRg();
        this.cpf = individual.getCpf();
        this.category = category;
        this.expirationDate = expirationDate;
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

    public RG getRg() {
        return rg;
    }

    public void setRg(RG rg) {
        this.rg = rg;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
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
