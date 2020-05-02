package awstest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task2Test {

  @Test
  public void testA1() {
    Solution solution = new Solution();

    int result = solution.solution(new int[]{1, 3, 6, 4, 1, 2});

    assertEquals(5, result);
  }

}
