/* Homework #5 for CS 3353 - Data Structures and Algorithms
 * Uses a text menu to provide options for creating, searching, and traversing a binary search tree
 */
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Elaina_Hinkle_5
{
    static Tree bst = new Tree();
    static class Tree {
        public static Node root;
        class Node {
            public int key;
            public Node left;
            public Node right;
    
            public Node(int data) {
                this.key = data;
                this.left = null;
                this.right = null;
            }
        }
        public Tree() {
            this.root = null;
        }
        
        public void insert(int data) {
            this.root = insert(root, data);
        }
    
        public Node insert(Node root, int data) {
            if (root == null) {
                root = new Node(data);
                return root;
            }
            else if (root.key >= data) {
                root.left = insert(root.left, data);
            } else {
                root.right = insert(root.right, data);
            }
            return root;
        }
        //Search
        public static void search(int data) {
            search(root, data);
        }
        
        public static void search(Node root, int data) {
            if (root == null) {
                System.out.println("There is no such node in the tree!");
                System.out.println();
            }
            else if (root.key == data) {
                System.out.println("Node found in the tree.");
                System.out.println();
            }
            else if (root.key > data) {
                search(root.left, data);
            }
            else {
                search(root.right, data);
            }
        }
        //Traversal
        public static void breadth() {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(bst.root);
            while (!queue.isEmpty()) {
                Node temp = queue.poll();
                System.out.print(temp.key + " ");
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        public static void preorder() {
            preorder(root);
        }
    
        public static void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
        
        public static void inorder() {
            inorder(root);
        }
        
        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
        
        public static void postorder() {
            postorder(root);
        }
        
        public static void postorder(Node root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }
    
    private static void printMenu() {
        System.out.println("                         M E N U");
        System.out.println();
        System.out.println("Create (0), Search (1), Breadth-First Traversal (2)");
        System.out.println("Depth-First Traversal: preorder (3), inorder (4), postorder (5)");
        System.out.println("Exit Program (6)");
        System.out.println();
        System.out.println("                         Choose?");
        System.out.println("  *Inputs must be separated with a space or enter key*");
        System.out.println();
    }
    //chose 0
    private static void createBST(String s){
        String[] array = s.split(" ");
        
        for (int i = 1; i < array.length; i++) {
            bst.insert(Integer.parseInt(array[i]));
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = 7;
        
        while (input != 6) {
            printMenu();
            //take user input
            while(!sc.hasNextInt()) {
                System.out.println("Invalid input. Try Again.");
                sc.next();
            }
            input = sc.nextInt();
            //enable menu functions
            switch(input) {
                default:
                    System.out.println("That number is not in the menu. Please pick a number 0-6.");
                    System.out.println();
                    break;
                case 0:
                    String s = sc.nextLine();
                    createBST(s);
                    break;
                case 1:  
                    int data = sc.nextInt();
                    Tree.search(data);
                    break;
                case 2:
                    Tree.breadth();
                    break;
                case 3:
                    Tree.preorder();
                    break;
                case 4:  
                    Tree.inorder();
                    break;
                case 5:
                    Tree.postorder();
                    break;
                case 6:
                    System.out.println("Goodbye.");
                    System.exit(0);
            }
        }
    }
}
