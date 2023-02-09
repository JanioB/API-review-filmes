//lembrando: um repositório é uma das formas que se comunicar com a base de dados!
//um outro modo de fazer isso é usando um Template (private MongoTemplate mongoTemplate) podemos usar esse Template para formar uma nova Query dinâmica e fazer o que é necessário dentro do banco de dados sem usar um repositório
package projeto.api.filmes.filmes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.aggregation.SelectionOperators.First.first;

@Service
public class ServicoReview {

    @Autowired
    private RepositorioReview repositorioReview; //referencia para o repositorio review

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){  //esse método criará uma nova review e terá dois parâmetros String reviewBody e imdbId. Ele criará um novo review e associará com o filme o qual nós pesquisamos pelo id

        Review review = repositorioReview.insert(new Review(reviewBody)); //aqui salvamos a review no insert, porque quando chamamos insert, ele retorna o dado que empurramos dentro da base de dados

        mongoTemplate.update(Filme.class) //aqui estou usando o Template para performar e atualizar a classe Filme porque cada filme contém um array vazio de reviews, então precisamos atualizar esse Array e empurrar um novo ReviewId nele

                .matching(Criteria.where("imdbId").is(imdbId)) //matching: aqui é o equivalente a: qual filme você está atualizando? Estou atualizando um filme onde o imdbId do filme na base de dados é igual (matches) ao imdbId que recebemos do usuário
                .apply(new Update().push("reviews").value(review)); //apply: nessa etapa nós aplicamos essa atualização. É criado um novo update de definição que é responsável por fazer a mudança dentro do banco de dados (Update.push)(ReviewIds) então estamos pedindo para atualizarmos o id das reviews de dado filme e o valor dado para esse filme será review, então esse valor(review) que acabamos de criar será colocado dentro do Array de Review Ids
                first();

        return review;
    }

}
