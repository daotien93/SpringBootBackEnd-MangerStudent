package net.javaguides.springbootbackend.controller;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.javaguides.springbootbackend.model.Student;
import net.javaguides.springbootbackend.repository.StudentRepository;

public class StudentControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentRepository studentRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenStudentObject_whenCreateStudent_thenReturnSavedStudent() throws Exception{
         // Setup
    }
}
