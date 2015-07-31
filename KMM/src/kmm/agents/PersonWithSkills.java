/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import kmm.documents.CNH;
import kmm.documents.CPF;
import kmm.documents.CarteiraDeReservista;
import kmm.documents.Passport;
import kmm.documents.RG;
import kmm.documents.TituloDeEleitor;

/**
 *
 * @author adrianohrl
 */
@Entity
public abstract class PersonWithSkills extends Person implements Serializable {
    
    @OneToMany
    private List<Skill> skills = new ArrayList<>();

    public PersonWithSkills() {
    }
    
    public PersonWithSkills(PersonWithSkills personWithSkills) {
        super(personWithSkills);
        this.skills = personWithSkills.skills;
    }

    public PersonWithSkills(List<Skill> skills, String name, String phone, Address address, RG rg, CPF cpf) {
        super(name, phone, address, rg, cpf);
        this.skills = skills;
    }

    public PersonWithSkills(List<Skill> skills, String name, Calendar dob, String phone, String fatherName, String motherName, String nationality, String email, Gender gender, CivilStatus civilStatus, Address address, RG rg, CPF cpf, CNH cnh, TituloDeEleitor tituloDeEleitor, CarteiraDeReservista reservista, Passport passport) {
        super(name, dob, phone, fatherName, motherName, nationality, email, gender, civilStatus, address, rg, cpf, cnh, tituloDeEleitor, reservista, passport);
        this.skills = skills;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
    
}
