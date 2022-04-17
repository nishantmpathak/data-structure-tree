package test;

import java.util.function.Predicate;

public class Test {

    public static void main(String[] args) {
        Predicate<String> nullCheck = s->s==null;

        String name = null;
        System.out.println(nullCheck.test(name));
    }
}
