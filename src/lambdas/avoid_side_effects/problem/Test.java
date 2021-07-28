/***
 * Excerpted from "Java By Comparison",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/javacomp for more book information.
***/
package lambdas.avoid_side_effects.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class Test {

}

interface Supply {

    String getName();

    boolean isUncontaminated();
}

class Inventory {

    List<Supply> supplies = new ArrayList<>();

    long countDifferentKinds() {
        List<String> names = new ArrayList<>();

        Consumer<String> addToNames = name -> names.add(name);

        // 8.4
        // 문제는 람다 표현식 밖에 있는 리스트 names에 name을 추가하도록 만드는 것.
        // 코드엔 문제 없다
        // 그렇지만 여러 스레드 간 부수효과 가 발생할 수 아닐 수도 있음
        // 왜냐면 ArrayList는 thread safe하지 않기 때문에

        supplies.stream()
                .filter(Supply::isUncontaminated)
                .map(Supply::getName)
                .distinct()
                .forEach(addToNames);
        return names.size();
    }
}
