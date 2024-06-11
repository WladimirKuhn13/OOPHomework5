package controller;

import java.util.List;

import model.StudentGroup;
import model.impl.Student;
import model.impl.Teacher;
import service.StudentGroupService;

public class StudentGroupController {
    
    private StudentGroupService service = new StudentGroupService();

    public StudentGroup creaStudentGroup (Teacher teacher, List<Student> students) {
        return service.creaStudentGroup(teacher, students);
    }

    public StudentGroup getStudentGroupById (int studentGroupId) {
        return service.getStudentGroupById(studentGroupId);
    }

    public void getStudentsAndTeacherIds(int studentGroupId) {
        service.getStudentsAndTeacherIds(studentGroupId);
    }

    public void showStudentGroud(int studentGroupId) {
        service.showStudentGroud(studentGroupId);
    }

    public void setIdStudents(StudentGroup studentGroup) {
        service.setIdStudents(studentGroup);
    }

}
