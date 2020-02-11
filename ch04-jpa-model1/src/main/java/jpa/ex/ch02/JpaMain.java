package jpa.ex.ch02;

import jpa.ex.ch02.member.Member;

import javax.persistence.*;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-acorn");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        emf.close();
    }
}
