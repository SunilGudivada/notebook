package leetCode.problems.contest;

/**
 * The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers
 * 0 and 1 respectively. All students stand in a queue. Each student either prefers square or
 * circular sandwiches.
 *
 * <p>The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches
 * are placed in a stack. At each step:
 *
 * <p>If the student at the front of the queue prefers the sandwich on the top of the stack, they
 * will take it and leave the queue. Otherwise, they will leave it and go to the queue's end. This
 * continues until none of the queue students want to take the top sandwich and are thus unable to
 * eat.
 *
 * <p>You are given two integer arrays students and sandwiches where sandwiches[i] is the type of
 * the ith sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference
 * of the jth student in the initial queue (j = 0 is the front of the queue). Return the number of
 * students that are unable to eat.
 *
 * <p>Example 1:
 *
 * <p>Input: students = [1,1,0,0], sandwiches = [0,1,0,1] Output: 0 Explanation: - Front student
 * leaves the top sandwich and returns to the end of the line making students = [1,0,0,1]. - Front
 * student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1]. -
 * Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches
 * = [1,0,1]. - Front student leaves the top sandwich and returns to the end of the line making
 * students = [1,1,0]. - Front student takes the top sandwich and leaves the line making students =
 * [1,0] and sandwiches = [0,1]. - Front student leaves the top sandwich and returns to the end of
 * the line making students = [0,1]. - Front student takes the top sandwich and leaves the line
 * making students = [1] and sandwiches = [1]. - Front student takes the top sandwich and leaves the
 * line making students = [] and sandwiches = []. Hence all students are able to eat. Example 2:
 *
 * <p>Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1] Output: 3
 *
 * <p>Constraints:
 *
 * <p>1 <= students.length, sandwiches.length <= 100 students.length == sandwiches.length
 * sandwiches[i] is 0 or 1. students[i] is 0 or 1.
 */
public class _5621_NumberofStudentsUnabletoEatLunch {
  public int countStudents(int[] students, int[] sandwiches) {
    //    List<Integer> studList = new ArrayList<>();
    //    int res = 0;
    //    for (int i : students) {
    //      studList.add(i);
    //    }
    //
    //    List<Integer> sandList = new ArrayList<>();
    //    for (int i : sandwiches) {
    //      sandList.add(i);
    //    }
    //
    //    while (studList.size() > 0 && sandList.size() > 0 && res == 0) {
    //      if (studList.get(0).equals(sandList.get(0))) {
    //        studList.remove(0);
    //        sandList.remove(0);
    //      } else {
    //        int pref = studList.get(0);
    //        studList.remove(0);
    //        studList.add(pref);
    //        Stream<Integer> studStream = studList.stream().distinct();
    //        Stream<Integer> sandStream = sandList.stream().distinct();
    //        long studCount =  studStream.count();
    //        long sandCount =  sandStream.count();
    //        if (studCount != sandCount) {
    //          res = studList.size();
    //          break;
    //        }
    //      }
    //    }
    //    return res;
    int[] a = {0, 0};
    for (int i = 0; i < students.length; i++) a[students[i]] += 1;
    int k = 0;
    while (k < sandwiches.length) {
      if (a[sandwiches[k]] > 0) a[sandwiches[k]] -= 1;
      else break;
      k += 1;
    }
    return sandwiches.length - k;
  }

  public static void main(String[] args) {
    _5621_NumberofStudentsUnabletoEatLunch obj = new _5621_NumberofStudentsUnabletoEatLunch();
    int[] students = {0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1};
    int[] sandwiches = {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0};
    System.out.println(obj.countStudents(students, sandwiches));
  }
}
