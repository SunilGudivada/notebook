package com.platform.practiseJava;

import java.util.*;
import java.util.stream.Stream;

public class java8 {

  public static void parallelVsSequential() {
    long startNanoSec = 0;
    long endNanoSec = 0;
    int maxElements = 9992999;

    List<Integer> numberAr = new ArrayList<>();
    for (int i = 0; i < maxElements; i++) {
      numberAr.add(i);
    }

    System.out.println("Number of elements to be counted using streams: " + maxElements);

    startNanoSec = System.nanoTime();
    Stream<Integer> sequentialStream = numberAr.stream();
    System.out.println(
        "Number of elements counted using sequential streams: " + sequentialStream.count());
    endNanoSec = System.nanoTime();

    System.out.println(
        "Time taken to count elements using sequential streams: "
            + (endNanoSec - startNanoSec)
            + " nanoSeconds");

    // parallel stream

    startNanoSec = System.nanoTime();
    Stream<Integer> parallelStream = numberAr.parallelStream();
    System.out.println(
        "Number of elements counted using parallel streams: " + parallelStream.count());
    endNanoSec = System.nanoTime();

    System.out.println(
        "Time taken to count elements using parallel streams: "
            + (endNanoSec - startNanoSec)
            + " nanoSeconds");
  }

  public static void workingWithStreams() {
    List<Student> students = new ArrayList<>();
    Student stud1 = new Student(1, "Sunil Gudivada", 25);
    Student stud2 = new Student(2, "Abhiram Chebrolu", 24);
    Student stud3 = new Student(3, "Saketh Attaluri", 25);
    Student stud4 = new Student(4, "Krishna Chaitanya", 23);
    Student stud5 = new Student(5, "Eshwar Prithvi", 22);
    Student stud6 = new Student(6, "Ravi Teja", 23);
    Student stud7 = new Student(7, "Ranga Praneeth", 24);

    students.add(stud1);
    students.add(stud2);
    students.add(stud2);
    students.add(stud2);
    students.add(stud3);
    students.add(stud4);
    students.add(stud5);
    students.add(stud6);
    students.add(stud7);

    System.out.println("*********************");
    System.out.println("Working with streams");
    System.out.println("*********************");
    System.out.println("Distinct Count of students using .distinct()");
    System.out.println("Total Students in the list: " + (long) students.size());
    System.out.println("Distinct Students in the list: " + students.stream().distinct().count());

    System.out.println();

    System.out.println("Names Sorting using .sorted()");

    students.stream()
        .distinct()
        .sorted((p1, p2) -> (p1.name).compareTo(p2.name))
        .forEach(s -> System.out.println(s.name));

    System.out.println("\n .anyMatch() contains Sunil");
    System.out.println(
        students.stream().distinct().anyMatch(student -> student.getName().contains("Sunil")));

    System.out.println("\n .allMatch() contains Sunil");
    System.out.println(
        students.stream().distinct().allMatch(student -> student.getName().contains("Sunil")));

    System.out.println("\n .dropWhile() age > 25");
    students.stream()
        .distinct()
        .sorted(Comparator.comparing(p -> (p.age)))
        .dropWhile(student -> student.getAge() >23)
        .forEach(student -> System.out.println(student.name));

    System.out.println(" \n Generate Random Number using streams");
    Stream.generate(() -> new Random().nextInt(100))
        .limit(20)
        .sorted(Integer::compareTo)
        .forEach(num -> System.out.print(num + " "));
  }


  public static void main(String[] args) {
    //      parallelVsSequential();
    workingWithStreams();
  }
}
