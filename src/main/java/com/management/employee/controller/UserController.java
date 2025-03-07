package com.management.employee.controller;

import com.management.employee.model.Employee;
import com.management.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/new")
    public String showNewEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-user";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit-user";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") long id, @ModelAttribute("employee") Employee employee) {
        Employee existingEmployee = employeeService.getEmployeeById(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        employeeService.updateEmployee(id , employee);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);
        return "User deleted successfully";
    }

    @GetMapping("/view/{id}")
    public String viewUser(@PathVariable("id") long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "view-user";
    }
}
