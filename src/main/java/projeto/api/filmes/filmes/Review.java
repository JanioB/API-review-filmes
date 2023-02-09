package projeto.api.filmes.filmes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews") //apesar de não termos criado essa coleção ainda, a própria aplicação tem a habilidade de criar novas coleções
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Review {
    @Id
    private ObjectId id;
    private String body;

    public Review(String body) { //como os ids são gerados automaticamente não podemos passar um id nessa public class @id. Então é necessario criar um constructor customizado que pega somente o body
        this.body = body;

    }
}
