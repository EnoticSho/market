package gb.ru.market.controllers;

import gb.ru.market.entity.Role;
import gb.ru.market.entity.Status;
import gb.ru.market.entity.User;
import gb.ru.market.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
@PreAuthorize("hasAuthority('users')")
public class UserController {

    private final UserDetailsServiceImpl userService;

    @Autowired
    public UserController(UserDetailsServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("role", Role.ADMIN);
        System.out.println(userService);
        return "users/All_users";
    }

    @GetMapping("/new")
    @PreAuthorize("hasAuthority('editing')")
    public String formForNewUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("roles", Arrays.stream(Role.values()).filter(a -> a != Role.ADMIN).collect(Collectors.toList()));
        model.addAttribute("status", Status.values());
        return "users/form";
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('editing')")
    public String createUser(@ModelAttribute("user") User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    @PreAuthorize("hasAuthority('editing')")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("userEdit", userService.getUserById(id));
        model.addAttribute("roles", Arrays.stream(Role.values()).filter(a -> a != Role.ADMIN).collect(Collectors.toList()));
        model.addAttribute("status", Status.values());
        return "users/edit_form";
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('editing')")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @PatchMapping()
    @PreAuthorize("hasAuthority('editing')")
    public String update(@ModelAttribute("userEdit") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
}
