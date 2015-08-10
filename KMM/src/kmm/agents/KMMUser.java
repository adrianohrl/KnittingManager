/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author adrianohrl
 */
@Entity
public class KMMUser extends Employee {
    
    private String login;
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar lastLoginDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar lastLogoutDate;
    private boolean logged = false;
    private boolean master = false;
    @ManyToMany
    private List<Privilege> privileges = new ArrayList<>();

    public KMMUser() {
    }
    
    public KMMUser(Employee employee) {
        super(employee);
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

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
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
