class Node {
    int key;
    Node left, right;

    public Node(int data){
        key = data;
        left = right = null;
    }
}

class BST_Class {
    //node class that defines BST node
    // BST root node 
    Node root;

    // Constructor for BST =>initial empty tree
    BST_Class(){
        root = null;
    }

    // helper method to deleteKey that handles all cases
    void delete(Node toDelete, Node toDeleteParent) {
        // cases 1 and 2 - 0 or 1 children
        if (toDelete.left == null || toDelete.right == null) {
            Node toDeleteChild = null;

            // case 1 - toDeleteChild = null
            // case 2 - set toDeleteChild
            if (toDelete.left != null)
                toDeleteChild = toDelete.left;
            else
                toDeleteChild = toDelete.right;
            
            // assign child node to correct spot
            if (toDelete == root)
                root = toDeleteChild;
            else if (toDelete.key < toDeleteParent.key)
                toDeleteParent.left = toDeleteChild;
            else
                toDeleteParent.right = toDeleteChild;
        // case 3 - two children
        } else {
            // find inorder successor (smallest node on right subtree)
            Node replaceParent = toDelete;
            Node replace = toDelete.right;

            while (replace.left != null) {
                replaceParent = replace;
                replace = replace.left;
            }

            // change info in deleted node to replacement's info
            toDelete.key = replace.key;

            // delete the replacement's old node
            delete(replace, replaceParent);
        }
    }

    //delete a node from BST
    void deleteKey(int key) {
        Node toDeleteParent = null;
        Node trav = root;

        // find node to delete
        while (trav != null && trav.key != key) {
            toDeleteParent = trav;

            // go right if key bigger
            if (trav.key < key) 
                trav = trav.right;
            // go left if key smaller
            else 
                trav = trav.left;
        }

        // if node exists, delete
        if (trav != null)
            delete(trav, toDeleteParent);

        return;
    }

    // finds minimum value in tree starting from root
    int minValue(Node root)  {
        Node trav = root;

        // find the left-most node of the tree (the smallest)
        while (trav.left != null) {
            trav = trav.left;
        }

        System.out.println(trav.key);
        return trav.key;
    }

    void getMinValue() {
        minValue(root);
    }

    // insert a node in BST
    void insert(int key)  {
        root = insert_Recursive(root, key);
    }

    //recursive insert function
    Node insert_Recursive(Node root, int key) {
        //tree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }
        //traverse the tree
        if (key < root.key)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key);
        else if (key > root.key)    //insert in the right subtree
            root.right = insert_Recursive(root.right, key);
        // return pointer
        return root;
    }

    // return true if node with given key exists
    boolean search(int key)  {
        Node trav = root;
        
        // traverse through tree
        while (trav != null) {
            // key found
            if (trav.key == key)
                return true;

            // go right if key bigger
            if (trav.key < key)
                trav = trav.right;
            // go left if key smaller
            else
                trav = trav.left;
        }
        
        // key not found
        return false;
    }

    //PostOrder Traversal - Left:Right:rootNode (LRn)
    void postOrder(Node node)  {
        if (node == null)
            return;
        // first traverse left subtree recursively
        postOrder(node.left);

        // next traverse right subtree recursively
        postOrder(node.right);

        // finally go for root node
        System.out.print(node.key + " ");

    }
    // InOrder Traversal - Left:rootNode:Right (LnR)
    void inOrder(Node node)  {
        if (node == null)
            return;
        //first traverse left subtree recursively
        inOrder(node.left);

        //then go for root node
        System.out.print(node.key + " ");

        //next traverse right subtree recursively
        inOrder(node.right);
    }
    //PreOrder Traversal - rootNode:Left:Right (nLR)
    void preOrder(Node node)  {
        if (node == null)
            return;
        // first go for root node
        System.out.print(node.key + " ");

        // next traverse left subtree recursively
        preOrder(node.left);

        // then traverse right subtree recursively
        preOrder(node.right);
    }

    // Wrappers for recursive functions
    void postOrder_traversal()  {
        postOrder(root);  }
    void inOrder_traversal() {
        inOrder(root);   }
    void preOrder_traversal() {
        preOrder(root);  }
}

// class Main{
//     public static void main(String[] args)  {
//         //create a BST object
//         BST_Class bst = new BST_Class();
//         //insert data into BST
//         bst.insert(45);
//         bst.insert(10);
//         bst.insert(7);
//         bst.insert(12);
//         bst.insert(90);
//         bst.insert(50);
//         //print the BST
//         System.out.println("The BST Created with input data(Left-root-right):");
//         bst.inOrder_traversal();
//         System.out.println("\nThe smallest number in the BST is  =>");
//         bst.getMinValue();

//         //delete leaf node
//         System.out.println("\nThe BST after Delete 12(leaf node):");
//         bst.deleteKey(12);
//         bst.inOrder_traversal();
//         //delete the node with one child
//         System.out.println("\nThe BST after Delete 90 (node with 1 child):");
//         bst.deleteKey(90);
//         bst.inOrder_traversal();

//         //delete node with two children  
//         System.out.println("\nThe BST after Delete 45 (Node with two children):");
//         bst.deleteKey(45);
//         bst.inOrder_traversal();
        
//         //search a key in the BST
//         boolean ret_val = bst.search (50);
//         System.out.println("\nKey 50 found in BST: " + ret_val );
//         ret_val = bst.search (12);
//         System.out.println("Key 12 found in BST: " + ret_val );

//         //construct a BST
//         BST_Class tree = new BST_Class();
//         tree.root = new Node(45);
//         tree.root.left = new Node(10);
//         tree.root.right = new Node(90);
//         tree.root.left.left = new Node(7);
//         tree.root.left.right = new Node(12);
//         //PreOrder Traversal
//         System.out.println("\nBST => PreOrder Traversal:");
//         tree.preOrder_traversal();
//         //InOrder Traversal
//         System.out.println("\nBST => InOrder Traversal:");
//         tree.inOrder_traversal();
//         //PostOrder Traversal
//         System.out.println("\nBST => PostOrder Traversal:");
//         tree.postOrder_traversal();
//         System.out.println("\nThe smallest number in the BST is  =>");
//         tree.getMinValue();
//     }
// }
