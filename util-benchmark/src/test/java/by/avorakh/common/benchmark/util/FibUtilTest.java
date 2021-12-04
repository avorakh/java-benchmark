package by.avorakh.common.benchmark.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibUtilTest {

    @Test
    public void testFib() {

        assertEquals(144, FibUtil.fibClassic(12));
        assertEquals(144, FibUtil.tailRecFib(12));
    }
}