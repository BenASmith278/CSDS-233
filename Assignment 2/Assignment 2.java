class Assignment2 {
    
    public static class LinkedList {
        private Node head;

        private class Node {
            private int val;
            private Node next;

            public Node(int val) {
                this.val = val;
                this.next = null;
            }
        }

        public LinkedList() {
            this.head = null;
        }

        // traverse list and print
        public void print() {
            Node trav = head; 
            
            while(trav != null) {
                System.out.print(trav.val + " ");
                
                trav = trav.next;
            }
        }

        public void add(int val) {
            // set head if null
            if (this.head == null) {
                this.head = new Node(val);

            } else {
                // point last element to new element
                Node trav = head;

                while(trav.next != null) {
                    trav = trav.next;
                }

                trav.next = new Node(val);
            }
        }

        public void reverse() {
            if (head == null || head.next == null) {
                return;
            }
            
            // start from second element
            // before needs to be defined
            Node trav = head.next;
            Node before = head;
            Node after;

            head.next = null;

            while(trav.next != null) {
                // point current node.next to the node before it
                after = trav.next;
                trav.next = before;

                // continue to move towards end of list
                before = trav;
                trav = after;
            }

            // move head to new start of list
            trav.next = before;
            head = trav;
        }
    }   

    public static void main(String args[]) {
        LinkedList LL = new LinkedList();
        LL.add(5);
        LL.add(6);
        LL.add(7);
        LL.add(8);
        LL.print();
        LL.reverse();
        System.out.println();
        LL.print();
    }
}