/***
 * Excerpted from "Java By Comparison",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/javacomp for more book information.
***/
package general.avoid_switch_fall_through.problem;

import java.util.Objects;

import general.CruiseControl;
import general.Rank;
import general.User;

class BoardComputer {

    CruiseControl cruiseControl;


    // 1.6 switch 문에서 실패하는 경우를 피하지

    void authorize(User user) {
        // null일 경우, 아래 에러 발생
        Objects.requireNonNull(user);
        switch (user.getRank()) {
            case UNKNOWN:
                cruiseControl.logUnauthorizedAccessAttempt();
                break;
            case ASTRONAUT:
                cruiseControl.grantAccess(user);
                break;
            case COMMANDER:
                cruiseControl.grantAccess(user);
                cruiseControl.grantAdminAccess(user);
                break;
        }
    }
}
