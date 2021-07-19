/***
 * Excerpted from "Java By Comparison",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/javacomp for more book information.
***/
package general.simplify_boolean_expressions.problem;


import general.simplify_boolean_expressions.Crew;
import general.simplify_boolean_expressions.FuelTank;
import general.simplify_boolean_expressions.Hull;
import general.simplify_boolean_expressions.Navigator;
import general.simplify_boolean_expressions.OxygenTank;

class SpaceShip {

    Crew crew;
    FuelTank fuelTank;
    Hull hull;
    Navigator navigator;
    OxygenTank oxygenTank;

    // 1.4 불 표현식을 간소화하자
    // 코드행이 늘어나더라도, 가독성을 포기하지 말자

    boolean willCrewSurvive() {
        // 소모성 자원이 충분히 있는가?
        boolean hasEnoughResources = hasEnoughFuel() && hasEnoughOxygen();
        return hull.isIntact() && hasEnoughResources;
//        return hull.holes == 0 &&
//                fuelTank.fuel >= navigator.requiredFuelToEarth() &&
//                oxygenTank.lastsFor(crew.size) > navigator.timeToEarth();
    }

    private boolean hasEnoughOxygen() {
        return oxygenTank.lastsFor(crew.size) > navigator.timeToEarth();
    }

    private boolean hasEnoughFuel() {
        return fuelTank.fuel >= navigator.requiredFuelToEarth();
    }
}
