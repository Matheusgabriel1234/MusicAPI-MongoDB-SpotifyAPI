package matheus.projetos.Project.Music.API.with.SpotifyAPI.Users;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

@Autowired
private UserRepository userRepository;



public UserDTO createUser(UserDTO userDTO){
    UserEntity user = convertToEntity(userDTO);
   UserEntity savedUser = userRepository.save(user);
   return  convertToDto(savedUser);
}


public UserDTO findByUserById(String id){
    return userRepository.findById(id).map(this::convertToDto).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
}

public UserDTO update(String id, UserDTO user){
   UserEntity existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não existe"));
   convertToDto(existingUser);
   existingUser.setUsername(user.getUsername());
   existingUser.setEmail(user.getEmail());
   UserEntity savedUser = userRepository.save(existingUser);
   return convertToDto(savedUser);
}

public void deleteUser(String id){
    userRepository.deleteById(id);
}


private UserDTO convertToDto(UserEntity user){
    UserDTO userDTO = new UserDTO();
    userDTO.setEmail(user.getEmail());
    userDTO.setUsername(user.getUsername());
    userDTO.setPassword(user.getPassword());
    return userDTO;
}

private UserEntity convertToEntity(UserDTO userDTO){
    UserEntity userEntity = new UserEntity();
    userEntity.setUsername(userDTO.getUsername());
    userEntity.setEmail(userDTO.getEmail());
    userEntity.setPassword(userDTO.getPassword());
    return userEntity;
}
}
