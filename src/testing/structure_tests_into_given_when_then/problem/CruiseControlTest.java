/***
 * Excerpted from "Java By Comparison",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/javacomp for more book information.
***/
package testing.structure_tests_into_given_when_then.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testing.expected_before_actual_value.CruiseControl;
import testing.expected_before_actual_value.SpeedPreset;

class CruiseControlTest {

    @Test
    void setPlanetarySpeedIs7667() {
        // given
        CruiseControl cruiseControl = new CruiseControl();

        // when
        cruiseControl.setPreset(SpeedPreset.PLANETARY_SPEED);

        // then
        Assertions.assertTrue(7667 == cruiseControl.getTargetSpeedKmh());
    }
}
