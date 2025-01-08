import java.util.ArrayList;

public interface StudentManager {
    void addStudent(Student student); // Dodawanie studenta
    void removeStudent(String studentID); // Usuwanie studenta
    void updateStudent(String studentID, String name, String semestr, double grade, String studentGroup, String age); // Aktualizowanie danych studenta
    ArrayList<Student> displayAllStudents(); // Wyświetlanie wszystkich studentów
    double calculateAverageGrade(); // Obliczanie średniej ocen
}
