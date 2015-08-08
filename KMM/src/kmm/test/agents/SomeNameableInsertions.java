/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmm.test.agents;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import kmm.agents.CivilStatus;
import kmm.agents.Gender;
import kmm.agents.Kinship;
import kmm.agents.LogAction;
import kmm.agents.Privilege;
import kmm.agents.Profession;
import kmm.agents.Skill;
import kmm.agents.WorkingPeriod;
import kmm.agents.dao.CivilStatusDAO;
import kmm.agents.dao.GenderDAO;
import kmm.agents.dao.KinshipDAO;
import kmm.agents.dao.LogActionDAO;
import kmm.agents.dao.PrivilegeDAO;
import kmm.agents.dao.ProfessionDAO;
import kmm.agents.dao.SkillDAO;
import kmm.agents.dao.WorkingPeriodDAO;
import kmm.dao.DataSource;

/**
 *
 * @author adrianohrl
 */
public class SomeNameableInsertions {

    public static void main(String[] args) {
        SomeNameableInsertions.registerCivilStatus();
        SomeNameableInsertions.registerGender();
        SomeNameableInsertions.registerKinships();
        SomeNameableInsertions.registerLogActions();
        SomeNameableInsertions.registerPrivileges();
        SomeNameableInsertions.registerProfessions();
        SomeNameableInsertions.registerSkills();
        SomeNameableInsertions.registerWorkingPeriods();
        DataSource.closeEntityManagerFactory();
    }

    public static void registerGender() {
        EntityManager em = DataSource.createEntityManager();
        List<Gender> genders = new ArrayList<>();
        genders.add(new Gender("Masculino", true));
        genders.add(new Gender("Feminino", false));
        GenderDAO genderDAO = new GenderDAO(em);
        for (Gender gender : genders) {
            genderDAO.create(gender);
        }
        em.close();
    }

    public static void registerCivilStatus() {
        EntityManager em = DataSource.createEntityManager();
        List<CivilStatus> statuss = new ArrayList<>();
        statuss.add(new CivilStatus("Casado(a)", true));
        statuss.add(new CivilStatus("Solteiro(a)", false));
        CivilStatusDAO statusDAO = new CivilStatusDAO(em);
        for (CivilStatus status : statuss) {
            statusDAO.create(status);
        }
        em.close();
    }

    public static void registerKinships() {
        EntityManager em = DataSource.createEntityManager();
        List<Kinship> kinships = new ArrayList<>();
        kinships.add(new Kinship(false, true, "Cônjuge"));
        kinships.add(new Kinship(true, false, "Filho(a)"));
        KinshipDAO kinshipDAO = new KinshipDAO(em);
        for (Kinship kinship : kinships) {
            kinshipDAO.create(kinship);
        }
        em.close();
    }

    public static void registerProfessions() {
        EntityManager em = DataSource.createEntityManager();
        List<Profession> professions = new ArrayList<>();
        professions.add(new Profession("Gerente de Produção", 141205, 394269));
        ProfessionDAO professionDAO = new ProfessionDAO(em);
        for (Profession profession : professions) {
            professionDAO.create(profession);
        }
        em.close();
    }

    public static void registerWorkingPeriods() {
        EntityManager em = DataSource.createEntityManager();
        List<WorkingPeriod> workingPeriods = new ArrayList<>();
        workingPeriods.add(new WorkingPeriod("Diurno"));
        workingPeriods.add(new WorkingPeriod("Vespertino"));
        workingPeriods.add(new WorkingPeriod("Noturno"));
        WorkingPeriodDAO workingPeriodDAO = new WorkingPeriodDAO(em);
        for (WorkingPeriod workingPeriod : workingPeriods) {
            workingPeriodDAO.create(workingPeriod);
        }
        em.close();
    }
    
    public static void registerSkills() {
        EntityManager em = DataSource.createEntityManager();
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill("Gerenciar"));
        skills.add(new Skill("Liderar"));
        skills.add(new Skill("Recursos Humanos"));
        skills.add(new Skill("Gestão de Pessoas"));
        skills.add(new Skill("Overlocar"));
        skills.add(new Skill("Programar Stoll"));
        skills.add(new Skill("Monitorar Stoll"));
        SkillDAO skillDAO = new SkillDAO(em);
        for (Skill skill : skills) {
            skillDAO.create(skill);
        }
        em.close();
    }
    
    public static void registerPrivileges() {
        EntityManager em = DataSource.createEntityManager();
        List<Privilege> privileges = new ArrayList<>();
        privileges.add(new Privilege("Acesso Total", ""));
        privileges.add(new Privilege("Monitoramento", ""));
        privileges.add(new Privilege("Alteração", ""));
        privileges.add(new Privilege("Consulta", ""));
        PrivilegeDAO privilegeDAO = new PrivilegeDAO(em);
        for (Privilege privilege : privileges) {
            privilegeDAO.create(privilege);
        }
        em.close();
    }
    
    public static void registerLogActions() {
        EntityManager em = DataSource.createEntityManager();
        List<LogAction> actions = new ArrayList<>();
        actions.add(new LogAction("Logged In", ""));
        actions.add(new LogAction("Logged Out", ""));
        LogActionDAO actionDAO = new LogActionDAO(em);
        for (LogAction action : actions) {
            actionDAO.create(action);
        }
        em.close();
    }
    
    public static void registerExtras() {
        /*EntityManager em = DataSource.createEntityManager();
        List<DayType> dayTypes = new ArrayList<>();
        List<Extra> extras = new ArrayList<>();
        
        DayType type1 = new DayType('a', null, "Horário Normal", "Horário Normal em um Dia de Trabalho");
        Extra extra1 = new Extra("Hora Normal", 0, 0, type1);
        type1.setExtra(extra1);
        dayTypes.add(type1);
        extras.add(extra1);
        
        DayType type2 = new DayType('b', null, "Horário Extra Normal", "Horário Extra em um Dia Normal de Trabalho");
        Extra extra2 = new Extra("Hora Extra de 70%", 0.7f, 0, type2);
        type2.setExtra(extra2);
        dayTypes.add(type2);
        extras.add(extra2);
        
        DayType type3 = new DayType('c', null, "Horário Extra Especial", "Horário Extra em um Dia Especial de Trabalho (sábados, domingos e feriados)");
        Extra extra3 = new Extra("Hora Extra de 100%", 1, 0, type3);
        type3.setExtra(extra3);
        dayTypes.add(type3);
        extras.add(extra3);
        
        em.close();*/
    }

}
