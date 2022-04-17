package movie.repository;

import movie.model.Movie;

import java.util.HashMap;

public class MovieRepoImpl implements MovieRepo {
    static HashMap<String, Movie> movies = new HashMap();
    public static HashMap getMovies(){
        movies.put("F001", new Movie("You've Got Mail", "regular"));
        movies.put("F002", new Movie("Matrix", "regular"));
        movies.put("F003", new Movie("Cars", "childrens"));
        movies.put("F004", new Movie("Fast & Furious X", "new"));
        return movies;
    }

    @Override
    public Movie findById(String id) {
        return (Movie) getMovies().get(id);
    }
}
