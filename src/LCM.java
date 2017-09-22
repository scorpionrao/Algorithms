import java.util.Scanner;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static long lcmFast(int a, int b) {
    long c = (long) a * b;
    return c / gcdFast(a, b);
  }

  private static int gcdFast(int a, int b) {

    if(b == 0) {
      return a;
    }

    int c = a % b;
    return gcdFast(b, c);
  }

  public static void main(String args[]) {
/*
    while(true) {
      int[] array = new int[2];
      for(int i = 0; i < array.length; i++) {
        int maxValue = 2000, minValue = 1;
        array[i] = new Random().nextInt((maxValue - minValue) + 1) + minValue;
      }

      if(array[0] < array[1]) {
        int temp = array[0];
        array[0] = array[1];
        array[1] = temp;
      }
      System.out.print("Input: ");
      for(int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
      }
      System.out.println();
      long bruteForceSolution = lcm_naive(array[0], array[1]);
      long optimizedSolution = lcmFast(array[0], array[1]);
      if(bruteForceSolution == optimizedSolution) {
        System.out.println("OK");
      } else {
        System.out.println("Wrong answer: " + bruteForceSolution + " " + optimizedSolution);
        break;
      }
    }
    */
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcmFast(a, b));
  }
}
