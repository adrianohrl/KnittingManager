/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author adrianohrl
 */
@Entity
public class PersonWithSkills extends Person {
    
    @ManyToMany
    private List<Skill> skills = new ArrayList<>();

    protected PersonWithSkills() {
    }
    
    protected PersonWithSkills(Person personWithSkills) {
        super(personWithSkills);
    }
    
    protected PersonWithSkills(PersonWithSkills personWithSkills) {
        super(personWithSkills);
        this.skills = personWithSkills.skills;
    }

    public PersonWithSkills(List<Skill> skills, Person person) {
        super(person);
        this.skills = skills;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
    
}
