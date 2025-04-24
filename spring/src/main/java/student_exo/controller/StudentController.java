package student_exo.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import student_exo.model.Student;
import student_exo.service.StudentService;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/")
    public String getAll(Model model){
//        model.addAttribute("students", studentService.getAll());
        model.addAttribute("students", studentService.getAll());
        model.addAttribute("student", new Student());

        return "StudentView";
    }

    @GetMapping("/students/{id}")
    public String getStudent(Model model, @PathVariable int id){
        model.addAttribute("student", studentService.get(id));
        return "StudentDetails";
    }

    @PostMapping("/search")
    public String search(@ModelAttribute("student") Student student){

        return "redirect:/students/"+ student.getLastName();
    }

    @RequestMapping("/form")
    public String getForm(Model model){
        model.addAttribute("student", new Student());
        return "StudentForm";
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable int id){
        Student student = studentService.get(id);
        model.addAttribute("student", student);

        return "StudentForm";
    }

    @PostMapping("/students")
    public String addStudent(@Valid @ModelAttribute("student") Student student,  BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "StudentForm";
        }
        studentService.addOrUpdate(student);
        return "redirect:/";
    }


    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        Student student = studentService.get(id);
        studentService.delete(student);
        return "redirect:/";
    }
}
