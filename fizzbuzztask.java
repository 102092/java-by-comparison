/***
 * Excerpted from "Java By Comparison",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/javacomp for more book information.
***/
interface FizzBuzz {
    void print(int from, int to);
    boolean fizz(int number);
    boolean buzz(int number);
}


class ConsoleBasedFizzBuzz implements FizzBuzz {
    // TODO implement FizzBuzz interface
    private final String fizz = "Fizz";
    private final String buzz = "Buzz";

    @java.lang.Override
    public void print(int from, int to) {
        if (from < 1 || to > 100) {
            return;
        }

        for (int i = from; i < to ; i++) {
            if (fizz(i) && buzz(i)) {
                System.out.println(fizz + buzz);
            } else if(fizz(i)) {
                System.out.println(fizz);
            } else if(buzz(i)) {
                System.out.println(buzz);
            } else {
                System.out.println(i);
            }
        }
    }

    @java.lang.Override
    public boolean fizz(int number) {
        return number % 3 == 0;
    }

    @java.lang.Override
    public boolean buzz(int number) {
        return number % 5 == 0;
    }
}


class Main {
    // TODO use a main method
    // TODO print fizz buzz from 1 to max
    // TODO max is passed from the console
    public static void main(String[] args) {
        ConsoleBasedFizzBuzz consoleBasedFizzBuzz = new ConsoleBasedFizzBuzz();
        consoleBasedFizzBuzz.print(1, 100);
    }
}
