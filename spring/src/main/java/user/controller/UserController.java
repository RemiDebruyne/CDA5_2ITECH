package user.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import user.model.User;
import user.repository.UserRepository;
import user.service.LoginService;

import javax.naming.Binding;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
@Controller
public class UserController {

    private final LoginService loginService;
    private final UserRepository userRepository;;

    public UserController(LoginService loginService, UserRepository userRepository) {
        this.loginService = loginService;
        this.userRepository = userRepository;
    }

    @RequestMapping("/")
    public String home(Model model) {
        User user = loginService.isLoggedIn();
        model.addAttribute("user", user);
        return "home";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "User/LoginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        User loggedUser = loginService.login(user.getUsername(), user.getPassword());
        if(loggedUser != null) {
            return "redirect:/profile/" + loggedUser.getId();
        }
        model.addAttribute("isLoginFail", true);
        return "redirect:/";
    }

    @RequestMapping("/profile/{userId}")
    public String profile(@PathVariable("userId") int userId, Model model)
    {
        User user = userRepository.findById(userId).orElse(null);
        model.addAttribute("user", user);
        return "User/UserProfile";
    }

    @RequestMapping("/logout")
    public String logout(Model model) {
        loginService.logout();
        return "redirect:/";
    }

    @PostMapping("/profile/update")
        public String profileImage(@Valid @ModelAttribute("user") User user, BindingResult result, @RequestParam("profilePicturePath") MultipartFile image) throws IOException {
        Path path = Paths.get("src/main/resources/static/image").resolve(image.getOriginalFilename());

        InputStream inputStream = image.getInputStream();

        Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
        user.setProfilePicturePath(image.getOriginalFilename());
        userRepository.save(user);
        return "redirect:/profile/" + user.getId();
    }

}
