package by.avorakh.common.benchmark.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class FibUtil {

    public long fibClassic(int n) {

        if (n < 2) {
            return n;
        }
        return fibClassic(n - 1) + fibClassic(n - 2);
    }

    public long tailRecFib(int n) {

        return tailRecFib(n, 0, 1);
    }

    private int tailRecFib(int n, int a, int b) {

        if (n == 0) {
            return a;
        }
        if (n == 1) {
            return b;
        }
        return tailRecFib(n - 1, b, a + b);
    }
}

