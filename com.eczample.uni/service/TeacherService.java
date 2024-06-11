package service;

import model.DB.DataBase;
import model.impl.Teacher;

public class TeacherService {

    public Teacher creaTeacher(String name, String lastName) {
        int teacherId;
        int size = DataBase.teachersDB.size();

        if (size == 0) {
            teacherId = 1;
        } else {
            teacherId = size + 1;
        }
        Teacher teacher = new Teacher(teacherId, name, lastName);
        DataBase.teachersDB.add(teacher);
        return teacher;
    }

    
}
