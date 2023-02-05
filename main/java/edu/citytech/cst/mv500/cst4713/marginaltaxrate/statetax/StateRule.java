package edu.citytech.cst.mv500.cst4713.marginaltaxrate.statetax;
import static edu.citytech.cst.mv500.cst4713.utility.FormatDataUtilityV2.format;

import org.apache.poi.ss.usermodel.Row;


public class StateRule {

    private String state;
    private float stateTaxRate;
    private int rank;
    private float avgLocalTaxRate;
    private float combinedRate;
    private int rank2;
    private float maxLocalTaxRate;
    private String formattedSTR;
    private String formattedALTR;
    private String formattedCR;
    private String formattedMLTR;

    public StateRule(Row row){
        this.state = row.getCell(0).getStringCellValue();
        this.stateTaxRate = (float)row.getCell(1).getNumericCellValue();
        this.rank = (int)row.getCell(2).getNumericCellValue();
        this.avgLocalTaxRate = (float)row.getCell(3).getNumericCellValue();
        this.combinedRate = (float)row.getCell(4).getNumericCellValue();
        this.rank2 = (int)row.getCell(5).getNumericCellValue();
        this.maxLocalTaxRate = (float)row.getCell(6).getNumericCellValue();
        this.formattedSTR = format(stateTaxRate * 100f);
        this.formattedALTR = format(avgLocalTaxRate * 100f);
        this.formattedCR = format(combinedRate * 100f);
        this.formattedMLTR = format(maxLocalTaxRate * 100f);



    }

    public String getFormattedALTR() {
        return formattedALTR;
    }

    public String getFormattedCR() {
        return formattedCR;
    }

    public String getFormattedMLTR() {
        return formattedMLTR;
    }

    public String getFormattedSTR() {
        return formattedSTR;
    }

    public String getState() {
        return state;
    }

    public float getStateTaxRate() {
        return stateTaxRate;
    }

    public int getRank() {
        return rank;
    }

    public float getAvgLocalTaxRate() {
        return avgLocalTaxRate;
    }

    public float getCombinedRate() {
        return combinedRate;
    }

    public int getRank2() {
        return rank2;
    }

    public float getMaxLocalTaxRate() {
        return maxLocalTaxRate;
    }

    @Override
    public String toString() {
        return "StateRule{" +
                "state='" + state + '\'' +
                ", stateTaxRate=" + stateTaxRate +
                ", rank=" + rank +
                ", avgLocalTaxRate=" + avgLocalTaxRate +
                ", combinedRate=" + combinedRate +
                ", rank2=" + rank2 +
                ", maxLocalTaxRate=" + maxLocalTaxRate +
                '}';
    }
}
