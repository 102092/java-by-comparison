/***
 * Excerpted from "Java By Comparison",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/javacomp for more book information.
***/
package general.favor_java_api_over_diy.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import general.Supply;

class Inventory {

    private List<Supply> supplies = new ArrayList<>();

    // 2.8 java api 사용하기
    int getQuantity(Supply supply) {
        Objects.requireNonNull(supply, "supply must not be null");

        return Collections.frequency(supplies, supply);

//        if (supply == null) {
//            throw new NullPointerException("supply must not be null");
//        }
//
//        int quantity = 0;
//        for (Supply supplyInStock : supplies) {
//            if (supply.equals(supplyInStock)) {
//                quantity++;
//            }
//        }
//
//        return quantity;

    }
}
