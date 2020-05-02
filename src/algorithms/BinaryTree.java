package algorithms;

// Let's create a Binary Tree data structure
public class BinaryTree {

    Node root;

    public static void main (String[] args) {
        BinaryTree theTree = new BinaryTree();

        theTree.addNode(50, "Boss");
        theTree.addNode(25, "Vice pres");
        theTree.addNode(15, "Office manager");
        theTree.addNode(30, "Sales Guy");
        theTree.addNode(75, "HR girl");
        theTree.addNode(85, "Janitor");

//        System.out.println("--- Inorder traversal ---");
//        theTree.inOrderTraverseTree(theTree.root);
//
//        System.out.println("--- Preorder traversal ---");
//        theTree.preOrderTraverseTree(theTree.root);

//        System.out.println("--- Postorder traversal ---");
//        theTree.postOrderTraverseTree(theTree.root);

        System.out.println("-- Search for node with key 30 --");
        System.out.println(theTree.findNode(30));
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
