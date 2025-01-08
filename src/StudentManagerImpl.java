import java.sql.*;
import java.util.ArrayList;

public class StudentManagerImpl implements StudentManager {
    private static final String DATABASE_URL = "jdbc:sqlite:students.db"; // Ścieżka do bazy danych

    private Connection connect() {
        try {
            return DriverManager.getConnection(DATABASE_URL);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addStudent(Student student) {
        String query = "INSERT INTO students(studentID, name, semestr, grade, student_group, age) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getStudentID());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getSemestr());
            stmt.setDouble(4, student.getGrade());
            stmt.setString(5, student.getStudentGroup());
            stmt.setString(6, student.getAge()); // Dodano age
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeStudent(String studentID) {
        String query = "DELETE FROM students WHERE studentID = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, studentID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(String studentID, String name, String semestr, double grade, String studentGroup, String age) {
        String query = "UPDATE students SET name = ?, semestr = ?, grade = ?, student_group = ?, age = ? WHERE studentID = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, semestr);
            stmt.setDouble(3, grade);
            stmt.setString(4, studentGroup);
            stmt.setString(5, age); // Dodano age
            stmt.setString(6, studentID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Student> displayAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String studentID = rs.getString("studentID");
                String name = rs.getString("name");
                String semestr = rs.getString("semestr");
                double grade = rs.getDouble("grade");
                String studentGroup = rs.getString("student_group");
                String age = rs.getString("age"); // Dodano age
                students.add(new Student(studentID, name, semestr, grade, studentGroup, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public double calculateAverageGrade() {
        String query = "SELECT AVG(grade) AS averageGrade FROM students";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble("averageGrade");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
