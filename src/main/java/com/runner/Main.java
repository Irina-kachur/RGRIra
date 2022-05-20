package com.runner;

import com.Utis.NewHibernateUtil;
import com.Utis.Order;
import com.Utis.Reader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();

        Transaction t = s.beginTransaction();
        List<Reader> readers = s.createQuery("from Reader r where r.id in (select idReader from Order o " +
                "where o.dateGetting = :date)").setParameter("date", LocalDate.parse("2022-04-15")).list();
        for (Reader reader : readers) {
            System.out.println(reader.getFullName() + "; телефон: " + reader.getPhoneNumber() + "; адресс: " + reader.getAddress());
        }
        t.commit();

        Transaction t1 = s.beginTransaction();
        List<Order> orders = s.createQuery("from Order o").list();
        for (Order order : orders) {
            System.out.println("Дата выдачи: " + order.getDateGetting() + "; читатель: " + order.getIdStaff().getFullName()
                    + "; работник: " + order.getIdReader().getFullName() + "; книга:" + order.getIdBook().getName());
        }
        t1.commit();

        s.close();
        sf.close();
    }

}
