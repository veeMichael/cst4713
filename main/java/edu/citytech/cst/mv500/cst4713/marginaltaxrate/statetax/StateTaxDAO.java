package edu.citytech.cst.mv500.cst4713.marginaltaxrate.statetax;


import edu.citytech.cst.helper.dao.IQuery;
import edu.citytech.cst.helper.utility.ReadExcelUtility;


import java.util.List;
import java.util.function.Predicate;

// in charge of retrieving data from the Excel / repository
public class StateTaxDAO implements IQuery<StateRule> {
    private List<StateRule> list;

    public StateTaxDAO(){
        list = ReadExcelUtility
                .processFromResource("static/stateTax.xlsx", "Sheet1",1,
                        StateRule::new);
    }

    @Override
    public StateRule findById(Predicate<StateRule> predicate) {

        var currentList = this.list.stream().filter(predicate).toList();

        return (StateRule) currentList;
    }

    @Override
    public List<StateRule> findAll(Predicate<StateRule> predicate) {

        return this.list;
    }

    public static void main(String[] args) {
        new StateTaxDAO().findAll(e ->true).forEach(System.out::println);
    }

}


