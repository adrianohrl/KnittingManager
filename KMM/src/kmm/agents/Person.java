/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import java.util.Calendar;
import kmm.documents.CNH;
import kmm.documents.CPF;
import kmm.documents.CarteiraDeReservista;
import kmm.documents.RG;
import kmm.documents.TituloDeEleitor;

/**
 *
 * @author adrianohrl
 */
public class Person {
    
    private long code;
    private String name;
    private Calendar dob;
    private String phone;
    private String fatherName;
    private String motherName;
    private String nationality;
    private String email;
    private Gender gender;
    private CivilStatus civilStatus;
    private Address address;
    private RG rg;
    private CPF cpf;
    private CNH cnh;
    private TituloDeEleitor tituloDeEleitor;
    private CarteiraDeReservista reservista;

    public Person() {
    }
    
    public Person(Person person) {
        this.name = person.name;
        this.dob = person.dob;
        this.phone = person.phone;
        this.fatherName = person.fatherName;
        this.motherName = person.motherName;
        this.nationality = person.nationality;
        this.email = person.email;
        this.gender = person.gender;
        this.civilStatus = person.civilStatus;
        this.address = person.address;
        this.rg = person.rg;
        this.cpf = person.cpf;
        this.cnh = person.cnh;
        this.tituloDeEleitor = person.tituloDeEleitor;
        this.reservista = person.reservista;
    }

    public Person(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Person(String name, String phone, CPF cpf) {
        this.name = name;
        this.phone = phone;
        this.cpf = cpf;
    }

    public Person(String name, String phone, Address address, RG rg, CPF cpf) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rg = rg;
        this.cpf = cpf;
    }

    public Person(String name, Calendar dob, Gender gender, CivilStatus civilStatus, RG rg, CPF cpf) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.civilStatus = civilStatus;
        this.rg = rg;
        this.cpf = cpf;
    }

    public Person(String name, Calendar dob, String phone, String fatherName, String motherName, String nationality, String email, Gender gender, CivilStatus civilStatus, Address address, RG rg, CPF cpf, CNH cnh, TituloDeEleitor tituloDeEleitor, CarteiraDeReservista reservista) {
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.nationality = nationality;
        this.email = email;
        this.gender = gender;
        this.civilStatus = civilStatus;
        this.address = address;
        this.rg = rg;
        this.cpf = cpf;
        this.cnh = cnh;
        this.tituloDeEleitor = tituloDeEleitor;
        this.reservista = reservista;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDob() {
        return dob;
    }

    public void setDob(Calendar dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public CivilStatus getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(CivilStatus civilStatus) {
        this.civilStatus = civilStatus;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public CNH getCnh() {
        return cnh;
    }

    public void setCnh(CNH cnh) {
        this.cnh = cnh;
    }

    public TituloDeEleitor getTituloDeEleitor() {
        return tituloDeEleitor;
    }

    public void setTituloDeEleitor(TituloDeEleitor tituloDeEleitor) {
        this.tituloDeEleitor = tituloDeEleitor;
    }

    public CarteiraDeReservista getReservista() {
        return reservista;
    }

    public void setReservista(CarteiraDeReservista reservista) {
        this.reservista = reservista;
    }
    
}
