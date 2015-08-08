/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.documents;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import kmm.agents.Employee;
import kmm.agents.EmployeeRelated;
import kmm.agents.Person;

/**
 *
 * @author adrianohrl
 */
@Entity
public class CarteiraDeTrabalho extends IndividualDocument implements EmployeeRelated {
    
    private String serie;
    private String type = "Urbano";
    @OneToMany
    private List<EmploymentContract> contracts = new ArrayList<>();
    @OneToMany
    private List<SalaryAlteration> salaryAlterations = new ArrayList<>();
    @OneToMany
    private List<VacationNote> vacationNotes = new ArrayList<>();

    @Override
    public void setEmployee(Employee employee) {
        super.setPerson(employee);
    }

    public CarteiraDeTrabalho() {
    }

    public CarteiraDeTrabalho(String serie, Person individual, String number) {
        super(individual, number);
        this.serie = serie;
    }

    public CarteiraDeTrabalho(String serie, String type, Person individual, String number, Calendar emissionDate) {
        super(individual, number, emissionDate);
        this.serie = serie;
        this.type = type;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<EmploymentContract> getContracts() {
        return contracts;
    }

    public void setContracts(List<EmploymentContract> contracts) {
        this.contracts = contracts;
    }

    public List<SalaryAlteration> getSalaryAlterations() {
        return salaryAlterations;
    }

    public void setSalaryAlterations(List<SalaryAlteration> salaryAlterations) {
        this.salaryAlterations = salaryAlterations;
    }

    public List<VacationNote> getVacationNotes() {
        return vacationNotes;
    }

    public void setVacationNotes(List<VacationNote> vacationNotes) {
        this.vacationNotes = vacationNotes;
    }
        
}
