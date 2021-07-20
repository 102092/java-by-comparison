/***
 * Excerpted from "Java By Comparison",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/javacomp for more book information.
***/
package general.avoid_collection_modification_during_iteration.problem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import general.Supply;

class Inventory {

    private List<Supply> supplies = new ArrayList<>();

    // 2.4 순회하면서 컬렉션을 수정하지 말도록..
    //
//    void disposeContaminatedSupplies() {
//        for (Supply supply : supplies) {
//            if (supply.isContaminated()) {
//                supplies.remove(supply);
//            }
//        }
//    }


    void disposeContaminatedSupplies() {
        Iterator<Supply> iterator = supplies.listIterator();

        while (iterator.hasNext()) {
            if (iterator.next().isContaminated()) {
                iterator.remove();
            }
        }
        // stream..?
        supplies.removeIf(Supply::isContaminated);
    }
}
