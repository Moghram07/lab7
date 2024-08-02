package com.example.lab7.Controller;

import com.example.lab7.Model.Instructors;
import com.example.lab7.Service.InstructorsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/instructor")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorsService instructorsService;

    @GetMapping("/get")
    public ResponseEntity getInstructors() {
        ArrayList<Instructors> instructors = instructorsService.getInstructors();
        return ResponseEntity.status(200).body(instructors);
    }

    @PostMapping("/add")
    public ResponseEntity addInstructor(@Valid @RequestBody Instructors instructors, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        instructorsService.addInstructors(instructors);
        return ResponseEntity.status(200).body("instructors added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateInstructor(@PathVariable int id,@Valid @RequestBody Instructors instructors, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        instructorsService.updateInstructors(id, instructors);
        return ResponseEntity.status(200).body(instructors);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteInstructor(@PathVariable int id) {
        boolean isDeleted = instructorsService.deleteInstructors(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("Deleted");
        }
        return ResponseEntity.status(404).body("Not Found");
    }
    //when instructor on leave, IsOnLeave will be true, course and numberOfStudents will be changed to zero
    @PutMapping("/apply/{id}")
    public ResponseEntity applyForLeave(@PathVariable int id) {
        boolean leaveApproved = instructorsService.applyForLeave(id);
        if (leaveApproved) {
            return ResponseEntity.status(200).body("Leave Approved, Students will be notified");
        }
        return ResponseEntity.status(404).body("Not Found");
    }

}
