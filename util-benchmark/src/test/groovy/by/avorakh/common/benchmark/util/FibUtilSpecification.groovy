package by.avorakh.common.benchmark.util

import spock.lang.Specification

class FibUtilSpecification extends Specification {

    def "should successfully get #expected by fibClassic where #n"(int n, int expected) {

        expect:
            FibUtil.fibClassic(n) == expected
        where:
            n  | expected
            0  | 0
            1  | 1
            2  | 1
            3  | 2
            4  | 3
            5  | 5
            6  | 8
            7  | 13
            8  | 21
            9  | 34
            10 | 55
            11 | 89
            12 | 144
            13 | 233
            14 | 377
    }

    def "should successfully get #expected by tailRecFib where #n"(int n, int expected) {

        expect:
            FibUtil.tailRecFib(n) == expected
        where:
            n  | expected
            0  | 0
            1  | 1
            2  | 1
            3  | 2
            4  | 3
            5  | 5
            6  | 8
            7  | 13
            8  | 21
            9  | 34
            10 | 55
            11 | 89
            12 | 144
            13 | 233
            14 | 377
    }
}
