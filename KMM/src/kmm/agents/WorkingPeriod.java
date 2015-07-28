/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

/**
 *
 * @author adrianohrl
 */
public class WorkingPeriod {
    
    private long code;
    private String period;

    public WorkingPeriod() {
    }

    public WorkingPeriod(String period) {
        this.period = period;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
    
}
