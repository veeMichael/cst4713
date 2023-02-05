package edu.citytech.cst.mv500.cst4713.counter;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

@Service
public class CounterService {

    Function<Integer, Counter> fAbc = e -> new Counter((char)e.intValue() + "", e);
    Function<Integer, Counter> f123 = e -> new Counter(e + "", e);
    Function<Counter, Counter> fEven = e -> {
        String evenStatus = e.getValue().intValue() % 2 == 0 ? "isEven" : "";
        e.setClassName("numbers " + evenStatus);
        return e;
    };

    public List<Counter> count(CounterEnumerator eCounter, int... range){

        int defaultRange [] = {65,90,1};

        Function<Integer, Counter> func =f123;
        Predicate<Integer> filter = e -> true;

        if(eCounter == CounterEnumerator.ABC || eCounter == CounterEnumerator.CBA){
            func=fAbc;
        }
        else {
            if (range.length > 1) {
                defaultRange[0] = range[0];
                defaultRange[1] = range[1];
                filter = e -> e <= defaultRange[1];
            }
            if (range.length > 2) {
                defaultRange[2] = range[2];
            }
        }
        var list = IntStream.rangeClosed(defaultRange[0],defaultRange[1])
                .mapToObj(e -> e*defaultRange[2])
                .filter(filter)
                .map(func)
                .map(fEven)
                .toList();

        if(eCounter == CounterEnumerator.N321 || eCounter == CounterEnumerator.CBA){

            List<Counter> modifiableList = new ArrayList<Counter>(list);
            Collections.reverse(modifiableList);

            return modifiableList;
        }

        return list;
    }

    public static void main(String[] args) {

        System.out.println("Vanunu, Michael" + new Date());

        CounterService s = new CounterService();
        s.count(CounterEnumerator.N321, 1,20,3)
                .forEach(System.out::println);


    }

}
