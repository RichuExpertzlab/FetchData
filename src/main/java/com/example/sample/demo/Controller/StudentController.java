// StudentController.java
package com.example.sample.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sample.demo.Entity.Student;
import com.example.sample.demo.Service.StudentService;

import java.util.List;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String showStudentSelection(Model model) {
        List<Long> rollNumbers = studentService.getAllRollNumbers();
        model.addAttribute("rollNumbers", rollNumbers);
        return "studentSelection";
    }
    @GetMapping("/getStudentName")
@ResponseBody
public String getStudentNameByRollNumber(@RequestParam("rollNumber") Long rollNumber) {
    return studentService.getStudentNameByRollNumber(rollNumber);
}

}
