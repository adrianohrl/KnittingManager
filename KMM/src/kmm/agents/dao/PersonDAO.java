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
        super(em, Person.class);
    }

    protected PersonDAO(EntityManager em, Class clazz) {
        super(em, clazz);
    }

    @Override
    public void createFullfilled(P person) {
        if (person == null) {
            return;
        }
        em.getTransaction().begin();
        this.persist(person);
        em.getTransaction().commit();
    }

    @Override
    public void persist(P person) {
        this.persist(person, person);
    }

    @Override
    public void creatingFullfilled(Object beingCreated, P person) {
        if (beingCreated.equals(person)) {
            em.merge(person);
            return;
        }
        this.persist(beingCreated, person);
    }

    @Override
    public void persist(Object beingCreated, P person) {
        if (person == null) {
            return;
        }
        if (!isRegistered(person)) {
            em.persist(person);
        }
        GenderDAO genderDAO = new GenderDAO(em);
        genderDAO.creatingFullfilled(beingCreated, person.getGender());
        CivilStatusDAO civilStatusDAO = new CivilStatusDAO(em);
        civilStatusDAO.creatingFullfilled(beingCreated, person.getCivilStatus());
        AddressDAO addressDAO = new AddressDAO(em);
        addressDAO.creatingFullfilled(beingCreated, person.getAddress());
        RGDAO rgDAO = new RGDAO(em);
        rgDAO.creatingFullfilled(beingCreated, person.getRg());
        CPFDAO cpfDAO = new CPFDAO(em);
        cpfDAO.creatingFullfilled(beingCreated, person.getCpf());
        CNHDAO cnhDAO = new CNHDAO(em);
        cnhDAO.creatingFullfilled(beingCreated, person.getCnh());
        TituloDeEleitorDAO tituloDeEleitorDAO = new TituloDeEleitorDAO(em);
        tituloDeEleitorDAO.creatingFullfilled(beingCreated, person.getTituloDeEleitor());
        CarteiraDeReservistaDAO reservista = new CarteiraDeReservistaDAO(em);
        reservista.creatingFullfilled(beingCreated, person.getReservista());
        PassportDAO passportDAO = new PassportDAO(em);
        passportDAO.creatingFullfilled(beingCreated, person.getPassport());
        em.merge(person);
    }

    @Override
    public boolean isRegistered(P person) {
        return super.find(person.getName()) != null;
    }

}
