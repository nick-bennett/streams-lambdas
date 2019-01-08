package edu.cnm.deepdive;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;

public class WeirdStream {

  public static void main(String[] args) {
    Random rng = new Random(-1); // Reproducible sequence.
    IntStream.generate(rng::nextInt)
        .limit(1000)
        .boxed()
        .sorted(Comparator.comparingInt(Integer::bitCount)
            .thenComparing(Comparator.naturalOrder()))
        .map(v -> {
          String base2 = Integer.toBinaryString(v);
          StringBuilder builder = new StringBuilder();
          builder.append(String.format("%,14d (%2d): ", v, Integer.bitCount(v)));
          builder.append("0".repeat(32 - base2.length()));
          builder.append(base2);
          return builder.toString();
        })
        .forEach(System.out::println);
  }

}

