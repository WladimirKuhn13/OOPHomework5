package controller;

import model.impl.Teacher;
import service.TeacherService;

public class TeacherController {

    private TeacherService service = new TeacherService();

    public Teacher creaTeacher(String name, String lastName) {
        return service.creaTeacher(name, lastName);

    }

}
