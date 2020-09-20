package algorithms;

// Let's create a Binary Tree data structure
public class BinaryTree {

    Node root;

    public static void main (String[] args) {
        BinaryTree theTree = new BinaryTree();

        theTree.addNode(7, "G");
        theTree.addNode(3, "F");
        theTree.addNode(8, "I");
        theTree.addNode(2, "J");
        theTree.addNode(4, "E");
        theTree.addNode(1, "D");
        theTree.addNode(5, "C");
        theTree.addNode(10, "B");
        theTree.addNode(16, "H");



        System.out.println("--- Inorder traversal ---");
        theTree.inOrderTraverseTree(theTree.root);

//        System.out.println("--- REMOVE KEY 25---");
//        theTree.remove(25);

//        System.out.println("--- Inorder traversal ---");
//        theTree.inOrderTraverseTree(theTree.root);

//        System.out.println("--- Preorder traversal ---");
//        theTree.preOrderTraverseTree(theTree.root);


//        System.out.println("--- Postorder traversal ---");
//        theTree.postOrderTraverseTree(theTree.root);

//        System.out.println("-- Search for node with key 30 --");
//        System.out.println(theTree.findNode(30));
    }

    public boolean remove(int key) {
        Node focusNode = root;
        Node parent = root;

        boolean isItALeftChild = true;

        while(focusNode.key != key) {
            parent = focusNode;

            if(key < focusNode.key) {
                isItALeftChild = true;

                focusNode = focusNode.leftChild;
            } else {
                isItALeftChild = false;
                focusNode = focusNode.rightChild;
            }

            if(focusNode == null)
                return  false;
        }

        // deleting part.
        // at this point the node doesn't have children.
        // now we're in the situation where we're going to delete these guys
        if(focusNode.leftChild == null && focusNode.rightChild == null) {
            if(focusNode == null) {
                root = null;
            } else if(isItALeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }
        // in a situation where there is no right child
        else if(focusNode.rightChild == null) {
            if(focusNode == root) {
                root = focusNode.leftChild;
            } else if(isItALeftChild) {
                parent.leftChild = focusNode.leftChild;
            } else {
                parent.rightChild = focusNode.leftChild;
            }
        }

        else if(focusNode.leftChild == null) {
            if(focusNode == root) {
                root = focusNode.rightChild;
            } else if(isItALeftChild) {
                parent.leftChild = focusNode.rightChild;
            } else {
                parent.rightChild = focusNode.leftChild;
            }
        }

        else { // two children are involved
            Node replacement = getReplacementNode(focusNode);

            if(focusNode == root) {
                root = replacement;
            } else if(isItALeftChild) {
                parent.leftChild = replacement;
            } else
                parent.rightChild = replacement;

            replacement.leftChild = focusNode.leftChild;
        }
        return true;
    }

    public Node getReplacementNode(Node replacedNode) {
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;

        Node focusNode = replacedNode.rightChild;

        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;

            focusNode = focusNode.leftChild;
        }

        if(replacement != replacedNode.rightChild) {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }

        return replacement;
    }

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);

        if(root == null) { // first time
            root = newNode;
        } else {
            // root node already created. Test for children nodes (lhs and rhs childs)
            Node focusNode = root;

            Node parent;

            while(true) {
                parent = focusNode; // save the root as parent and play with node in "focus" i.e. focusNode

                if(key < focusNode.key) { // LEFT child node test in bst: is the root's key is less than given node's key add to left child of root/parent node in tree                    focusNode =  focusNode.leftChild;

                    focusNode = focusNode.leftChild; // focus node is now "left child node"

                    if(focusNode == null) { // if left child node of root or parent in null add newNode to left child
                        parent.leftChild = newNode;
                        return;

                    }
                } else { // RIGHT child node test in bst: the newNode's key is greater than parent node, add to the right child of parent (as is in bst structure)
                    focusNode = focusNode.rightChild; // focus on the right child of root/parent node

                    if(focusNode == null) { // no nodes in the right child of root/parent add newNode then
                        parent.rightChild = newNode;
                        return;
                    }

                }
            }
        }
    }

    // find node
    public Node findNode(int key) {
        Node focusNode = root;

        while(focusNode.key != key) { // its not roots key they want
            if(key < focusNode.key) { // shift the focusNode to the left child -> (left subtree has keys less than parents key value)
                focusNode = focusNode.leftChild;
            } else { // shift the focusNode to the right child -> (right subtree has keys greater than parents key value)
                focusNode = focusNode.rightChild;
            }

            if(focusNode == null) // no nodes including root exists i.e. no bst tree
                return null;

        }

        return focusNode;
    }

    // DFS - in order variant traversal
            // rules - traverse left subtree where the nodes are the smallest values of parent, and then move to right subtree
            // result - in order traversal the smallest key node value is printed first in asc
    public void inOrderTraverseTree(Node focusNode) {
        if(focusNode != null) { // recursively traverse left child nodes first than right
            inOrderTraverseTree(focusNode.leftChild);

            System.out.println(focusNode);  // print recursively inorder node (or return!)

            inOrderTraverseTree(focusNode.rightChild);

        }
    }

    // DFS - pre order variant traversal
    public void preOrderTraverseTree(Node focusNode) {
        if (focusNode != null) { // recursively traverse left child nodes first than right

            System.out.println(focusNode);  // print recursively pre-order traversal (or return!)

            preOrderTraverseTree(focusNode.leftChild);

            preOrderTraverseTree(focusNode.rightChild);

        }
    }

    // DFS - pre order variant traversal
            // ??
    public void postOrderTraverseTree(Node focusNode) {
        if (focusNode != null) { // recursively traverse left child nodes first than right

            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);

            System.out.println(focusNode);  // print recursively pre-order traversal (or return!)

        }
    }
}

class Node {
    int key;
    String name;

    // max children nodes a node have have 2
    Node leftChild;
    Node rightChild;

    Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString() {
        return name + " has a key " + key;
    }

}
