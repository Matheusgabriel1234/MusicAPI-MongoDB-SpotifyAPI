package matheus.projetos.Project.Music.API.with.SpotifyAPI.Users;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Document(collection = "User")
public class UserEntity{

    
    @Id
    private String id;
    private String username;
    private String email;
    private String password;



}
