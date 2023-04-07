package com.HibernateStart.HibeStart;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

public class App {
	public static void main(String[] args) {
		// Configuration for4 SEesion
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Song.class);

		// Create Session Factory
		SessionFactory sf = config.buildSessionFactory();

		// Initialize The session
		Session session = sf.openSession();

		Song song1 = new Song(1, "Gulabi Akhein", "Mohammed Rafi");
		Song song2 = new Song(2, "Likhe Jo Khat Tuzhe", "Mohammed Rafi");
		Song song3 = new Song(3, "Hamen Tumse Pyar Kitna", "Kishore Kumar");

		// Query Generation
		session.beginTransaction();
		session.save(song1);
		session.save(song2);
		session.save(song3);
		session.getTransaction().commit();

		sf.close();

		System.out.println("Executed Successfully !!!");
	}
}
