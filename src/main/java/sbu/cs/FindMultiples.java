package sbu.cs;

/*
    In this exercise, you must write a multithreaded program that finds all
    integers in the range [1, n] that are divisible by 3, 5, or 7. Return the
    sum of all unique integers as your answer.
    Note that an integer such as 15 (which is a multiple of 3 and 5) is only
    counted once.

    The Positive integer n > 0 is given to you as input. Create as many threads as
    you need to solve the problem. You can use a Thread Pool for bonus points.

    Example:
    Input: n = 10
    Output: sum = 40
    Explanation: Numbers in the range [1, 10] that are divisible by 3, 5, or 7 are:
    3, 5, 6, 7, 9, 10. The sum of these numbers is 40.

    Use the tests provided in the test folder to ensure your code works correctly.
 */

import java.util.HashSet;
import java.util.Set;

public class FindMultiples
{
    public static Set<Integer> desirable;
    public static Long sum;
    public static class divisible implements Runnable
    {
        private final int n;
        private final int step;
        public divisible(int n, int step) {
            this.n = n;
            this.step = step;
        }
        public static synchronized void addSum(int i)
        {
            if(!desirable.contains(i)) {
                sum += i;
                desirable.add(i);
            }
        }
        @Override
        public void run() {
            for(int i = step ; i <= n ; i+=step)
            {
                addSum(i);
            }
        }
    }
    /*
    The getSum function should be called at the start of your program.
    New Threads and tasks should be created here.
    */
    public Long getSum(int n) {
        desirable = new HashSet<>();
        sum=0L;
        Thread thread1 = new Thread(new divisible(n,3));
        Thread thread2 = new Thread(new divisible(n,5));
        Thread thread3 = new Thread(new divisible(n,7));
        thread3.start();
        thread2.start();
        thread1.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        return sum;
    }

    public static void main(String[] args) {
    }
}
