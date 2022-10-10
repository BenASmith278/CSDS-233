import java.util.*;

class Assignment2Part2 {

    public static class CustomQStack {
        private int size;
        private Queue<Integer> qStack;

        public CustomQStack() {
            size = 0;
            qStack = new LinkedList<Integer>();
        }

        public boolean isEmpty() {
            if(size == 0)
                return true;

            return false;
        }

        // add number and rotate queue until it is in front
        public void push(int num) {
            qStack.add(num);

            for(int i=0;i<size;i++) {
                int temp = qStack.poll();
                qStack.add(temp);
            }

            size++;
        }

        // remove first number
        // most recent number is first
        public int pop() {
            if (this.isEmpty() != true)
                size--;

            return qStack.remove();
        }

        public String toString() {
            return qStack.toString();
        }
    }

    public static class CustomSQueue {
        // usedStack holds the numbers
        private Deque<Integer> usedStack;
        // tempStack is used to hold numbers when needed
        private Deque<Integer> tempStack;
        private int size;

        public CustomSQueue() {
            usedStack = new ArrayDeque<Integer>();
            tempStack = new ArrayDeque<Integer>();
            size = 0;
        }

        public String toString() {
            return usedStack.toString();
        }

        public boolean isEmpty() {
            if (size == 0)
                return true;
            return false;
        }

        // pile number into stack
        // most recent number is on left, oldest number on right
        public void add(int num) {
            usedStack.push(num);
            size++;
        }


        // oldest number on the bottom
        // throws no such element exception if queue is empty
        public int poll() {
            int out;
            
            // move all numbers from first stack to second stack except for last
            for(int i=0;i<size-1;i++) {
                tempStack.push(usedStack.pop());
            }

            // remove last (oldest) number from first stack and save
            out = usedStack.pop();
            // decrease size
            size--;

            // replace numbers to first stack
            for(int i=0;i<size;i++) {
                usedStack.push(tempStack.pop());
            }

            return out;
        }
    }

    public static void main(String[] args) {
        System.out.println("Part A:");
        
        CustomQStack cQueue = new CustomQStack();

        cQueue.push(5);
        cQueue.push(6);
        cQueue.push(7);
        cQueue.push(8);
        System.out.println(cQueue);
        System.out.println(cQueue.pop());
        System.out.println(cQueue.pop());
        System.out.println(cQueue);
        cQueue.push(9);
        System.out.println(cQueue);

        System.out.println("Part B:");

        CustomSQueue sQ = new CustomSQueue();
        sQ.add(5);
        sQ.add(6);
        sQ.add(7);
        sQ.add(8);
        System.out.println(sQ);
        System.out.println(sQ.poll());
        System.out.println(sQ.poll());
        System.out.println(sQ);
        sQ.add(9);
        System.out.println(sQ);
    }
}