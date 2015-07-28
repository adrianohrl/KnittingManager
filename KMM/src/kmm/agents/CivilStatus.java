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
public class CivilStatus {
    
    private long code;
    private String status;
    private boolean married = false;

    public CivilStatus() {
    }

    public CivilStatus(String status, boolean married) {
        this.status = status;
        this.married = married;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }
    
}
