package projeto.api.filmes.filmes;

import org.springframework.boot.SpringApplication; //essa classe possui um método .run e para rodar a aplicação Spring é necessario chamar esse método e passar a classe da aplicação (public class FilmesApplication {}). Então é possível passar outros comandos (args)
import org.springframework.boot.autoconfigure.SpringBootApplication; //importa a notação da aplicação SpringBoot. Em Java, anotações servem para o compilador saber sobre o que cada classe faz
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController  #outra notação que faz o framework saber que essa classe é uma REST API CONTROLLER e não outra classe
public class FilmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmesApplication.class, args);
	}

//	@GetMapping ("/") #essa notação faz o framework saber que esste método (apiRoot) é um endpoint Get. Ou seja, o se eu adicionar ("/root") logo após o GetMapping, o retorno "Olá mundo" só aparecerá em http://localhost:8080/root
//	public String apiRoot(){ #essa é a raiz da API
//	return "Olá, Mundo!";
//	}
}
