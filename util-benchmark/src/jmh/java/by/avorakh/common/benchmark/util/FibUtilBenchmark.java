package by.avorakh.common.benchmark.util;

import org.jetbrains.annotations.NotNull;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 10)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
public class FibUtilBenchmark {

    @Param({"5", "10", "15", "30"})
    private int n;

    @Benchmark
    public void fibClassic(@NotNull Blackhole bh) {

        bh.consume(FibUtil.fibClassic(n));
    }

    @Benchmark
    public void fibTailRec(@NotNull Blackhole bh) {

        bh.consume(FibUtil.tailRecFib(n));
    }
}

