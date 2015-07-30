/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import kmm.agents.Employee;

/**
 *
 * @author adrianohrl
 */
@Entity
public class VacationNote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int code;
    @Temporal(TemporalType.DATE)
    private Calendar startDate;
    @Temporal(TemporalType.DATE)
    private Calendar endDate;
    @Temporal(TemporalType.DATE)
    private Calendar noteDate;
    @OneToOne
    private Employee responsible;

    public VacationNote() {
    }

    public VacationNote(Calendar startDate, Calendar endDate, Calendar noteDate, Employee responsible) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.noteDate = noteDate;
        this.responsible = responsible;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public Calendar getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Calendar noteDate) {
        this.noteDate = noteDate;
    }

    public Employee getResponsible() {
        return responsible;
    }

    public void setResponsible(Employee responsible) {
        this.responsible = responsible;
    }
    
}
