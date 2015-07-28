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
public class Skill {
    
    private long code;
    private String skill;

    public Skill() {
    }

    public Skill(String skill) {
        this.skill = skill;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
