import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1: dao.addStudent(); break;
                case 2: dao.viewStudents(); break;
                case 3: dao.searchStudent(); break;
                case 4: dao.updateStudent(); break;
                case 5: dao.deleteStudent(); break;
                case 6: System.out.println("Thank You"); break;
                default: System.out.println("Invalid Choice");
            }
        } while (choice != 6);

        sc.close();
    }
}
