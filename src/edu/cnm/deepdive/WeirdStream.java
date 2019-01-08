package edu.cnm.deepdive;

import java.security.SecureRandom;
import java.util.Comparator;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class WeirdStream {

  public static void main(String[] args) {
    Random rng = new Random(-1); // Reproducible sequence.
    IntStream.generate(rng::nextInt)
        .limit(1000)
        .boxed()
        .sorted(Comparator.comparingInt(Integer::bitCount)
            .thenComparing(Comparator.naturalOrder()))
        .forEach(v ->
            System.out.printf("%32s, %2d, %,13d%n", Integer.toBinaryString(v), Integer.bitCount(v), v));
  }

}

