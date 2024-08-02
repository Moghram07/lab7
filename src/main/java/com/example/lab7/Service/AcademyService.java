package com.example.lab7.Service;

import com.example.lab7.Model.Academy;
import com.example.lab7.Model.Course;
import com.example.lab7.Model.Instructors;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcademyService {

    private final InstructorsService instructorsService;
    private final CourseService courseService;
    ArrayList<Academy> academyList = new ArrayList<Academy>();

    public AcademyService(InstructorsService instructorsService, CourseService courseService) {
        this.instructorsService = instructorsService;
        this.courseService = courseService;
    }

    public ArrayList<Academy> getAcademy() {
        return academyList;
    }

    public void addAcademy(Academy academy) {
        academyList.add(academy);
    }

    public boolean updateAcademy(int id, Academy academy) {
        for (int i = 0; i < academyList.size(); i++) {
            if (academyList.get(i).getAcademyId() == id) {
                academyList.set(i, academy);
                return true;
            }
        }
        return false;
    }

    public boolean deleteAcademy(int id) {
        for (int i = 0; i < academyList.size(); i++) {
            if (academyList.get(i).getAcademyId() == id) {
                academyList.remove(i);
                return true;
            }
        }
        return false;
    }

    public Academy getAcademyById(int id) {
        for (int i = 0; i < academyList.size(); i++) {
            if (academyList.get(i).getAcademyId() == id) {
                return academyList.get(i);
            }
        }
        return null;
    }

    public ArrayList<Instructors> getInstructorsByAcademyId(int academyId) {
        return instructorsService.getInstructorsByAcademyId(academyId);
    }

    public ArrayList<Course> getCoursesByAcademyId(int academyId) {
        return courseService.getCoursesByAcademyId(academyId);
    }

}
