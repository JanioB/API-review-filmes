//o que essa classe de serviço faz, é usar a classe do repositório e se comunicar com a base de dados e pega a lista dos filmes e retorna para a camada da API
package projeto.api.filmes.filmes;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoFilmes { //dentro dessa classe vem os métodos de acesso ao banco de dados
    @Autowired //ao invés de um constructor é possível usar Autowired. Isso faz com que o framework entenda que nós queremos que o framework inicie a classe RepositorioFilmes
    private RepositorioFilmes repositorioFilmes;
    public List<Filme> allFilmes(){  //irá retornar uma lista de filmes desse método
        return repositorioFilmes.findAll();


    }

//    public Optional<Filme> unicoFilme(ObjectId id){
//        return repositorioFilmes.findById(id);  //talvez o método findById não encontre nenhum filme, pois o id de input pode não existir, por isso adicionamos o Optional, para retornar como Nulo.
//    }
    public Optional<Filme> unicoFilme(String imdbId){
        return repositorioFilmes.findFilmeByImdbId(imdbId);
    }
}
