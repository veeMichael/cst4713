package edu.citytech.cst.mv500.cst4713.marginaltaxrate.statetax;

import edu.citytech.cst.mv500.cst4713.counter.Counter;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

// handles the logic for highlighting the numbers
@Service
public class StateTaxService {

    static private StateTaxDAO repository = new StateTaxDAO();


    private static Predicate<StateRule> allStates = e -> true;


    public List<StateRule> getAllStates(){
        return repository.findAll(allStates);
    }


    public static void main(String[] args) {
        new StateTaxService().getAllStates()
                .forEach(System.out::println);

    }
}