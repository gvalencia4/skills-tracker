package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class SkillsController {

    public String[] skills = {"Java", "JavaScript", "C"};

    // Handle request at index
    @GetMapping
    @ResponseBody
    public String skillsHome() {
        return "<html>" +
                "<body>" +
                "<h1>Skills Tracker</h1>" +
                "<h2>Here are a few skills you should learn:</h2>" +
                "<ol>" +
                "<li>" + skills[0] + "</li>" +
                "<li>" + skills[1] + "</li>" +
                "<li>" + skills[2] + "</li>" +
                "</ol>" +
                "<a href='http://localhost:8080/form'>Form 📝</a>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("form")
    @ResponseBody
    // Initial /form html
    public String skillsForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/form/completed' method = 'post'>" + // submit a request to /form/completed
                "<p>Name:</p>" +
                "<input type = 'text' name = 'name' >" +

                "<p>A skill to learn:</p>" +
                "<select name='option1'>" +
                "  <option value=" + skills[0] + ">" + skills[0] + "</option>" +
                "  <option value=" + skills[1] + ">" + skills[1] + "</option>" +
                "  <option value=" + skills[2] + ">" + skills[2] + "</option>" +
                "</select>" +

                "<p>A second skill to learn:</p>" +
                "<select name='option2'>" +
                "  <option value=" + skills[0] + ">" + skills[0] + "</option>" +
                "  <option value=" + skills[1] + ">" + skills[1] + "</option>" +
                "  <option value=" + skills[2] + ">" + skills[2] + "</option>" +
                "</select>" +

                "<p>A third skill to learn:</p>" +
                "<select name='option3'>" +
                "  <option value=" + skills[0] + ">" + skills[0] + "</option>" +
                "  <option value=" + skills[1] + ">" + skills[1] + "</option>" +
                "  <option value=" + skills[2] + ">" + skills[2] + "</option>" +
                "</select>" +

                "<input type = 'submit' value = 'Submit' >" +
                "</form>" +
                "<a href='http://localhost:8080'>Home 🏡</a>" +
                "</body>" +
                "</html>";
    }

    @PostMapping("/form/completed")
    // On form submission, fill in /form/completed
    public String skillsFormSubmit(@RequestParam String name, String option1, String option2, String option3) {
        return "<html>" +
                "<body>" +
                "<h1>" + name + "</h1>" +
                "<ol>" +
                "<li>" + option1 + "</li>" +
                "<li>" + option2 + "</li>" +
                "<li>" + option3 + "</li>" +
                "</ol>" +
                "<a href='http://localhost:8080'>Home 🏡</a>" +
                "<br>" +
                "<a href='http://localhost:8080/form'>Form 📝</a>" +
                "</body>" +
                "</html";

    }
}
