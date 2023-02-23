package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("User", "User table");
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/new")
    public String createPageNewUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.oneUser(id));
        return "show";

    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.oneUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUserById(id, user);
        return "redirect:/users";
    }


}
