package edu.citytech.cst.mv500.cst4713.marginaltaxrate.employee;

public class EmployeeInput {

    private String code = "ALL" ;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "EmployeeInput{" +
                "code='" + code + '\'' +
                '}';
    }
}
