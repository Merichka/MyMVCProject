package ru.merichka.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.merichka.models.User;
import ru.merichka.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"", "/", "list"})
    public String showAllUsers(Model model, @ModelAttribute("flashMessage") String flashAttribute) {
        model.addAttribute("users", userService.getAllUsers());

        return "list";
    }

    @GetMapping(value = "/new")
    public String addUserForm(@ModelAttribute("user") User user) {
        return "users";
    }

    @GetMapping("/edit")
    public String editUserForm(@RequestParam(value = "id", required = true, defaultValue = "") long id,
                               RedirectAttributes attributes) {
        User user = userService.readUser((long) id);

        if (null == user) {
            attributes.addFlashAttribute("flashMessage", "User are not exists!");

        }
        return "redirect:/users";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                           RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return "user";
        }

        userService.createOrUpdateUser(user);
        attributes.addFlashAttribute("flashMessage",
                "User " + user.getName() + " successfully created!");
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam(value = "id", required = true, defaultValue = "") long id,
                             RedirectAttributes attributes) {
        User user = userService.deleteUser((long) id);

        attributes.addFlashAttribute("flashMessage", (null == user) ?
                "User are not exists!" :
                "User " + user.getName() + " successfully deleted!");

        return "redirect:/users";
    }
}
