package com.STudent.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
	public static boolean insertStudentDB(Student st) {

		Boolean f = false;

		try {

//			JDBC Code
			Connection con = ConnectionProvider.cretaeConn();
			String q = "Insert into students(sname, sphone, scity) values(?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(q);

//			Set value of ? parameter
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());

//			Execute
			pstmt.executeUpdate();
			f = true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudent(int sid) {
		Boolean f = false;

		try {

//			JDBC Code
			Connection con = ConnectionProvider.cretaeConn();
			String q = "Delete from students where sid=?";
			PreparedStatement pstmt = con.prepareStatement(q);

			pstmt.setInt(1, sid);

//			Execute
			pstmt.executeUpdate();
			f = true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

	public static void viewStudent(int sid) {
		// TODO Auto-generated method stub
		try {

//			JDBC Code
			Connection con = ConnectionProvider.cretaeConn();
			String q = "Select * from students where sid=" + sid;
			Statement st = con.createStatement();

			ResultSet set = st.executeQuery(q);

//			Execute
			while (set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);

				System.out.println(id + ", " + name + ", " + phone + ", " + city);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static void vieAllStudents() {
		try {

//			JDBC Code
			Connection con = ConnectionProvider.cretaeConn();
			String q = "select * from students";
			Statement st = con.createStatement();

			ResultSet set = st.executeQuery(q);

//			Execute
			while (set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);

				System.out.println("ID : "+id);
				System.out.println("Name : "+name);
				System.out.println("Phone : "+phone);
				System.out.println("City : "+city);
				System.out.println("------------------------");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
