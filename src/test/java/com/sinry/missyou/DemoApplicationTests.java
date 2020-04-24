package com.sinry.missyou;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;



    @Test
    public void test01() {
        int[] scores = {89 , -23 , 64 , 91 , 119 , 52 , 73};
        Arrays.stream(scores).boxed().sorted(Comparator.reverseOrder()).filter(f -> f <= 100 && f >= 0).limit(3).forEach(System.out::println);
    }

    @Test
    public void testSplitToLong () {
        List<Long> splitValue = new ArrayList<>();
        long value = 8;
        long j = 1L;

        do {
            if ((value & j) == j) {
                splitValue.add(j);
            }

            j <<= 1;
            System.out.println(j);
        } while (j <= value);
        System.out.println(splitValue.toString());
    }

}
