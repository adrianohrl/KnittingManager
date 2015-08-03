/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author adrianohrl
 */
@Entity
public class IndependentContractor extends PersonWithSkills implements Serializable {

    public IndependentContractor() {
    }
    
    public IndependentContractor(IndependentContractor contractor) {
        super(contractor);
    }

    public IndependentContractor(List<Skill> skills, Person person) {
        super(skills, person);
    }
    
}
