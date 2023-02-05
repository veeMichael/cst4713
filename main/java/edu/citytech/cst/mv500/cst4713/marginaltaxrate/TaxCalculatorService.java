package edu.citytech.cst.mv500.cst4713.marginaltaxrate;

import com.taxservice.cst4713.ITaxCalculator;
import com.taxservice.cst4713.Status;
import edu.citytech.cst.mv500.cst4713.marginaltaxrate.real.marginaltax.TaxRule;
import edu.citytech.cst.mv500.cst4713.marginaltaxrate.real.marginaltax.TaxRuleRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaxCalculatorService implements ITaxCalculator {

    //static = only shown once (one version) in memory and only runs once
    static Map<String, Status> map = new HashMap();
    static Map<Status, String> map2 = new HashMap();
    static {
        map.put("S", Status.S);
        map.put("HH", Status.HH);
        map.put("MFJ", Status.MFJ);

        map2.put(Status.S,"S");
        map2.put(Status.HH, "HH");
        map2.put(Status.MFJ, "MFJ");
    }

    public static Status getStatus(String sStatus){

        Status eStatus = map.get(sStatus);
        return eStatus;
    }

    public static String getStatus(Status eStatus){

        var sStatus = map2.get(eStatus);
        return sStatus;
    }

    List<TaxRule> taxRules = new TaxRuleRepository().findAll( e -> true);

    @Override
    public float getTaxPaid(int taxYear, Status status, float grossPay) {

        String sStatus = getStatus(status);
        var taxPaid =
       taxRules.stream().filter(e -> e.getCode().equals(sStatus) && e.getYear() == taxYear && e.getRange1() < grossPay && e.getRange2()>= grossPay).
                map(TaxRule::getRate)
               .findFirst().get() * grossPay;

        return taxPaid;
    }

    @Override
    public float getTaxPaid(Status status, float grossPay) {

        float taxPaid = getTaxPaid(2020, status, grossPay);


        return taxPaid;
    }

}
