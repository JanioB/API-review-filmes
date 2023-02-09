package projeto.api.filmes.filmes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "filmes") //isso faz com que o framework saiba que essa classe apresenta cada documento na coleção de filmes (nesse caso, a coleção leva esse mesmo nome "filmes")
@Data //essa notação vem do projeto Lombrok. Ela cuida de todos os gators, setters e métodos do strings
@AllArgsConstructor //também outra facilidade criada pelo projeto Lombrok. É uma adição para criar um constructor que pega todos os campos private abaixo como um argumento
@NoArgsConstructor //outro constructor que não pega parâmetros
public class Filme {
    @Id //essa notação faz o framework saber que essa propriedade deve ser tratada como identificador único para cada filme dentro do BD
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres; //podem haver vários generos em um único filme
    private List<String> backdrops;

    @DocumentReference //isso faz com que o banco de dados só armazene os IDs das reviews e as reviews estarão numa coleção separada. Isso é chamado "Manual Reference Relationship" ou "Relacionamento de referência manual"
    private List<Review> reviewIds;
}
