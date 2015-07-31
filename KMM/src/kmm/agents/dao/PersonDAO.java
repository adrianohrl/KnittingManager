/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.agents.dao;

import javax.persistence.EntityManager;
import kmm.agents.Person;
import kmm.dao.ComplexObject;
import kmm.dao.ComplexObjectRelated;
import kmm.dao.DAO;
import kmm.documents.dao.CNHDAO;
import kmm.documents.dao.CPFDAO;
import kmm.documents.dao.CarteiraDeReservistaDAO;
import kmm.documents.dao.PassportDAO;
import kmm.documents.dao.RGDAO;
import kmm.documents.dao.TituloDeEleitorDAO;

/**
 *
 * @author adrianohrl
 * @param <P>
 */
public class PersonDAO<P extends Person> extends DAO<P, String> implements ComplexObject<P>, ComplexObjectRelated<P> {

    public PersonDAO(EntityManager em) {
        super(em);
    }
    
    @Override
    public void createFullfilled(P person) {
        if (person == null) {
            return;
        }
        em.getTransaction().begin();
        em.persist(person);
        GenderDAO genderDAO = new GenderDAO(em);
        genderDAO.creatingFullfilled(person.getGender());
        CivilStatusDAO civilStatusDAO = new CivilStatusDAO(em);
        civilStatusDAO.creatingFullfilled(person.getCivilStatus());
        AddressDAO addressDAO = new AddressDAO(em);
        addressDAO.creatingFullfilled(person.getAddress());
        RGDAO rgDAO = new RGDAO(em);
        rgDAO.creatingFullfilled(person.getRg());
        CPFDAO cpfDAO = new CPFDAO(em);
        cpfDAO.creatingFullfilled(person.getCpf());
        CNHDAO cnhDAO = new CNHDAO(em);
        cnhDAO.creatingFullfilled(person.getCnh());
        TituloDeEleitorDAO tituloDeEleitorDAO = new TituloDeEleitorDAO(em);
        tituloDeEleitorDAO.creatingFullfilled(person.getTituloDeEleitor());
        CarteiraDeReservistaDAO reservista = new CarteiraDeReservistaDAO(em);
        reservista.creatingFullfilled(person.getReservista());
        PassportDAO passportDAO = new PassportDAO(em);
        passportDAO.creatingFullfilled(person.getPassport());
        em.merge(person);
        em.getTransaction().commit();
    }

    @Override
    public void creatingFullfilled(P person) {
        if (person == null) {
            return;
        }
        em.persist(person);
        GenderDAO genderDAO = new GenderDAO(em);
        genderDAO.creatingFullfilled(person.getGender());
        CivilStatusDAO civilStatusDAO = new CivilStatusDAO(em);
        civilStatusDAO.creatingFullfilled(person.getCivilStatus());
        AddressDAO addressDAO = new AddressDAO(em);
        addressDAO.creatingFullfilled(person.getAddress());
        RGDAO rgDAO = new RGDAO(em);
        rgDAO.creatingFullfilled(person.getRg());
        CPFDAO cpfDAO = new CPFDAO(em);
        cpfDAO.creatingFullfilled(person.getCpf());
        CNHDAO cnhDAO = new CNHDAO(em);
        cnhDAO.creatingFullfilled(person.getCnh());
        TituloDeEleitorDAO tituloDeEleitorDAO = new TituloDeEleitorDAO(em);
        tituloDeEleitorDAO.creatingFullfilled(person.getTituloDeEleitor());
        CarteiraDeReservistaDAO reservista = new CarteiraDeReservistaDAO(em);
        reservista.creatingFullfilled(person.getReservista());
        PassportDAO passportDAO = new PassportDAO(em);
        passportDAO.creatingFullfilled(person.getPassport());
        em.merge(person);
    }
    
}
