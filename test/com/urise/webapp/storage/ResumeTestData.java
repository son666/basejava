package com.urise.webapp.storage;

import com.urise.webapp.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Arrays;

public class ResumeTestData {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");

    public static void main(String[] args) throws ParseException {
        Resume resume = new Resume("TestName");
        resume.addContact(SectionContact.PHONE, "+7(111)222-33-44");
        resume.addContact(SectionContact.MAIL, "test@mail.ru");
        resume.addContact(SectionContact.SKYPE, "skype");

        resume.addSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        resume.addSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
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
        resume.addSection(SectionType.EXPERIENCE, new OrganizationSection(Arrays.asList(
                new Position("Java Online Projects", YearMonth.of(2013, 10), YearMonth.now(), "Автор проекта", "Создание, организация и проведение Java онлайн проектов и стажировок."),
                new Position("Wrike", YearMonth.of(2014, 10), YearMonth.of(2016, 1), "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."),
                new Position("RIT Center", YearMonth.of(2012, 4), YearMonth.of(2014, 10), "Java архитектор", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python")
        )));
        resume.addSection(SectionType.EDUCATION, new OrganizationSection(Arrays.asList(
                new Position("Coursera", YearMonth.of(2013, 3), YearMonth.of(2013, 5), "Functional Programming Principles in Scala\" by Martin Odersky", ""),
                new Position("Luxoft", YearMonth.of(2011, 3), YearMonth.of(2011, 4), "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", ""),
                new Position("Siemens AG", YearMonth.of(2005, 1), YearMonth.of(2005, 4), "3 месяца обучения мобильным IN сетям (Берлин)\"", ""),
                new Position("Alcatel", YearMonth.of(1997, 9), YearMonth.of(1998, 3), "6 месяцев обучения цифровым телефонным сетям (Москва)", "")
        )));

        System.out.println(resume);

    }
}
