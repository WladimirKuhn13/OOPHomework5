package view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import model.impl.Teacher;
import model.impl.Student;
import controller.TeacherController;
import controller.StudentController;
import controller.StudentGroupController;
import model.StudentGroup;


public class StudentGroupView {

    private StudentGroupController studentGroupController = new StudentGroupController();
    private StudentController studentController = new StudentController();
    private TeacherController teacherController = new TeacherController();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - создать группу");
            System.out.println("2 - найти группу по id");
            System.out.println("3 - распечатать информацию о группе");
            System.out.println("4 - распечатать id студентов и преподавателья конкретной группы");
            System.out.println("5 - выход");

            switch (scanner.nextInt()) {
                case 1 -> creaStudentGroup();
                case 2 -> getStudentGroupById();
                case 3 -> showStudentGroud();
                case 4 -> getStudentsAndTeacherIds();
                case 5 -> System.exit(0);

                default -> System.out.println("Операция не поддерживается");
            }
        }
    }

    private StudentGroup creaStudentGroup() {

        List<Student> students = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя преподавателья:");
        String teacherName = scanner.nextLine();
        System.out.println("Введите фамилию преподавателья:");
        String teacherLastName = scanner.nextLine();

        Teacher teacher = teacherController.creaTeacher(teacherName, teacherLastName);

        boolean flag = true;
        
        while (flag == true) {
            Scanner scannerStudent = new Scanner(System.in);
            System.out.println("Введите имя студента:");
            String studentName = scannerStudent.nextLine();
            System.out.println("Введите фамилию студента:");
            String studentLastName = scannerStudent.nextLine();
            students.add(studentController.createStudent(studentName, studentLastName, 0));
            
            System.out.println("0 - закончить формирование группы");
            System.out.println("1 - продолжить формирование группы");

            switch (scanner.nextInt()) {
                case 0: 
                    flag = false;
                case 1:
                    continue;
                default:
                    System.out.println("Операция не поддерживается");
            }
        }

        
        StudentGroup studentGroup = studentGroupController.creaStudentGroup(teacher, students);
        studentGroupController.setIdStudents(studentGroup);
        return studentGroup;

    }

    private StudentGroup getStudentGroupById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id группы: ");
        int groupId = scanner.nextInt();
        StudentGroup studentGroup = studentGroupController.getStudentGroupById(groupId);
        System.out.println(studentGroup);
        return studentGroup;
    }

    private void showStudentGroud() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id группы: ");
        int groupId = scanner.nextInt();
        studentGroupController.showStudentGroud(groupId);
    }

    private void getStudentsAndTeacherIds() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id группы: ");
        int groupId = scanner.nextInt();
        studentGroupController.getStudentsAndTeacherIds(groupId);
    }

    
}
