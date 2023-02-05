package edu.citytech.cst.mv500.cst4713.utility;

import java.text.DecimalFormat;

public class FormatDataUtility {

    public static String format(double inputNumber){
        DecimalFormat formatter = new DecimalFormat("#,###,###,##0.00");
        return formatter.format(inputNumber);
    }
}