package com.example.lab7.Controller;

import com.example.lab7.ApiResponse.ApiResponse;
import com.example.lab7.Model.Academy;
import com.example.lab7.Model.Course;
import com.example.lab7.Model.Instructors;
import com.example.lab7.Service.AcademyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/academy")
@RequiredArgsConstructor
public class AcademyController {
    private final AcademyService academyService;

    @GetMapping("/get")
    public ResponseEntity getAcademy(){
        ArrayList<Academy> academies = academyService.getAcademy();
        return ResponseEntity.status(200).body(academies);
    }

    @PostMapping("/add")
    public ResponseEntity addAcademy(@Valid @RequestBody Academy academy, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        academyService.addAcademy(academy);
        return ResponseEntity.status(201).body("academy added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateAcademy(@PathVariable int id, @Valid @RequestBody Academy academy, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = academyService.updateAcademy(id,academy);
        if(isUpdated){
            return ResponseEntity.status(201).body(new ApiResponse("academy updated"));
        }
        return ResponseEntity.status(404).body("academy not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAcademy(@PathVariable int id){
        boolean isDeleted = academyService.deleteAcademy(id);
        if(isDeleted){
            return ResponseEntity.status(201).body("academy deleted");
        }
        return ResponseEntity.status(404).body(new ApiResponse("academy not found"));
    }

    @GetMapping("/{academyId}/courses")
    public ResponseEntity getCoursesByAcademyId(@PathVariable int academyId) {
        ArrayList<Course> courses = academyService.getCoursesByAcademyId(academyId);
        if (courses.isEmpty()){
            return ResponseEntity.status(404).body(new ApiResponse("academy not found"));
        }
        return ResponseEntity.status(200).body(courses);
    }

    @GetMapping("/{academyId}/instructors")
    public ResponseEntity getInstructorsByAcademyId(@PathVariable int academyId) {
        ArrayList<Instructors> instructors = academyService.getInstructorsByAcademyId(academyId);
        if (instructors.isEmpty()){
            return ResponseEntity.status(404).body(new ApiResponse("academy not found"));
        }
        return ResponseEntity.status(200).body(instructors);
    }

}
