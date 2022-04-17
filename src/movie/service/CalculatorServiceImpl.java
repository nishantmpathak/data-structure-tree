package movie.service;


import movie.model.Customer;
import movie.model.Movie;
import movie.model.MovieCategory;
import movie.model.MovieRental;
import movie.repository.MovieRepoImpl;

import static movie.constants.APIConstants.*;

public class CalculatorServiceImpl implements CalculatorService {

    public MovieRepoImpl movieRepo = new MovieRepoImpl();


    @Override
    public String calculateRent(Customer customer){
        double finalAmount = 0;
        int frequentEnterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + customer.getName() + "\n");
        for(var rental: customer.getRentals()){
            finalAmount = finalAmount + singleMovieAmount(rental, result);
        }
        frequentEnterPoints = customer.getRentals().size();
        //Builder patter is possible
        result.append("Amount owed is " + finalAmount + "\n");
        result.append("You earned " + frequentEnterPoints + " frequent points\n");
        return result.toString();
    }

    private double singleMovieAmount(MovieRental rental, StringBuilder result) {
        double amount = 0;
        Movie movie = movieRepo.findById(rental.getMovieId());
        // determine amount for each movie
        // We can Implement factory patter if this calculation is more complex

        switch (movie.getCode()){
            case REGULAR : {
                amount = 2;
                if (rental.getDays() > 2) {
                    amount = ((rental.getDays() - 2) * 1.5) + amount;
                }
                break;
            }
            case NEW : {
                amount = rental.getDays() * 3;
                break;
            }
            case CHILDREN : {
                amount = 1.5;
                if (rental.getDays() > 3) {
                    amount = ((rental.getDays() - 3) * 1.5) + amount;
                }
                break;
            }
        }
        result.append("\t" + movie.getTitle() + "\t" + amount + "\n");
        return amount;
    }

}
