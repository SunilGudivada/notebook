package practiseJava;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class countWordsInString {

  public static void main(String[] args) {
    String str = "This is the book. This book is new";

    String[] strArray = str.split(" ");

    Stream<String> streamObj = Arrays.stream(strArray);

    Map<String, Long> wordMap =
        streamObj.collect(Collectors.groupingBy(s -> s, Collectors.counting()));

    wordMap.forEach((k, v) -> System.out.println(k + " " + v));
  }
}
