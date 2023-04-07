
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.STudent.manage.Student;
import com.STudent.manage.StudentDAO;

public class Start {
	public static void main(String[] args) throws IOException {

		System.out.println("Welcome to Student Manage App");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("Press 1 to Add Student");
			System.out.println("Press 2 to Delete Student");
			System.out.println("Press 3 to Display Student");
			System.out.println("Press 4 to Display all Students");
			System.out.println("Press 5 to add exit App");

			int c = Integer.parseInt(br.readLine());

			if (c == 1) {
				// Add Student
				System.out.println("Enter Student Name : ");
				String name = br.readLine();

				System.out.println("Enter User Phone : ");
				String phone = br.readLine();

				System.out.println("Enter User City : ");
				String city = br.readLine();

//				Object to store student
				Student st = new Student(name, phone, city);

				boolean answer = StudentDAO.insertStudentDB(st);
				if (answer) {
					System.out.println("Added successfully ... !!");
				} else {
					System.out.println("Something went WRONG, Try Again...");
				}

				System.out.println(st);

			} else if (c == 2) {
				// Delete Student
				System.out.println("Enter Student ID to delete... : ");
				int sid = Integer.parseInt(br.readLine());

				boolean del = StudentDAO.deleteStudent(sid);

				if (del) {
					System.out.println("Successfully Deleted");
				} else {
					System.out.println("Some Error!! ID Not Found...");
				}
			} else if (c == 3) {
				// Display Student
				System.out.println("Enter Student Id to display : ");
				int sid = Integer.parseInt(br.readLine());
				StudentDAO.viewStudent(sid);
			} else if (c == 4) {
				System.out.println("Entries are as Follows : ");
				StudentDAO.vieAllStudents();
			} else if (c == 5) {
				// exit
				break;
			} else {

			}
		}
		System.out.println("Thank you !!");
		System.out.println("Hope to See you soon.");

	}
}
