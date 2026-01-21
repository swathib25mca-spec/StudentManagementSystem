import java.sql.*;
import java.util.Scanner;

public class StudentDAO {

    public void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        String idStr = sc.nextLine();
        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter a number.");
            return;
        }
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        System.out.print("Enter Age: ");
        String ageStr = sc.nextLine();
        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Age. Please enter a number.");
            return;
        }
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO student (student_id, name, email, course, age, phone) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, course);
            ps.setInt(5, age);
            ps.setString(6, phone);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student added successfully");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM student";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println("ID\tName\tEmail\tCourse\tAge\tPhone");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getInt(5) + "\t" + rs.getString(6));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID to search: ");
        String idStr = sc.nextLine();
        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter a number.");
            return;
        }
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM student WHERE student_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt(1));
                System.out.println("Name: " + rs.getString(2));
                System.out.println("Email: " + rs.getString(3));
                System.out.println("Course: " + rs.getString(4));
                System.out.println("Age: " + rs.getInt(5));
                System.out.println("Phone: " + rs.getString(6));
            } else {
                System.out.println("Student not found");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID to update: ");
        String idStr = sc.nextLine();
        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter a number.");
            return;
        }
        System.out.print("Enter new Name: ");
        String name = sc.nextLine();
        System.out.print("Enter new Email: ");
        String email = sc.nextLine();
        System.out.print("Enter new Course: ");
        String course = sc.nextLine();
        System.out.print("Enter new Age: ");
        String ageStr = sc.nextLine();
        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Age. Please enter a number.");
            return;
        }
        System.out.print("Enter new Phone: ");
        String phone = sc.nextLine();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE student SET name=?, email=?, course=?, age=?, phone=? WHERE student_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);
            ps.setInt(4, age);
            ps.setString(5, phone);
            ps.setInt(6, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student updated successfully");
            } else {
                System.out.println("Student not found");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID to delete: ");
        String idStr = sc.nextLine();
        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter a number.");
            return;
        }
        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM student WHERE student_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student deleted successfully");
            } else {
                System.out.println("Student not found");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
