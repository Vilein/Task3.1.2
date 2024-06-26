package task_3_1_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import task_3_1_2.model.User;
import task_3_1_2.service.UserService;

import java.util.List;


@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllUsers(Model model){
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("all", allUsers);
        return "users";
    }
    @GetMapping("/createUser")
    public String newUser(Model model){
        User user = new User();
        model.addAttribute("userAdd", user);
        return "userAdd";
    }
    @PostMapping("/addUser")
    public String create(@ModelAttribute("newUser") User user){
        userService.add(user);
        return "redirect:/";
    }
    @GetMapping ("/deleteUser")
    public String deleteUser(@RequestParam("userID") Long id){
        userService.delete(id);
        return "redirect:/";
    }
    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("newUser") User user){
        userService.update(user);
        return "redirect:/";
    }
    @GetMapping("/getUserById")
    public String findUser(@RequestParam("userID") Long id, Model model ){
        User user = userService.getUserById(id);
        model.addAttribute("newUser", user);
        return "userUpdate";
    }
}