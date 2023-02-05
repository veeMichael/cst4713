package edu.citytech.cst.mv500.cst4713;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.DoublePredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T2_Predicate {

    //look up openjdk

    public static boolean booboo(long x){
        return true;
    }

    public static boolean honorStudents(double score){
        boolean status = score >=93;
        return status;
    }
    @Test
    void testWithCsvSource() {

        //predicate that takes one parameter and only takes a boolean
        Predicate<Long> moneyPredicate = T2_Predicate::booboo;
        DoublePredicate gpaPredicate = T2_Predicate::honorStudents;
        DoublePredicate failing = x -> x<59;

        double[] grades = {94f, 100f, 55f,30f, 75f};
        Arrays.stream(grades).filter(gpaPredicate)
                .forEach(System.out::println); //stream = advanced array

        Arrays.stream(grades).filter(failing)
                .forEach(System.out::println);


        String data [] = {"a","b","c","d","e","f"};

        // e -> = lambda expression

        Predicate<String> vowels = e -> e.equals("a") || e.equals("e");

        Arrays.stream(data).filter(vowels)
                .forEach(System.out::println);


        Function<Float, Float> r1 = e -> e*10f;
        UnaryOperator<Float> raise = e -> e *10f;

        var v1 = r1.apply(100_000f);
        var v2 = raise.apply(100_000f);

        System.out.println(v1 + " " + v2);


        //assertEquals(expected,actual);

        //predicate , consumer , functions - important

    }
}