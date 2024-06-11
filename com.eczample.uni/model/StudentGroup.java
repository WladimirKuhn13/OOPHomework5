package model;

import java.util.List;

import model.impl.Student;
import model.impl.Teacher;

public class StudentGroup {

    private int groupId;
    private Teacher teacher;
    private List<Student> students;


    public StudentGroup(Teacher teacher, List<Student> students, int groupId) {
        this.groupId = groupId;
        this. teacher = teacher;
        this.students = students;
    }
 
    public int getStudentGroupId() {
        return groupId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {

        return "Преподаватель: " + teacher.name + " Студенты: " + students;
    }


    
}
