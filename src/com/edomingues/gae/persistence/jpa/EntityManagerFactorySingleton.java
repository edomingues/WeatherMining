package com.edomingues.gae.persistence.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

    private static final EntityManagerFactory instance =
        Persistence.createEntityManagerFactory("transactions-optional");

    private EntityManagerFactorySingleton() {}

    public static EntityManagerFactory getInstance() {
        return instance;
    }
	
}
