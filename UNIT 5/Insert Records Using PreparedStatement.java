
import java.sql.*;
import java.util.Scanner;

public class JDBCPreparedInsert {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "system";
        String password = "your_password";

        String sql = "INSERT INTO EMP (EMPNO, ENAME, SAL) VALUES (?, ?, ?)";

        try (
            Connection con = DriverManager.getConnection(url, user, password);
            Scanner sc = new Scanner(System.in);
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            System.out.print("Enter employee number: ");
            int empno = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter employee name: ");
            String ename = sc.nextLine();

            System.out.print("Enter salary: ");
            double sal = sc.nextDouble();

            ps.setInt(1, empno);
            ps.setString(2, ename);
            ps.setDouble(3, sal);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Record inserted successfully.");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
