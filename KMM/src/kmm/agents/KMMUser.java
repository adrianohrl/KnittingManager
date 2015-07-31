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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import kmm.documents.CNH;
import kmm.documents.CPF;
import kmm.documents.CarteiraDeReservista;
import kmm.documents.CarteiraDeTrabalho;
import kmm.documents.PIS;
import kmm.documents.Passport;
import kmm.documents.RG;
import kmm.documents.TituloDeEleitor;
import kmm.paycheck.Salary;
import kmm.paycheck.Schedule;

/**
 *
 * @author adrianohrl
 */
@Entity
public class KMMUser extends Employee implements Serializable {
    
    private String login;
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar lastLoginDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar lastLogoutDate;
    private boolean master = false;
    @OneToMany
    private List<Privilege> privileges = new ArrayList<>();

    public KMMUser() {
    }
    
    public KMMUser(KMMUser user) {
        super(user);
        this.login = user.login;
        this.password = user.password;
        this.master = user.master;
        this.privileges = user.privileges;
    }

    public KMMUser(String login, String password, Calendar lastLoginDate, Calendar lastLogoutDate, List<Privilege> privileges, Employee employee) {
        super(employee);
        this.login = login;
        this.password = password;
        this.lastLoginDate = lastLoginDate;
        this.lastLogoutDate = lastLogoutDate;
        this.privileges = privileges;
    }

    public KMMUser(String login, String password, boolean master, List<Privilege> privileges, int bookNumber, int pageNumber, Calendar hiringDate, Calendar firingDate, float workload, Profession profession, WorkingPeriod period, CarteiraDeTrabalho carteiraDeTrabalho, PIS pis, Salary salary, Schedule schedule, List<Skill> skills, String name, Calendar dob, String phone, String fatherName, String motherName, String nationality, String email, Gender gender, CivilStatus civilStatus, Address address, RG rg, CPF cpf, CNH cnh, TituloDeEleitor tituloDeEleitor, CarteiraDeReservista reservista, Passport passport) {
        super(bookNumber, pageNumber, hiringDate, firingDate, workload, profession, period, carteiraDeTrabalho, pis, salary, schedule, skills, name, dob, phone, fatherName, motherName, nationality, email, gender, civilStatus, address, rg, cpf, cnh, tituloDeEleitor, reservista, passport);
        this.login = login;
        this.password = password;
        this.master = master;
        this.privileges = privileges;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Calendar getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Calendar lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Calendar getLastLogoutDate() {
        return lastLogoutDate;
    }

    public void setLastLogoutDate(Calendar lastLogoutDate) {
        this.lastLogoutDate = lastLogoutDate;
    }

    public boolean isMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
    
}
