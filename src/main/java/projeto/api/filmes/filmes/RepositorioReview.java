package projeto.api.filmes.filmes;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioReview extends MongoRepository<Review, ObjectId> {



}
