package org.example.task_6;

import org.example.task_6.Entity.Role;
import org.example.task_6.Entity.User;
import org.hibernate.Session;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");


        User user = new User("Peter", Role.USER);
        user.setRole(Role.DEVELOPER);
        user.setInsertTime(new Date());

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        System.out.println("User id: " + user.getId());
        session.getSessionFactory().close();
        System.out.println("Hello world!");
    }
}