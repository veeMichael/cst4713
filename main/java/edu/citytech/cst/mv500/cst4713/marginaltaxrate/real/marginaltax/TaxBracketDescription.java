package edu.citytech.cst.mv500.cst4713.marginaltaxrate.real.marginaltax;

public class TaxBracketDescription {

    private String bracket;
    private String calculateDescription;
    private float taxPaid = 0;

    public TaxBracketDescription(TaxRule taxRule, float income){

        float range2 = taxRule.getRange2() > income ? income : taxRule.getRange2();
        this.bracket = taxRule.getRate() + " Bracket:";
        this.calculateDescription = "(" + range2 + " - " + taxRule.getRange1() + ") x " + taxRule.getRate() + " ";
        this.taxPaid = (range2 - taxRule.getRange1()) * taxRule.getRate();
        this.calculateDescription = taxPaid < 0 ? "Not Applicable" : this.calculateDescription + " = " + taxPaid;

    }

    @Override
    public String toString() {
        return "TaxBracketDescription{" +
                "bracket='" + bracket + '\'' +
                ", calculateDescription='" + calculateDescription + '\'' +
                '}';
    }
}
