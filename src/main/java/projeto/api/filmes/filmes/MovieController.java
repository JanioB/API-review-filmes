// esse é o primeiro controlador sendo escrito da API REST
//APIs REST tem várias camadas. Uma das camadas é a camada do controlador da API. O que esse controlador faz é usar uma service class (servicoFilmes) e delegar a tarefa de buscar todos os filmes (allFilmes) da base de dados e retornar para a camada da API. Então ele chama o método allFilmes dentro do ServicoFilmes, pega a lista do filme e os retorna com status HTTP OK
package projeto.api.filmes.filmes;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/filmes")
public class MovieController {
    @Autowired
    private ServicoFilmes servicoFilmes;

    @GetMapping //outro método GET
    public ResponseEntity<List<Filme>> getAllFilmes() { //retornando uma entidade de tipo lista Filme

        return new ResponseEntity<List<Filme>>(servicoFilmes.allFilmes(), HttpStatus.OK); //esse controle é apenas para mandar um request ao usuário e retornar uma resposta

    }
    //isso vai ser para acessar um (1) filme específico na base de dados

//    @GetMapping("/{id}")
//    //aqui, o objetivo é fazer o framework entender que qualquer coisa que conseguimos através dessa variavel de caminho, ela deve ser convertida para um ObjectId de nome id
//    public ResponseEntity<Optional<Filme>> getUnicoFilme(@PathVariable ObjectId id) { //PathVariable faz o framework entender que estamos passando a informação que conseguimos no Get Mapping como uma variável de caminho(Path) usaremos a informação que passa por esse caminho como um objeto
//
//        return new ResponseEntity<Optional<Filme>>(servicoFilmes.unicoFilme(id), HttpStatus.OK);
//
//    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Filme>> getUnicoFilme(@PathVariable String imdbId) {

        return new ResponseEntity<Optional<Filme>>(servicoFilmes.unicoFilme(imdbId), HttpStatus.OK);

    }
}
