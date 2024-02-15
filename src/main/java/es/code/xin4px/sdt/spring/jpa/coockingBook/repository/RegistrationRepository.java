package es.code.xin4px.sdt.spring.jpa.coockingBook.repository;

import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<User, Long> {
    public User findByEmailId(String emailId);
    public User findByEmailIdAndPassword(String emailId, String password);

}
