/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.test.documents;

import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import kmm.agents.Person;
import kmm.agents.dao.PersonDAO;
import kmm.dao.DataSource;
import kmm.documents.CNH;
import kmm.documents.IndividualDocument;
import kmm.documents.RG;
import kmm.documents.dao.CNHDAO;
import kmm.documents.dao.IndividualDocumentDAO;

/**
 *
 * @author adrianohrl
 */
public class DocumentDAOs {
    
    public static void main(String[] args) {
        
        EntityManager em = DataSource.createEntityManager();
        
        Person p = new Person("AHRL3", "", " ");
        
        CNH cnh = new CNH("B", new GregorianCalendar(2011, 7, 21), new GregorianCalendar(2018, 2, 28), "", p, "0987529757**", new GregorianCalendar(2013, 4, 2), false, false);
        p.setCnh(cnh);
        
        IndividualDocument doc = cnh;
        IndividualDocumentDAO cnhDAO = new CNHDAO(em);
        cnhDAO.create(doc);
        
        p.setRg(new RG(p, "16-255.833 PC/MG"));
        p.getCnh().setRg(p.getRg());
        
        PersonDAO pDAO = new PersonDAO(em);
        pDAO.create(p);
        
        em.close();
        DataSource.closeEntityManagerFactory();
        
    }
    
}
