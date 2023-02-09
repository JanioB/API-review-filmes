//A camada do Repositório é a camada de acesso de dados para a API. Essa camada conversa com a base de dados para recuperar os dados
package projeto.api.filmes.filmes;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //necessário para o Framework entender que isso é um repositório
public interface RepositorioFilmes extends MongoRepository<Filme, ObjectId> { //tipo genérico. É necessário especificar qual tipo de dados e o tipo de Id iremos usar (Movie e ObjectId)

    Optional<Filme> findFilmeByImdbId(String imdbId);

}
