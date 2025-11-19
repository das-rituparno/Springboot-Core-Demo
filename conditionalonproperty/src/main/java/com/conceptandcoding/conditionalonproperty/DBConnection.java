package com.conceptandcoding.conditionalonproperty;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DBConnection {

    @Autowired(required = false)
    MySQLConnection sql;
    @Autowired(required = false)
    NoSQLConnection noSql;

    @PostConstruct
    public void init() {
        System.out.println("Database connection bean is created with below dependencies : ");
        System.out.println("is MySQL connection object is null " + Objects.isNull(sql));
        System.out.println("is NoSQL connection object is null " + Objects.isNull(noSql));
    }
}
