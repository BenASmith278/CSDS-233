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

 2. Write a class CustomQStack which has a single Queue( java.util.Queue<E> ) object in its constructor. The aim of this class is to demonstrate that Queues can be modified to act exactly as Stacks. Our CustomQStack  must have its own methods of empty, pop and push methods as Stack class has. Luckily, Queue class has similar inherent methods  and  with  slight  modifications,  these  methods  may  act  like  those  of  Stack class’. You can assume that our custom class takes only integers as input.

 3. Write a class CustomSQueue which has “two” Stack( java.util.Stack<E> ) objects in its  constructor.  The  aim  of  this  class  is  to  demonstrate  that  Stacks  can  also  be modified to act exactly as Queues. Our CustomSQueue  must have its own methods of add and poll methods as Queue class has. Luckily, Stack class has similar inherent methods  and  with  slight  modifications,  these  methods  may  act  like  those  of  Queue class’. You can assume that our custom class takes only integers as input. For further insight check the following links https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html, https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html.

### Assignment 3:
Create a class named BST_Class with the following methods:  
a) void insert(int key) – inserts a node in the binary search tree (BST) 

b) void postorder(Node node) – post-order traversal of BST 

c) void inorder(Node node) – in-order traversal of BST 

d) void preOrder(Node node) – pre-order traversal of BST 

e) boolean search(int key) – checks whether a given key exists in BST 

f) int minValue(Node root) – finds the smallest element in BST 

g) Void deleteKey(int key) – deletes a node from BST 

You need to develop this class as efficiently as possible. You are allowed to use 
the provided sample code, or you could also start from scratch. The sample code 
will realize (a) insert and (c) in-order methods, which, I believe, could make you 
have a good start. Now you should finish the remaining tasks. 
In your Main class, create an instance of BST_Class and realize the following 
outputs.

### Assignment 4
Write  a  method  called  wordCount  that  takes  a  string  as  an  input  and  prints  out  all  the  words 
encountered in that input, along with their number of occurrences. Use a hash table with separate 
chaining to implement the method.
Assumptions for simplicity: 
- The method is not case-sensitive, meaning that “CSDS” and “csds” are the same. 
- A word is defined to be a string between 2 non-alphabetical characters, which include but not limited to space, punctuations, ‘\t’, ‘\n’, hyphens, underscores, parentheses, etc.
General procedure:
- Split the input string into a list of strings based on non-alphabetical characters. To do this, you can use the method String.split(“\\P{Alpha}+”)
- For each word, search if it is already in the hash table or not. If it is not, add a new entry with an initial frequency of 1. If it is, update the frequency
- If a new entry is added, check if the table needs to be expanded.
- After  scanning  the  entire  list  of  words,  loop  through  the  hash  table  and  print  out  the  list  of words and their frequencies in any order you like.
Additional instructions:
- Use of Java built-in HashTable or any libraries is prohibited, and your work will not be graded if you do so. You should be able to build the hash table, along with desired methods, without using any Java or third-party libraries.
- For the hash function, Java has a “hashCode” function on strings that you can use. For a “string str”, its hash code “h” would be “h = Math.abs(str.hashCode()) % tableSize”. Feel free to come up with your own hash function if you wish to.
- “tableSize” should be adaptive to the situation. If you set “tableSize” to be sufficiently large so it won’t need to be expanded and rehashed, you will be penalized.
- Keep track of the load factor to determine when to expand and rehash your table. For example, if  the  load  factor  exceeds  a  predefined  threshold,  you  can  double  the  size  of  the  hash  table. Keep in mind that while expanding, the hash code of strings might change, so a helper method is needed for rehashing.
- Your method should cover most, if not all, cases, as it will be tested with various inputs.