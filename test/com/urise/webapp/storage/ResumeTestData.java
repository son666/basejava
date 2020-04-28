package com.urise.webapp.storage;

import com.urise.webapp.model.*;

import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ResumeTestData {

    private static Resume resume;


    public static Resume initiallyResume(String fullName) {
        Objects.requireNonNull(fullName, "Full name person must not be null");
        resume = new Resume(fullName);
        addSectionContact();
        addSectionText();
        addSectionList();
        addSectionWorkOrganization();
        addSectionStudyOrganization();
        return resume;
    }

    private static void addSectionContact() {
        resume.addContact(SectionContact.PHONE, "+7(111)222-33-44");
        resume.addContact(SectionContact.MAIL, "test@mail.ru");
        resume.addContact(SectionContact.SKYPE, "Skype");
        resume.addContact(SectionContact.MEDIA, "Профиль LinkedIn");
    }

    private static void addSectionText() {
        resume.addSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        resume.addSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
    }

    private static void addSectionList() {
        resume.addSection(SectionType.ACHIEVEMENT, new ListSection(Arrays.asList(
                "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга."
        )));
        resume.addSection(SectionType.QUALIFICATIONS, new ListSection(Arrays.asList(
                "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle",
                "MySQL, SQLite, MS SQL, HSQLDB",
                "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy"
        )));
    }

    private static void addSectionWorkOrganization() {
        resume.addSection(SectionType.EXPERIENCE, new OrganizationSection(Arrays.asList(
                new Organization("Java Online Projects", "www.url.ru",
                        new Position(YearMonth.of(2013, 10), YearMonth.now(), "Автор проекта", "Создание, организация и проведение Java онлайн проектов и стажировок."),
                        new Position(YearMonth.of(2014, 12), YearMonth.now(), "Автор проекта", "Создание, организация и проведение Java онлайн проектов и стажировок.")
                ),
                new Organization("Wrike", "www.url.ru",
                        new Position(YearMonth.of(2014, 10), YearMonth.of(2016, 1), "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.")
                ),
                new Organization("RIT Center", "www.url.ru",
                        new Position(YearMonth.of(2012, 4), YearMonth.of(2014, 10), "Java архитектор", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python")
                )
        )));
    }

    private static void addSectionStudyOrganization() {
        resume.addSection(SectionType.EDUCATION, new OrganizationSection(Arrays.asList(
                new Organization("Coursera", "www.url.ru",
                        new Position(YearMonth.of(2013, 3), YearMonth.of(2013, 5), "Functional Programming Principles in Scala\" by Martin Odersky", "")
                ),
                new Organization("Luxoft", "",
                        new Position(YearMonth.of(2011, 3), YearMonth.of(2011, 4), "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", "")
                ),
                new Organization("Siemens AG", "www.url.ru",
                        new Position(YearMonth.of(2005, 1), YearMonth.of(2005, 4), "3 месяца обучения мобильным IN сетям (Берлин)\"", "")
                ),
                new Organization("Alcatel", "www.url.ru",
                        new Position(YearMonth.of(1997, 9), YearMonth.of(1998, 3), "6 месяцев обучения цифровым телефонным сетям (Москва)", "")
                )
        )));
    }

    public static void printResume(Resume resume) {
        //Output resume Test
        System.out.println("Reg Number: " + resume.getUuid());
        System.out.println(resume.getFullName());
        for (SectionContact typeContact : SectionContact.values()) {
            System.out.print(typeContact.getTitle() + " ");
            System.out.println(resume.getContact(typeContact));
        }
        for (SectionType typeSection : SectionType.values()) {
            System.out.println();
            System.out.println(typeSection.getTitle());
            Section section = resume.getSection(typeSection);
            if (section instanceof TextSection) {
                System.out.println(section.getContent());
            } else if (section instanceof ListSection) {
                printListSection((ListSection) section);
            } else if (section instanceof OrganizationSection) {
                printOrganizationSection((OrganizationSection) section);
            }
        }
    }

    private static void printListSection(ListSection section) {
        List<String> listSection = section.getContent();
        for (String listString : listSection) {
            System.out.println(" * " + listString);
        }
    }

    private static void printOrganizationSection(OrganizationSection section) {
        List<Organization> listSection = section.getContent();
        for (Organization organization : listSection) {
            System.out.println(organization.getNameOrganization());
            for (Position position : organization.getPositions()) {
                System.out.print(position.getStartDate() + " - " + position.getEndDate() + " ");
                System.out.println(position.getPosition());
                System.out.println(position.getActivity());
            }
            System.out.println();
        }
    }
}
