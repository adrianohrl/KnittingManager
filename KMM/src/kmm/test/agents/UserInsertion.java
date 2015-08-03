package kmm.test.agents;

import java.util.GregorianCalendar;
import java.util.Scanner;
import javax.persistence.EntityManager;
import kmm.agents.Address;
import kmm.agents.CivilStatus;
import kmm.agents.Gender;
import kmm.agents.Person;
import kmm.agents.dao.PersonDAO;
import kmm.dao.DataSource;
import kmm.documents.CNH;
import kmm.documents.CPF;
import kmm.documents.RG;
import kmm.documents.TituloDeEleitor;

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
    
    private final static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        Person p = new Person();
        p.setName("Adriano Henrique Rossette Leite");
        p.setDob(new GregorianCalendar(1992, 9 - 1, 4));
        p.setPhone("+55 (35) 9115 3831");
        p.setFatherName("Marcos Adriano Leite");
        p.setMotherName("Eunice Rossette Tavares Leite");
        p.setNationality("Brasileiro");
        p.setEmail("adrianohrl@gmail.com");
        p.setGender(new Gender("Masculino", true));
        p.setCivilStatus(new CivilStatus("Solteiro", false));
        p.setAddress(new Address("Rua Hum", "214", "Bairro Alterosa", "37590-000", "Jacutinga", "Minas Gerais", "Brasil", ""));
        p.setRg(new RG(p, "16-255.833 PC/MG"));
        p.setCpf(new CPF(p, "102.849.066-62"));
        p.setCnh(new CNH("AB", new GregorianCalendar(2011, 7 - 1, 21), new GregorianCalendar(2018, 2 - 1, 28), "", p, "05257269757", new GregorianCalendar(2013, 4 - 1, 2), false, false));
        p.setTituloDeEleitor(new TituloDeEleitor(146, 39, p, "1869 1552 0272"));
        
        EntityManager em = DataSource.createEntityManager();
        PersonDAO pDAO = new PersonDAO(em);
        pDAO.createFullfilled(p);
        p = null;
        pDAO.createFullfilled(p);
        DataSource.closeEntityManagerFactory();
        
    }
    
}
