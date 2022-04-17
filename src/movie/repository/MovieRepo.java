package movie.repository;

import movie.model.Movie;

public interface MovieRepo {
    Movie findById(String id);
}
