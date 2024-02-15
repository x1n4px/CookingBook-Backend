package es.code.xin4px.sdt.spring.jpa.coockingBook.controller;

import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.User;
import es.code.xin4px.sdt.spring.jpa.coockingBook.repository.RegistrationRepository;
import es.code.xin4px.sdt.spring.jpa.coockingBook.service.RegistrationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {
    private final BCryptPasswordEncoder encoder2 = new BCryptPasswordEncoder();

    @Autowired
    private RegistrationService service;
    @Autowired
    private RegistrationRepository repo;


    @PostMapping ("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        System.out.println("Controller Called");
        user.setPassword(encoder2.encode(user.getPassword()));
        return ResponseEntity.ok(repo.save(user));
    }

    @PostMapping("/login")
    public User loginUser(HttpServletRequest request, @RequestBody User user) throws Exception {
        String tempEmailId = user.getEmailId();
        String tempPass = user.getPassword();
        if(tempEmailId == null || tempPass == null || tempEmailId.isEmpty() || tempPass.isEmpty()) {
            throw new Exception("Debe proporcionar correo electrónico y contraseña.");
        }
        User userObj = service.fetchUserByEmail(tempEmailId);
        if(userObj == null){
            throw new Exception("Credenciales incorrectas");
        }
        boolean math = encoder2.matches(tempPass, userObj.getPassword());
        if(!math){
            throw new Exception("La contraseña no coincide");
        }
        //Guardamos el usuario en la sesion actual
        HttpSession session = request.getSession();
        session.setAttribute("user", userObj);
        return userObj;
    }


     @PostMapping("/changePass")
    public ResponseEntity<?> changePassword(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String currentPassword = request.get("currentPassword");
        String newPassword = request.get("newPassword");

        User user = repo.findByEmailId(email);
        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
            return ResponseEntity.badRequest().body("Incorrect current password");
        }

        String encodedNewPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedNewPassword);
        repo.save(user);

        return ResponseEntity.ok("Password changed successfully");
    }
/*
    @GetMapping("/profile")
    public User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");
        return currentUser;
    }
*/



    @GetMapping("/profile")
    public String  getUserDetails(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("emailId");
        if (user != null) {
            return "Welcome, " + user.getEmailId();
        } else {
            return "Please log in first.";
        }
    }

}
