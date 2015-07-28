/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import java.util.Calendar;

/**
 *
 * @author adrianohrl
 */
public class PeriodicalExam {
    
    private long code;
    private String doctorName;
    private Calendar examDate;
    private String observations;

    public PeriodicalExam() {
    }

    public PeriodicalExam(Calendar examDate) {
        this.examDate = examDate;
    }

    public PeriodicalExam(String doctorName, Calendar examDate, String observations) {
        this.doctorName = doctorName;
        this.examDate = examDate;
        this.observations = observations;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Calendar getExamDate() {
        return examDate;
    }

    public void setExamDate(Calendar examDate) {
        this.examDate = examDate;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
    
}
