package com.legacyvault.controller;
import com.legacyvault.entity.UserAccount; import com.legacyvault.repository.UserAccountRepository; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*;
@Controller public class AuthController {
 private final UserAccountRepository users; private final PasswordEncoder encoder;
 public AuthController(UserAccountRepository u,PasswordEncoder e){users=u;encoder=e;}
 @GetMapping("/") public String home(){return "redirect:/dashboard";}
 @GetMapping("/login") public String login(){return "login";}
 @GetMapping("/register") public String register(){return "register";}
 @PostMapping("/register") public String create(@RequestParam String fullName,@RequestParam String email,@RequestParam String password,@RequestParam String confirmPassword,Model m){
  if(fullName.trim().length()<2||!email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")||password.length()<8||!password.equals(confirmPassword)){m.addAttribute("error","Check your name, email, password length (8+), and password confirmation.");return "register";}
  if(users.findByEmail(email.trim().toLowerCase()).isPresent()){m.addAttribute("error","That email is already registered.");return "register";}
  UserAccount u=new UserAccount();u.setFullName(fullName.trim());u.setEmail(email);u.setPassword(encoder.encode(password));u.setLastCheckIn(java.time.LocalDateTime.now());users.save(u);return "redirect:/login?registered";
 }
}
