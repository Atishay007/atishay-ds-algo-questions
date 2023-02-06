package com.misc;

import java.util.Optional;

public class OptionalUsage {
    public static void main(String[] args) {
        Integer sum = null;
        //If the value can be nullable then we have to use Optional.ofNullable(value)
        //Otherwise the below code will throw NullPointer question.
        Optional<Integer> value = Optional.of(null);
        Optional<Integer> value1 = Optional.ofNullable(null);
        value.ifPresent(a -> System.out.println(a));
        value1.ifPresent(a -> System.out.println(a));
    }
}
