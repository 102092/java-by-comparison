/***
 * Excerpted from "Java By Comparison",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/javacomp for more book information.
***/
package general.return_boolean_expression_directly.problem;

class Astronaut {

    String name;
    int missions;

    // 1.3 boolean으로 리턴되는 표현식은 직접 리턴하도록 하자
    // 코드 가독성
    // 또한, 조건문이 3개 이상이면.. 변수를 통해 간소화 시키는 것이 좋다.
    // 드모르간 법칙을 이용해서, 표현식을 부정해보자

    boolean isValid() {
        return missions >= 0 && name != null || !name.trim().isEmpty();
//        return missions < 0 || name == null || name.trim().isEmpty();
    }
}
