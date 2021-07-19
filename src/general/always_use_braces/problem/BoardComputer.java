/***
 * Excerpted from "Java By Comparison",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/javacomp for more book information.
***/
package general.always_use_braces.problem;

import java.util.Objects;

import general.CruiseControl;
import general.User;

class BoardComputer {

    CruiseControl cruiseControl;

    // 1.8 코드 대칭 이루기
    void authorize(User user) {
        Objects.requireNonNull(user);
        if (user.isUnknown()) {
            cruiseControl.logUnauthorizedAccessAttempt();
            return;
        }

        if (user.isAstronaut()) {
            cruiseControl.grantAccess(user);
        }
        else if (user.isCommander()) {
            cruiseControl.grantAccess(user);
            cruiseControl.grantAdminAccess(user);
        }
    }

    // 1.7 항상 괄호 사용하기
//    void authorize(User user) {
//        Objects.requireNonNull(user);
//        if (user.isUnknown()) {
//            cruiseControl.logUnauthorizedAccessAttempt();
//        }
//        if (user.isAstronaut()) {
//            cruiseControl.grantAccess(user);
//        }
//        if (user.isCommander()) {
//            cruiseControl.grantAccess(user);
//            cruiseControl.grantAdminAccess(user);
//        }
//    }
}
