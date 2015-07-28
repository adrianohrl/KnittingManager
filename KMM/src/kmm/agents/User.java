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
import kmm.documents.CarteiraDeTrabalho;
import kmm.documents.PIS;
import kmm.documents.RG;
import kmm.documents.TituloDeEleitor;
import kmm.paycheck.Salary;
import kmm.paycheck.Schedule;

/**
 *
 * @author adrianohrl
 */
public class User extends Employee {
    
    private String login;
    private String password;
    private Calendar lastLoginDate;
    private Calendar lastLogoutDate;
    private boolean master = false;

    public User() {
    }
    
    public User(User user) {
        super(user);
        this.login = user.login;
        this.password = user.password;
        this.master = user.master;
    }

    public User(String login, String password, Calendar lastLoginDate, Calendar lastLogoutDate, Employee employee) {
        super(employee);
        this.login = login;
        this.password = password;
        this.lastLoginDate = lastLoginDate;
        this.lastLogoutDate = lastLogoutDate;
    }

    public User(String login, String password, boolean master, int bookNumber, int pageNumber, Calendar hiringDate, Calendar firingDate, float workload, Profession profession, WorkingPeriod period, CarteiraDeTrabalho carteiraDeTrabalho, PIS pis, Salary salary, Schedule schedule, String name, Calendar dob, String phone, String fatherName, String motherName, String nationality, String email, Gender gender, CivilStatus civilStatus, Address address, RG rg, CPF cpf, CNH cnh, TituloDeEleitor tituloDeEleitor, CarteiraDeReservista reservista) {
        super(bookNumber, pageNumber, hiringDate, firingDate, workload, profession, period, carteiraDeTrabalho, pis, salary, schedule, name, dob, phone, fatherName, motherName, nationality, email, gender, civilStatus, address, rg, cpf, cnh, tituloDeEleitor, reservista);
        this.login = login;
        this.password = password;
        this.master = master;
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
    
}
