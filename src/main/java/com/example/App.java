package com.example;

import java.util.Scanner;

import com.example.dao.Model.student.Student;
import com.example.dao.controller.StudentController;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        StudentController stc = new StudentController();
        Scanner in = new Scanner(System.in);
        int choice = 0;
        while (choice != 6) {
            System.out.println("\n************ Welcome to Student Database ************");
            System.out.println("1. Display all Students ");
            System.out.println("2. Display one Student ");
            System.out.println("3. Create a Student ");
            System.out.println("4. Update a Student ");
            System.out.println("5. Remove a Student ");
            System.out.println("6. Exit");
            System.out.println();
            System.out.print("Enter your choice(1-6): ");
            choice = in.nextInt();
            in.nextLine();
            if (choice == 1) {
                stc.getStudents().forEach(x -> System.out.println(x));
            }
            if (choice == 2) {
                stc.getStudents().forEach(x -> System.out.println(x));
                System.out.print("Enter a student id: ");
                int id = in.nextInt();
                in.nextLine();
                Student st = stc.getStudent(id);
                if (st != null)
                    System.out.println(st);
            }
            while (choice == 3) {
                System.out.print("Enter a Student name: ");
                String name = in.nextLine().toUpperCase();
                System.out.print("Enter Student Email: ");
                String email = in.nextLine().toLowerCase();
                System.out.print("Is student active(y/n): ");
                boolean active = in.nextLine().equals("y") ? true : false;
                Student student = new Student(name, email, active);
                System.out.println(student.printBioData() + "\n");
                System.out.print("Is this information Correct?(y/n) :");
                String st = in.nextLine();
                if (st.equals("n")) {
                    System.out.println("Please, Enter the correct information again !!!");

                } else {
                    stc.setStudent(student);
                    choice = -1; // Temporary reset to exit loop
                }
            }
            while (choice == 4) {
                stc.getStudents().forEach(x -> System.out.println(x));
                System.out.print("Enter student id to update: ");
                int id = in.nextInt();
                in.nextLine();

                Student st = stc.getStudent(id);
                System.out.println(st.printBioData());
                System.out.println("Press enter to escape, Make changes in the field appropriately: ");
                System.out.print("Enter a Student name: ");
                String name = in.nextLine();
                if (!name.isEmpty()) {
                    st.setName(name.toUpperCase().strip());
                }
                System.out.print("Enter Student Email: ");
                String email = in.nextLine();
                if (!email.isEmpty()) {
                    st.setEmail(email.toLowerCase().strip());
                }
                System.out.print("Is student active(y/n): ");
                boolean active = in.nextLine().equals("y") ? true : false;
                if (active != st.isActive()) {
                    st.setActive(active);
                }
                System.out.println(st.printBioData() + "\n");
                System.out.print("Is this information Correct?(y/n) :");
                String sts = in.nextLine();
                if (sts.equals("n")) {
                    System.out.println("Please, Enter the correct information again !!!");

                } else {
                    stc.updateStudent(st);
                    choice = -1; // Temporary reset to exit loop
                }
            }
            if (choice == 5) {
                stc.getStudents().forEach(x -> System.out.println(x));
                System.out.print("Enter student id to remove: ");
                int id = in.nextInt();
                in.nextLine();
                Student st = stc.getStudent(id);
                System.out.println(st.printBioData());
                System.out.print("Confirm!!! Do you want to delete Student ?(y/n) :");
                String sts = in.nextLine();
                if (sts.equals("y"))
                    stc.removeStudent(id);
            }

            if (choice != 6) {
                System.out.print("\nDo you want to Continue(y/n): ");
                String st = in.nextLine();
                if (st.equals("n")) {
                    choice = 6;
                    System.out.println("\n************ Exiting Student Database ************");
                }

            }

        }
        in.close();
    }
}
