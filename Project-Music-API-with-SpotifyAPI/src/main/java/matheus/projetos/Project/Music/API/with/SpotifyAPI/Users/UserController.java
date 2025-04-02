package matheus.projetos.Project.Music.API.with.SpotifyAPI.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class UserController{
    @Autowired
    private UserService service;


@GetMapping("/findUser/{id}")
public ResponseEntity<UserDTO> findById(@PathVariable String id){
    UserDTO userDTO = service.findByUserById(id);
    return new ResponseEntity<>(userDTO, HttpStatus.OK);
}


@PostMapping("/create")
public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
    UserDTO user = service.createUser(userDTO);
    return new ResponseEntity<>(userDTO,HttpStatus.CREATED);
}

@PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable String id,@RequestBody UserDTO userDTO){
    UserDTO user = service.update(id,userDTO);
    return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
}

@DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
    service.deleteUser(id);
    return ResponseEntity.noContent().build();
}

}
