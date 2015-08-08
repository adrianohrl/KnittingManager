package kmm.test.agents;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import kmm.agents.*;
import kmm.agents.dao.*;
import kmm.dao.DataSource;
import kmm.documents.*;
import kmm.paycheck.Extra;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author adrianohrl
 */
public class UserInsertion {

    public static void main(String[] args) {

        EntityManager em = DataSource.createEntityManager();

        /****************** DAOs utilizados **************************/
        
        GenderDAO genderDAO = new GenderDAO(em);
        CivilStatusDAO statusDAO = new CivilStatusDAO(em);
        AddressDAO addressDAO = new AddressDAO(em);
        KinshipDAO kinshipDAO = new KinshipDAO(em);
        PersonDAO personDAO = new PersonDAO(em);
        EmployeeDAO employeeDAO = new EmployeeDAO(em);
        DependentDAO dependentDAO = new DependentDAO(em);
        KMMUserDAO userDAO = new KMMUserDAO(em);
        ProfessionDAO professionDAO = new ProfessionDAO(em);
        SkillDAO skillDAO = new SkillDAO(em);
        PrivilegeDAO privilegeDAO = new PrivilegeDAO(em);
        
        /*********************** Used Entities **************************/
        
        Gender masculino = genderDAO.find("Masculino");
        Gender feminino = genderDAO.find("Feminino");

        CivilStatus casado = statusDAO.find("Casado(a)");
        CivilStatus solteiro = statusDAO.find("Solteiro(a)");

        Address address = new Address("Rua Hum", "214", "Bairro Alterosa", "37590-000", "Jacutinga", "Minas Gerais", "Brasil", "");
        addressDAO.create(address);

        Kinship conjuge = kinshipDAO.find("Cônjuge");
        Kinship filho = kinshipDAO.find("Filho(a)");
        
        /************************* Marcos *******************************/
        
        Person marcos = new Person();
        
        marcos.setName("Marcos Adriano Leite");
        marcos.setFatherName("Benedicto Leite");
        marcos.setMotherName("Doraci Agostini Leite");
        marcos.setPhone("+55 (35) 8402-6708");
        marcos.setGender(masculino);
        marcos.setCivilStatus(casado);
        marcos.setAddress(address);
        marcos.setRg(new RG(marcos, "18-264.460 SSP/SP", new GregorianCalendar(2011, 0, 3)));
        marcos.setCpf(new CPF(marcos, "089.290.628-65"));
        marcos.setTituloDeEleitor(new TituloDeEleitor("146", "0037", marcos, "120789 19021-3"));
        
        //personDAO.createFullfilled(marcos);
        Employee marcosEmp = new Employee(marcos);
        //personDAO.remove(marcos);
        
        marcosEmp.setCarteiraDeTrabalho(new CarteiraDeTrabalho("0042 SP", marcosEmp, "17553"));
        List<Extra> extras = new ArrayList<>();
        //marcosEmp.setSalary(new Salary(3366, true, "Mês", new GregorianCalendar(2011, 0, 3), marcosEmp, null));
        marcosEmp.setProfession(professionDAO.find("Gerente de Produção"));
        marcosEmp.getSkills().add(skillDAO.find("Gerenciar"));
        marcosEmp.getSkills().add(skillDAO.find("Recursos Humanos"));
        marcosEmp.getSkills().add(skillDAO.find("Liderar"));
        marcosEmp.getSkills().add(skillDAO.find("Gestão de Pessoas"));
        
        //employeeDAO.createFullfilled(marcosEmp);
        KMMUser marcosUsr = new KMMUser(marcosEmp);
        //employeeDAO.remove(marcosEmp);
        
        marcosUsr.setLogin("mal");
        marcosUsr.setPassword("123456");
        marcosUsr.setMaster(false);
        marcosUsr.getPrivileges().add(privilegeDAO.find("Monitoramento"));
        marcosUsr.getPrivileges().add(privilegeDAO.find("Alteração"));
        marcosUsr.getPrivileges().add(privilegeDAO.find("Consulta"));
        
        userDAO.createFullfilled(marcosUsr);
        
        /************************* Eunice *******************************/
        
        Person eunice = new Person();
        eunice.setName("Eunice Rossette Tavares Leite");
        eunice.setFatherName("Joaquim Tavares");
        eunice.setGender(feminino);
        eunice.setCivilStatus(casado);
        eunice.setAddress(address);
        
        //personDAO.createFullfilled(eunice);
        Dependent euniceDep = new Dependent(marcosUsr, conjuge, eunice);
        //personDAO.remove(eunice);
        
        marcosUsr.getDependents().add(euniceDep);
        dependentDAO.createFullfilled(euniceDep);

        /************************* Adriano ******************************/
        
        Person adriano = new Person();
        adriano.setName("Adriano Henrique Rossette Leite");
        adriano.setDob(new GregorianCalendar(1992, 9 - 1, 4));
        adriano.setPhone("+55 (35) 9115-3831");
        adriano.setFatherName("Marcos Adriano Leite");
        adriano.setMotherName("Eunice Rossette Tavares Leite");
        adriano.setNationality("Brasileiro");
        adriano.setEmail("adrianohrl@gmail.com");
        adriano.setGender(masculino);
        adriano.setCivilStatus(solteiro);
        adriano.setAddress(address);
        adriano.setRg(new RG(adriano, "16-255.833 PC/MG"));
        adriano.setCpf(new CPF(adriano, "102.849.066-62"));
        adriano.setCnh(new CNH("AB", new GregorianCalendar(2011, 7 - 1, 21), new GregorianCalendar(2018, 2 - 1, 28), "", adriano, "05257269757", new GregorianCalendar(2013, 4 - 1, 2), false, false));
        adriano.setTituloDeEleitor(new TituloDeEleitor("146", "0039", adriano, "1869 1552 0272"));
        
        //personDAO.createFullfilled(adriano);
        Dependent adrianoDep = new Dependent(marcosUsr, filho, adriano);
        //personDAO.remove(adriano);
        
        marcosUsr.getDependents().add(adrianoDep);
        dependentDAO.createFullfilled(adrianoDep);
        
        /************************* Jaqueline ****************************/
        
        Person jaqueline = new Person();
        jaqueline.setName("Andréia Jaqueline Rossette Leite");
        jaqueline.setFatherName("Marcos Adriano Leite");
        jaqueline.setMotherName("Eunice Rossette Tavares Leite");
        jaqueline.setGender(feminino);
        jaqueline.setCivilStatus(solteiro);
        jaqueline.setAddress(address);
        
        //personDAO.createFullfilled(jaqueline);
        Dependent jaquelineDep = new Dependent(marcosUsr, filho, jaqueline);
        //personDAO.remove(jaqueline);
        
        marcosUsr.getDependents().add(jaquelineDep);
        dependentDAO.createFullfilled(jaquelineDep);

        /************************* Poliane ******************************/
        
        Person poliane = new Person();
        poliane.setName("Elen Poliane Rossette Leite");
        poliane.setFatherName("Marcos Adriano Leite");
        poliane.setMotherName("Eunice Rossette Tavares Leite");
        poliane.setGender(feminino);
        poliane.setCivilStatus(solteiro);
        
        //personDAO.createFullfilled(poliane);
        Dependent polianeDep = new Dependent(marcosUsr, filho, poliane);
        //personDAO.remove(poliane);
        
        marcosUsr.getDependents().add(polianeDep);
        dependentDAO.createFullfilled(polianeDep);
        
        /************************ Remove all ****************************/
        
        dependentDAO.remove(euniceDep);        
        dependentDAO.remove(adrianoDep);
        dependentDAO.remove(jaquelineDep);
        dependentDAO.remove(polianeDep);
        userDAO.remove(marcosUsr);
        
        em.close();
        DataSource.closeEntityManagerFactory();

    }
    
}