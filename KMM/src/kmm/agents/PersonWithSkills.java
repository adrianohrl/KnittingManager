/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author adrianohrl
 */
@Entity
public abstract class PersonWithSkills extends Person implements Serializable {
    
    @OneToMany
    private List<Skill> skills = new ArrayList<>();

    public PersonWithSkills() {
    }
    
    public PersonWithSkills(PersonWithSkills personWithSkills) {
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
