import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class StudentManagerGUI {
    private JFrame frame;
    private JTextField studentIDField;
    private JTextField nameField;
    private JTextField semestrField;
    private JTextField gradeField;
    private JTextField groupField;
    private JTextField ageField; // Dodano pole age
    private JTextArea displayArea;
    private JButton addButton, updateButton, removeButton, calculateAverageButton, displayButton;

    private final StudentManagerImpl studentManager;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                StudentManagerGUI window = new StudentManagerGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public StudentManagerGUI() {
        studentManager = new StudentManagerImpl();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("System Zarządzania Studentami");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        studentIDField = addLabeledTextField(panel, "ID Studenta:");
        nameField = addLabeledTextField(panel, "Imię:");
        semestrField = addLabeledTextField(panel, "Semestr:");
        gradeField = addLabeledTextField(panel, "Ocena:");
        groupField = addLabeledTextField(panel, "Grupa:");
        ageField = addLabeledTextField(panel, "Wiek:"); // Dodano pole age

        addButton = new JButton("Dodaj");
        addButton.addActionListener(e -> addStudent());
        panel.add(addButton);

        updateButton = new JButton("Zaktualizuj");
        updateButton.addActionListener(e -> updateStudent());
        panel.add(updateButton);

        removeButton = new JButton("Usuń");
        removeButton.addActionListener(e -> removeStudent());
        panel.add(removeButton);

        calculateAverageButton = new JButton("Oblicz Średnią");
        calculateAverageButton.addActionListener(e -> calculateAverage());
        panel.add(calculateAverageButton);

        displayButton = new JButton("Wyświetl Studentów");
        displayButton.addActionListener(e -> displayStudents());
        panel.add(displayButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        frame.getContentPane().add(new JScrollPane(displayArea), BorderLayout.CENTER);
    }

    private JTextField addLabeledTextField(JPanel panel, String labelText) {
        JLabel label = new JLabel(labelText);
        panel.add(label);
        JTextField textField = new JTextField();
        textField.setColumns(10);
        panel.add(textField);
        return textField;
    }

    private void addStudent() {
        try {
            String studentID = studentIDField.getText();
            String name = nameField.getText();
            String semestr = semestrField.getText();
            double grade = Double.parseDouble(gradeField.getText());
            String group = groupField.getText();
            String age = ageField.getText(); // Dodano age
            Student student = new Student(studentID, name, semestr, grade, group, age);
            studentManager.addStudent(student);
            clearFields();
            displayArea.setText("Dodano studenta: " + studentID);
        } catch (NumberFormatException e) {
            displayArea.setText("Błąd: Ocena musi być liczbą.");
        } catch (Exception e) {
            displayArea.setText("Błąd: " + e.getMessage());
        }
    }

    private void updateStudent() {
        try {
            String studentID = studentIDField.getText();
            String name = nameField.getText();
            String semestr = semestrField.getText();
            double grade = Double.parseDouble(gradeField.getText());
            String group = groupField.getText();
            String age = ageField.getText(); // Dodano age
            studentManager.updateStudent(studentID, name, semestr, grade, group, age);
            clearFields();
            displayArea.setText("Zaktualizowano studenta: " + studentID);
        } catch (NumberFormatException e) {
            displayArea.setText("Błąd: Ocena musi być liczbą.");
        } catch (Exception e) {
            displayArea.setText("Błąd: " + e.getMessage());
        }
    }

    private void removeStudent() {
        String studentID = studentIDField.getText();
        studentManager.removeStudent(studentID);
        clearFields();
        displayArea.setText("Usunięto studenta: " + studentID);
    }

    private void calculateAverage() {
        double average = studentManager.calculateAverageGrade();
        displayArea.setText("Średnia ocen: " + average);
    }

    private void displayStudents() {
        ArrayList<Student> students = studentManager.displayAllStudents();
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student).append("\n");
        }
        displayArea.setText(sb.toString());
    }

    private void clearFields() {
        studentIDField.setText("");
        nameField.setText("");
        semestrField.setText("");
        gradeField.setText("");
        groupField.setText("");
        ageField.setText(""); // Dodano age
    }
}
