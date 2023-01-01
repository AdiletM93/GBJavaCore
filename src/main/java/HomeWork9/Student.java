package HomeWork9;

import java.util.List;

public class Student {
    private String studentName;
    private List<Course> courses;

    public Student(String studentName, List<Course> courses) {
        this.studentName = studentName;
        this.courses = courses;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + studentName + '\'' +
                ", courses=" + courses +
                '}';
    }
}


