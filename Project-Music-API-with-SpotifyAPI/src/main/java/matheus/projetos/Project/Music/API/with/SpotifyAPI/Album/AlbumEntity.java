package matheus.projetos.Project.Music.API.with.SpotifyAPI.Album;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Albums")
public class AlbumEntity {

    @Id
private String id;
    private String name;
private String albumType;
private Integer totalTracks;
private String releaseDate;
private String imgUrl;
private String artistId;



}
