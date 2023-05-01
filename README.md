1-for the first problem override the `compareTo()` method to use the `Collections.sort()` method to sort tasks by their time and then use a for loop to create, run, and wait for them to complete.

2-for this problem create three threads that iterate 1-n to find numbers that are divided by the input number and add them to a set to recognize whether that is a number in that set or not. but must use the synchronized keyword to handle race conditions.

3-for this problem when creating a thread and starting it makes sleep in the main thread and when the main thread starts to run check whether that thread still running or not.