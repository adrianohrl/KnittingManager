/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import kmm.documents.CPF;
import kmm.documents.RG;

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

    public IndependentContractor(PersonWithSkills personWithSkills) {
        super(personWithSkills);
    }

    public IndependentContractor(List<Skill> skills, String name, String phone, Address address, RG rg, CPF cpf) {
        super(skills, name, phone, address, rg, cpf);
    }
    
}
