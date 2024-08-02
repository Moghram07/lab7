package com.example.lab7.Controller;
import com.example.lab7.Model.Course;
import com.example.lab7.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getCourse(){
        ArrayList<Course> courses = courseService.getCourses();
        return ResponseEntity.status(200).body(courses);
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        courseService.addCourse(course);
        return ResponseEntity.status(201).body("Course added");
    }

    @PutMapping("/update/{code}")
    public ResponseEntity updateCourse(@PathVariable int code, @Valid @RequestBody Course course, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = courseService.updateCourse(code, course);
        if(isUpdated){
            return ResponseEntity.status(201).body("Course updated");
        }
        return ResponseEntity.status(404).body("Course not found");
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity deleteCourse(@PathVariable int code){
        boolean isDeleted = courseService.deleteCourse(code);
        if(isDeleted){
            return ResponseEntity.status(201).body("Course deleted");
        }
        return ResponseEntity.status(404).body("Course not found");
    }
    //to make the course mandatory, will set boolean isMandatory to true
    @PutMapping("/mandatory/{code}")
    public ResponseEntity mandateCourse(@PathVariable int code){
        for(Course course : courseService.getCourses()){
            if(course.getCode() == code){
                courseService.mandateCourse(code);
                return ResponseEntity.status(201).body("Course is mandatory");
            }
        }
        return ResponseEntity.status(404).body("Course not found");
    }

}
