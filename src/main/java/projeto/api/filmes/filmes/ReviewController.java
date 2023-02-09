package projeto.api.filmes.filmes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")

public class ReviewController {

    @Autowired
    private ServicoReview servicoReview;

    @PostMapping
    public ResponseEntity<Review> criarReview(@RequestBody Map <String, String> payload){ //aqui queremos dizer ao framework que não importa o que recebemos como body request, nós queremos converter para um mapa da key string e da value string
        //o formulário da review ficará dentro dos detalhes da página do filme que você estiver navegando. Então podemos lançar um request para o Filme e apontar, ao invés de criar um novo

        return new ResponseEntity<Review>(servicoReview.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);

    }
}
