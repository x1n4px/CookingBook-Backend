package es.code.xin4px.sdt.spring.jpa.coockingBook.service;

import es.code.xin4px.sdt.spring.jpa.coockingBook.exception.ResourceNotFoundException;
import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.User;
import es.code.xin4px.sdt.spring.jpa.coockingBook.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository repo;
    public User saveUser(User user){
        return repo.save(user);
    }

    public User findUserByEmailId(String email){
        return repo.findByEmailId(email);
    }

    public User fetchUserByEmailAndPassword(String email, String password){
        return repo.findByEmailIdAndPassword(email, password);
    }

    public User fetchUserByEmail(String Email){
        return repo.findByEmailId(Email);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User usuario = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con el id : " + id));

        return ResponseEntity.ok((usuario));
    }




}
