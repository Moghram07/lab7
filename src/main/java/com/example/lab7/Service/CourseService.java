package com.example.lab7.Service;

import com.example.lab7.Model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {
    ArrayList<Course> courses = new ArrayList<Course>();

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public boolean updateCourse(int code, Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCode() == code){
                courses.set(i, course);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCourse(int code) {
        for (Course course : courses) {
            if(course.getCode() == code){
                courses.remove(course);
                return true;
            }
        }
        return false;
    }

    public boolean mandateCourse(int code){
        for (Course course : courses) {
            if(course.getCode() == code){
                course.setMandatory(true);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Course> getCoursesByAcademyId(int academyId) {
        for (Course course : courses) {
            if (course.getAcademyId() == academyId) {
                return courses;
            }
        }
        return null;
    }
}
