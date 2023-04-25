package mierim.model.repository.sistema;

import mierim.model.entity.sistema.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
