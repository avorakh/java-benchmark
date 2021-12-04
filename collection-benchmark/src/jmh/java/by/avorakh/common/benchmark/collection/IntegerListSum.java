package by.avorakh.common.benchmark.collection;

import org.jetbrains.annotations.NotNull;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3, batchSize = 5)
@Measurement(iterations = 10, batchSize = 10)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
public class IntegerListSum {

    private List<Integer> integerList;

    @Param({"100000", "500000", "2000000"})
    private int N;
    @Param({"ArrayList", "LinkedList"})
    private String implementationName;

    @Setup()
    public void setup() {

        this.integerList = selectImplementation(implementationName, N);
        fill(integerList, N);
    }

    @TearDown
    public void cleanUp() {

        integerList.clear();
    }

    @Benchmark
    public void sum(@NotNull Blackhole bh) {

        bh.consume(integerList.stream().mapToLong(i -> i).sum());
    }

    @Benchmark
    public void sumParallel(@NotNull Blackhole bh) {

        bh.consume(integerList.parallelStream().mapToLong(i -> i).sum());
    }

    private @NotNull List<Integer> selectImplementation(@NotNull String name, int n) {

        return switch (name) {
            case "ArrayList" -> new ArrayList<>(n);
            case "LinkedList" -> new LinkedList<>();
            default -> throw new IllegalArgumentException(
                "Illegal implementation name: " + implementationName
            );
        };
    }

    private void fill(@NotNull List<Integer> list, int n) {

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
    }
}
