/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author adrianohrl
 */
@Entity
public class Log implements Serializable, UserRelated {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long code;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar logDate;
    private String description;
    private String userName;
    @OneToOne
    private LogAction action;

    public Log() {
    }

    public Log(Calendar logDate, String description, KMMUser user, LogAction action) {
        this.logDate = logDate;
        this.description = description;
        this.userName = user.getName();
        this.action = action;
    }

    @Override
    public void setUser(KMMUser user) {
        this.userName = user.getName();
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Calendar getLogDate() {
        return logDate;
    }

    public void setLogDate(Calendar logDate) {
        this.logDate = logDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return userName;
    }

    public void setUser(String user) {
        this.userName = user;
    }

    public LogAction getAction() {
        return action;
    }

    public void setAction(LogAction action) {
        this.action = action;
    }
    
}
