package net.javaguides.springbootbackend.controller;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import net.javaguides.springbootbackend.model.Student;
import net.javaguides.springbootbackend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import net.javaguides.springbootbackend.exception.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    // Get all student api
@GetMapping("/students")
public List<Student> getAllStudent(){
    return studentRepository.findAll();
}

    // Create student rest api
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

// Update student rest api
@PutMapping("/students/{id}")
public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails){
    Student student = studentRepository.findById(id)
            .orElseThrow(() -> new ResourceAccessException("Student not exits with id "    + id ));

    student.setPointNumberOne(studentDetails.getPointNumberOne());
    student.setPointNumberTwo(studentDetails.getPointNumberTwo());
    student.setPointNumberThree(studentDetails.getPointNumberThree());

    Student updatedStudent = studentRepository.save(student);
    return ResponseEntity.ok(updatedStudent);
}

// Delete student rest api
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id){
    Student student = studentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));

    studentRepository.delete(student);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return ResponseEntity.ok(response);
    }

 // Get student by id
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Student not exist with id : " + id));
        return ResponseEntity.ok(student);
    }

// Search point api
@GetMapping("/students/{keyword}")
    public Page<Student> searchingAllStudents(Pageable pageable, @PathVariable("keyword") String keyword) {
    return studentRepository.findAll(pageable, keyword);
    }
}
