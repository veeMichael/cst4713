package edu.citytech.cst.mv500.cst4713;

import edu.citytech.cst.helper.utility.ReadExcelUtility;
import org.apache.poi.ss.usermodel.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T2_ReadSpreadSheet {

    @Test
    @DisplayName("Row count")
    void t1(){

        List<String> rows = ReadExcelUtility
                .processFromResource("static/SimpleTaxRate.xlsx", "data",0, e -> "");
        var actual = rows.size();
        var expected = 401;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Row count / Display Data")
    void t2(){
        Function<Row, String> function = row -> {
            var id = row.getCell(0).getStringCellValue();
            var state = row.getCell(1).getStringCellValue();
            var salary = row.getCell(3).getNumericCellValue();
            var currentRow = (id + " " + state + " " + salary);
            return currentRow;
        };

        List<String> rows = ReadExcelUtility
                .processFromResource("static/SimpleTaxRate.xlsx", "data",395, function);
        var actual = rows.size();
        var expected = 6;
        System.out.println("Michael, Vanunu " + new Date());
        rows.forEach(System.out::println);

        assertEquals(expected, actual);
    }

}
