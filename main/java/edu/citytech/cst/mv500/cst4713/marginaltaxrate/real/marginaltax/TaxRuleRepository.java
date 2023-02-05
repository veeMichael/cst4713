package edu.citytech.cst.mv500.cst4713.marginaltaxrate.real.marginaltax;

import edu.citytech.cst.helper.dao.IQuery;
import edu.citytech.cst.helper.utility.ReadExcelUtility;

import java.util.List;
import java.util.function.Predicate;

public class TaxRuleRepository implements IQuery<TaxRule> {

    private List<TaxRule> list;

    public TaxRuleRepository(){
        list = ReadExcelUtility
                .processFromResource("static/SimpleTaxRate.xlsx", "rulesForCode",1,
                        TaxRule::new);
    }

    @Override
    public TaxRule findById(Predicate<TaxRule> predicate) {
        return null;
    }

    @Override
    public List<TaxRule> findAll(Predicate<TaxRule> predicate) {

        var currentList = this.list.stream().filter(predicate).toList();

        return currentList;
    }

    public static void main(String[] args) {
        new TaxRuleRepository().findAll(e ->true).forEach(System.out::println);
    }

}
