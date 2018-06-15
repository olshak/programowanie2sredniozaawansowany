package optional;

import collections.Collections;

import java.util.Optional;

public class OptionalExample {

    public static Optional<String> getWord(String a, String b) {
        if(b.contains(a)) {
            return Optional.of(a);
        } else {
            return Optional.empty();
        }
    }

    public static String getErrorCode() {
        System.out.println("Running getErroCode");
        return "nie ma wartosci";
    }

    public static void main(String[] args) {
        Optional<String> ala = getWord("ala", "ala ma kota");

        if (ala.isPresent()) {
            System.out.println(ala.get());
        } else{
            System.out.println("slowo nie zawiera sie w drugim");
        }

        System.out.println(ala.orElse(getErrorCode()));

        System.out.println(ala.orElseGet(OptionalExample::getErrorCode));
    }
}
