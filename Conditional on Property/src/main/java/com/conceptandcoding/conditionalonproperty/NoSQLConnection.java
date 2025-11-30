package com.conceptandcoding.conditionalonproperty;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "nosqlconnection", value = "enabled",
        havingValue = "true", matchIfMissing = false)
public class NoSQLConnection {
    public NoSQLConnection() {
        System.out.println("Initialization of NoSQL Connection Bean");
    }
}
