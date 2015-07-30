/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import kmm.documents.CNH;
import kmm.documents.CPF;
import kmm.documents.CarteiraDeReservista;
import kmm.documents.RG;
import kmm.documents.TituloDeEleitor;

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

    public Dependent(Employee employee, Kinship kinship, String name, Calendar dob, Gender gender, CivilStatus civilStatus, RG rg, CPF cpf) {
        super(name, dob, gender, civilStatus, rg, cpf);
        this.employee = employee;
        this.kinship = kinship;
    }

    public Dependent(Employee employee, Kinship kinship, String name, Calendar dob, String phone, String fatherName, String motherName, String nationality, String email, Gender gender, CivilStatus civilStatus, Address address, RG rg, CPF cpf, CNH cnh, TituloDeEleitor tituloDeEleitor, CarteiraDeReservista reservista) {
        super(name, dob, phone, fatherName, motherName, nationality, email, gender, civilStatus, address, rg, cpf, cnh, tituloDeEleitor, reservista);
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
