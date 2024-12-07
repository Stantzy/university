package com.example.app;

import com.example.models.*;
import jakarta.persistence.*;

import java.util.List;

public class TestSystem {
    private static EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("SpringDbProject");

    public static void main(String[] args) {
        ENTITY_MANAGER_FACTORY.close();

    }

    public static void addMaster(int id, String fName, String lName) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Master master = new Master();
            master.setId(id);
            master.setFirstName(fName);
            master.setLastName(lName);

            entityManager.persist(master);
            entityTransaction.commit();
        } catch (Exception ex) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public static void getMaster(int id) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT m FROM Master m WHERE m.id = :id_Мастер";

        TypedQuery<Master> mtq = entityManager.createQuery(query, Master.class);
        mtq.setParameter("id_Мастер", id);
        Master master = null;

        try {
            master = mtq.getSingleResult();
            System.out.println(master.getFirstName() + " " +
                    master.getLastName());
        } catch(NoResultException ex) {
            System.out.println("ex");
        }
        finally {
            entityManager.close();
        }
    }

    public static void getMasters(int id) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "SELECT m FROM Master m WHERE m.id IS NOT NULL";
        TypedQuery<Master> mtq = entityManager.createQuery(strQuery, Master.class);
        List<Master> masterList;
        try {
            masterList = mtq.getResultList();
            masterList.forEach(master -> System.out.println(master.getFirstName() + " " +
                    master.getLastName()));
        } catch(NoResultException ex) {
            System.out.println("ex");
        }
        finally {
            entityManager.close();
        }
    }


}
