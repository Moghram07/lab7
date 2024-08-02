package com.example.lab7.Service;

import com.example.lab7.Model.Instructors;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InstructorsService {
    ArrayList<Instructors> instructors = new ArrayList<>();

    public ArrayList<Instructors> getInstructors() {
        return instructors;
    }

    public void addInstructors(Instructors instructor) {
        instructors.add(instructor);
    }

    public boolean updateInstructors(int id, Instructors instructor) {
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getId() == id) {
                instructors.set(i, instructor);
                return true;
            }
        }
        return false;
    }

    public boolean deleteInstructors(int id) {
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getId() == id) {
                instructors.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean applyForLeave(int id){
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getId() == id) {
                instructors.get(i).setOnLeave(true);
                instructors.get(i).setNumberOfStudents(0);
                instructors.get(i).setCourse("Not Available");
                return true;
            }
        }
        return false;
    }
    public ArrayList<Instructors> getInstructorsByAcademyId(int academyId) {
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getAcademyId() == academyId) {
                return instructors;
            }
        }
        return null;
    }

}
