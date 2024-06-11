package service;

import java.util.ArrayList;
import java.util.List;

import model.StudentGroup;
import model.DB.DataBase;
import model.impl.Teacher;
import model.impl.Student;

public class StudentGroupService {

    public StudentGroup creaStudentGroup (Teacher teacher, List<Student> students) {
        int groupId;
        int size = DataBase.studentGroupDB.size();

        if (size == 0) {
            groupId = 1;
        }
        else {
            groupId = size + 1;
        }
        StudentGroup studentGroup = new StudentGroup(teacher, students, groupId);
        DataBase.studentGroupDB.add(studentGroup);
        return studentGroup;
    }

    public StudentGroup getStudentGroupById (int studentGroupId) {
        StudentGroup studentGroup = DataBase.studentGroupDB.
            stream().filter(s -> s.getStudentGroupId() == studentGroupId).
            findFirst().
            orElse(null);
            if (studentGroup == null) {
                System.out.println("Группа не найдена!");
            }
            return studentGroup;
        
    }

    public void getStudentsAndTeacherIds(int studentGroupId) {

        StudentGroup studentGroup = getStudentGroupById(studentGroupId);

        List<Integer> idStudents = new ArrayList<>();

        System.out.println("ID учителя: " + " " + studentGroup.getTeacher().getId());
        for (int i = 0; i < studentGroup.getStudents().size(); i++) {
            // System.out.println("ID " + i +"-го" + " " + studentGroup.getStudents().get(i).getId());
            idStudents.add(studentGroup.getStudents().get(i).getId());
        }
        System.out.println("ID учащихся: " + idStudents);
    }
    
    public void showStudentGroud(int studentGroupId) {

        StudentGroup studentGroup = getStudentGroupById(studentGroupId);

        System.out.println("Преподаватель группы: " + " " + studentGroup.getTeacher());

        System.out.println("Учащиеся группы: ");

        for (int i = 0; i < studentGroup.getStudents().size(); i++) {
            System.out.println(studentGroup.getStudents().get(i));
        }
    }

    public void setIdStudents(StudentGroup studentGroup) {

        for(int i = 0; i < studentGroup.getStudents().size(); i++) {
            studentGroup.getStudents().get(i).setGroupId(studentGroup.getStudentGroupId());
        }
    }
}

