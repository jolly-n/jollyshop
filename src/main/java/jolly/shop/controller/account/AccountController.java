package jolly.shop.controller.account;

import jolly.shop.domain.User;
import jolly.shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
@Slf4j
public class AccountController {

    private final UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "/account/login";
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "/account/signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/";
    }

}
