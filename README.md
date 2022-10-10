# CSDS-233
 Classwork for CSDS 233 Intro to Data Structures

 Each assignment is conatined within its own folder.

 ### Assignment 1
 1. Write a program in both iterative and recursive approaches that prints out the 𝑛𝑡ℎ Fibonacci element(not the whole sequence). Name the method as you like(e.g., fibonacciIteration(int n) and fibonacciRecursion(int n)). Please consider the efficiency of the two methods in terms of Time Complexity and type the Big-O notation down as comments. Call the method that is more efficient in the main method. (15 pts)

2. Based on the program you created, further develop the program that adds each Fibonacci number(starting from 0, 1) to a list (an array), and can perform remove, ifContains, grab, and numItems operations. (35 pts) 
 
 ● add(int item): add a number to the list (allow to add duplicates)
 
 ● remove(int item): remove the item (if exists) from the list
 
 ● ifContains(int item): check if the item exists in the list
 
 ● grab(): random draw a number from the list without removing
 
 ● numItems(): prints out the number of unique items in the list (without duplicates)

 ### Assignment 2
 1. Consider a singly linked list like the example given below. Write a linear-running time method public void reverse () that would be invoked on a list object (e.g., lst.reverse()) and would reverse the list using only constant space (which basically means that you cannot use additional lists in your implementation). For simplicity, you can assume lst as a linked list of integers. Note: This precludes using recursion since this would use a nonconstant space in the call stack memory.

 2. a. Write a class CustomQStack which has a single Queue( java.util.Queue<E> ) object in its constructor. The aim of this class is to demonstrate that Queues can be modified to act exactly as Stacks. Our CustomQStack  must have its own methods of empty, pop and push methods as Stack class has. Luckily, Queue class has similar inherent methods  and  with  slight  modifications,  these  methods  may  act  like  those  of  Stack class’. You can assume that our custom class takes only integers as input.

 2. b. Write a class CustomSQueue which has “two” Stack( java.util.Stack<E> ) objects in its  constructor.  The  aim  of  this  class  is  to  demonstrate  that  Stacks  can  also  be modified to act exactly as Queues. Our CustomSQueue  must have its own methods of add and poll methods as Queue class has. Luckily, Stack class has similar inherent methods  and  with  slight  modifications,  these  methods  may  act  like  those  of  Queue class’. You can assume that our custom class takes only integers as input. For further insight check the following links https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html, https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html.