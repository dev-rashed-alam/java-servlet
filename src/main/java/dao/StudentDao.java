package dao;

import schema.StudentSchema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_servlet_crud", "root", "");

        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    public static int save(StudentSchema student) {
        int status = 0;
        try {
            Connection con = StudentDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into student(first_name, last_name, email, phone_number) values (?,?,?,?)");
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getPhoneNumber());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static List<StudentSchema> findAll() {
        List<StudentSchema> studentList = new ArrayList<>();
        try {
            Connection con = StudentDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudentSchema schema = new StudentSchema();
                schema.setId(rs.getInt("id"));
                schema.setFirstName(rs.getString("first_name"));
                schema.setLastName(rs.getString("last_name"));
                schema.setEmail(rs.getString("email"));
                schema.setPhoneNumber(rs.getString("phoneNumber"));
                studentList.add(schema);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentList;
    }
}
