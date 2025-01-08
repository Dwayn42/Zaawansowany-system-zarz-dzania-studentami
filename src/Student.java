public class Student {
    private final String studentID;
    private final String name;
    private final String semestr;
    private final double grade;
    private final String studentGroup;
    private final String age; // Dodano pole age

    public Student(String studentID, String name, String semestr, double grade, String studentGroup, String age) {
        this.studentID = studentID;
        this.name = name;
        this.semestr = semestr;
        this.grade = grade;
        this.studentGroup = studentGroup;
        this.age = age; // Dodano age
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getSemestr() {
        return semestr;
    }

    public double getGrade() {
        return grade;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public String getAge() { // Getter dla age
        return age;
    }

    @Override
    public String toString() {
        return "StudentID: " + studentID + ", Name: " + name + ", Semestr: " + semestr + ", Grade: " + grade + ", Group: " + studentGroup + ", Age: " + age;
    }
}
