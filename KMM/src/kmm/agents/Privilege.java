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
public class Privilege {
    
    private long code;
    private String privilege;
    private String description;

    public Privilege() {
    }

    public Privilege(String privilege, String description) {
        this.privilege = privilege;
        this.description = description;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
