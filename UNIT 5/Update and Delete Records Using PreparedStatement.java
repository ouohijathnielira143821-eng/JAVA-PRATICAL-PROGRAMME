
import java.sql.*;
import java.util.Scanner;

public class PreparedUpdateDelete {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "system";
        String password = "your_password";

        Scanner sc = new Scanner(System.in);

        try {
            Connection con =
                DriverManager.getConnection(url, user, password);

            System.out.println("1. Update Employee");
            System.out.println("2. Delete Employee");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                String sql =
                    "UPDATE EMP SET ENAME = ?, SAL = ? WHERE EMPNO = ?";

                PreparedStatement ps = con.prepareStatement(sql);

                sc.nextLine();
                System.out.print("Enter new employee name: ");
                String ename = sc.nextLine();

                System.out.print("Enter new salary: ");
                double sal = sc.nextDouble();

                System.out.print("Enter employee number: ");
                int empno = sc.nextInt();

                ps.setString(1, ename);
                ps.setDouble(2, sal);
                ps.setInt(3, empno);

                int rows = ps.executeUpdate();

                if (rows > 0)
                    System.out.println("Record updated successfully.");
                else
                    System.out.println("Employee not found.");

                ps.close();

            } else if (choice == 2) {
                String sql = "DELETE FROM EMP WHERE EMPNO = ?";

                PreparedStatement ps = con.prepareStatement(sql);

                System.out.print("Enter employee number to delete: ");
                int empno = sc.nextInt();

                ps.setInt(1, empno);

                int rows = ps.executeUpdate();

                if (rows > 0)
                    System.out.println("Record deleted successfully.");
                else
                    System.out.println("Employee not found.");

                ps.close();

            } else {
                System.out.println("Invalid choice.");
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        sc.close();
    }
}
