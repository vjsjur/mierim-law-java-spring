package mierim.rest.sistema;


import lombok.RequiredArgsConstructor;
import mierim.model.repository.sistema.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import mierim.model.entity.sistema.User;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserRepository repository;


    @GetMapping
    public List<User> findAll(){
      List<User> result =   repository.findAll();
      return result;
    }


    @PostMapping
    public User insert(@RequestBody User user){
        User result = repository.save(user);
        return result;
    }
}
