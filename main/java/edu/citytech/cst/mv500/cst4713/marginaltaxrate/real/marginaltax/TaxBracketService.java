package edu.citytech.cst.mv500.cst4713.marginaltaxrate.real.marginaltax;

import com.taxservice.cst4713.Status;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaxBracketService {

    static private TaxRuleRepository repository = new TaxRuleRepository();

    public List<TaxBracketDescription> getTaxBracketDescription(int year, String status, float income){

        var list = repository.findAll(e -> e.getYear() == year && e.getCode().equals(status))
                .stream()
                .map( e -> new TaxBracketDescription(e,income))
                .toList();

        return list;
    }

    public static void main(String[] args) {
        new TaxBracketService().getTaxBracketDescription(2021, "S", 1_150_000)
                .forEach(System.out::println);

        System.out.println("Michael Vanunu " + new Date());
    }

}
