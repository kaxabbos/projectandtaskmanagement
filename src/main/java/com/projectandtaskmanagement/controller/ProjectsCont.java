package com.projectandtaskmanagement.controller;

import com.projectandtaskmanagement.controller.main.Attributes;
import com.projectandtaskmanagement.model.Projects;
import com.projectandtaskmanagement.model.Tasks;
import com.projectandtaskmanagement.model.enums.Category;
import com.projectandtaskmanagement.model.enums.Status;
import com.projectandtaskmanagement.model.enums.Urgency;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects")
public class ProjectsCont extends Attributes {

    @GetMapping
    public String Projects(Model model) {
        AddAttributesProjects(model);
        return "projects";
    }

    @PostMapping("/add")
    public String Add(@RequestParam String name, @RequestParam Category category, @RequestParam Urgency urgency, @RequestParam String date) {
        projectsRepo.save(new Projects(name, date, category, urgency));
        return "redirect:/projects";
    }

    @PostMapping("/{id}/edit")
    public String Update(@RequestParam Status status, @PathVariable Long id) {
        Projects project = projectsRepo.getReferenceById(id);
        project.setStatus(status);
        projectsRepo.save(project);
        return "redirect:/projects";
    }

    @PostMapping("/{id}/tasks/add/")
    public String TaskAdd(@RequestParam String name, @RequestParam String date, @RequestParam Category category, @RequestParam Long idEmployee, @PathVariable Long id) {
        tasksRepo.save(new Tasks(name, date, category, projectsRepo.getReferenceById(id), usersRepo.getReferenceById(idEmployee)));
        return "redirect:/projects/{id}/tasks/";
    }

    @GetMapping("/{id}/tasks/")
    public String Tasks(Model model, @PathVariable Long id) {
        AddAttributesTasks(model, id);
        return "tasks";
    }

    @GetMapping("/{idProject}/tasks/{idTask}/description")
    public String TaskDescription(Model model, @PathVariable Long idProject, @PathVariable Long idTask) {
        AddAttributesTaskDescription(model, idProject, idTask);
        return "tasksDescription";
    }

    @PostMapping("/{idProject}/tasks/{idTask}/edit/description")
    public String TaskDescriptionEdit(@PathVariable Long idProject, @PathVariable Long idTask, @RequestParam String description) {
        Tasks task = tasksRepo.getReferenceById(idTask);
        task.getDescription().setDescription(description);
        tasksRepo.save(task);
        return "redirect:/projects/{idProject}/tasks/{idTask}/description";
    }

    @GetMapping("/{idProject}/tasks/{idTask}/delete")
    public String TaskDelete(@PathVariable Long idProject, @PathVariable Long idTask) {
        tasksRepo.deleteById(idTask);
        return "redirect:/projects/{idProject}/tasks";
    }

    @GetMapping("/delete/{id}")
    public String Delete(@PathVariable Long id) {
        projectsRepo.deleteById(id);
        return "tasks";
    }

}
