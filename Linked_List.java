/* Homework #2 for CS3353 - Data Structures and Algorithms
 * Program to create and modify single and double linked list using a menu  
 */
import java.util.*;
public class Elaina_Hinkle_2
{
    //Menu
    private static void printMenu()
    {
        System.out.println("                  M E N U");
        System.out.println();
        System.out.println("SLL: IH(0), IT(1), DH(2), DT(3), SD(4), PS(5)");
        System.out.println("DLL: IH(6), IT(7), DH(8), DT(9), SD(10), PD(11)");
        System.out.println("Exit Program (12)");
        System.out.println();
        System.out.println("                  Choose?");
        System.out.println("    *Inputs must be separated with a space*");
        System.out.println();
    }
    
    static class SLL {
        static charSLLNode head;
        static charSLLNode tail;
        
        static class charSLLNode {
            char nodeChar;
            charSLLNode next;
            charSLLNode() {
                next = null;
            }
            charSLLNode(char c,charSLLNode head) {
                nodeChar = c;
                next = null;
            }
        }
        //case 0
        public static void SLLinsertHead(char c) {
            charSLLNode newHead = new charSLLNode(c, head);
            if (head == null) {
                head = newHead;
                tail = newHead;
            }
            else {
                newHead.next = head;
                head = newHead;
            }
        }
        //case 1
        public static void SLLinsertTail(char c) {
            charSLLNode newTail = new charSLLNode(c, tail);
            if (head == null) {
                head = newTail;
                tail = newTail;
            }
            else {
                tail.next = newTail;
                tail = newTail;
            }
        }
        //case 2
        public static void SLLdeleteHead() {
            if (head == null) {
                System.out.println("Cannot delete from empty list");
            }
            else if (head == tail) {
                head = tail = null;
            }
            else {
                charSLLNode temp = head;
                head = head.next;
                temp = null;
            }
        }
        //case 3
        public static void SLLdeleteTail() {
            if (head == null) {
                System.out.println("Cannot delete from empty list");
            }
            else if (head == tail) {
                head = tail = null;
            }
            else {
                int info = tail.nodeChar;
                charSLLNode tmp = head;
                while (tmp.next != tail) {
                    tmp = tmp.next;
                }
                tail = null;
                tail = tmp;
                tail.next = null;
            }
        }
        //case 4
        public static void SLLsearchDelete(char c) {
            if (head != null) {
                if (head == tail && c == head.nodeChar) {
                    head = tail = null;
                }
                else if (head == tail) {
                    System.out.println("There is no such node in the list!");
                }
                else if (head.nodeChar == c) {
                    SLLdeleteHead();
                }
                else {
                    charSLLNode pre = head; 
                    charSLLNode temp = head.next;
                    
                    outer:
                    while(temp.nodeChar != c) {
                        if (temp == tail) {
                            pre = null;
                            break outer;
                        }
                        else {
                            pre = pre.next;
                            temp = temp.next;
                        }
                    }
                    if ( (temp == tail) && temp.nodeChar != c) {
                        System.out.println("There is no such node in the list!");
                    }
                    else if (temp == tail) {
                        SLLdeleteTail();
                    }
                    else {
                        pre.next = temp.next;
                        temp = null;
                    }
                }
            }
            else {
                System.out.println("Cannot delete from empty list");
            }
        }
        //case 5
        public static void printSLL(charSLLNode head) {
            charSLLNode current = head;
            System.out.print("Single Linked List: ");
            
            if (head == null) {
                System.out.println("Empty list");
                System.out.println();
            }
            else {
                while (current != null) {
                    System.out.print(current.nodeChar + " ");
                    current = current.next;
                }
                System.out.println();
            }
        }
    }
    
    static class DLL {
        static charDLLNode head;
        static charDLLNode tail;
        
        static class charDLLNode {
            char nodeChar;
            charDLLNode next;
            charDLLNode prev;
            
            charDLLNode() {
                next = null;
                prev = null;
            }
            charDLLNode(char c,charDLLNode head, charDLLNode tail) {
                nodeChar = c;
                next = null;
                prev = null;
            }
        }
        //case 6
        static void DLLinsertHead(char c) {
            charDLLNode newHead = new charDLLNode(c, head, tail);
            if (head == null) {
                head = newHead;
                tail = newHead;
            }
            else {
                head.prev = newHead;
                newHead.prev = tail;
                tail.next = newHead;
                newHead.next = head;
                head = newHead;
            }
        }
        //case 7 
        static void DLLinsertTail(char c) {
            charDLLNode newTail = new charDLLNode(c, head, tail);
            if (head == null) {
                head = newTail;
                tail = newTail;
            }
            else {
                newTail.prev = tail;
                newTail.next = head;
                tail.next = newTail;
                head.prev = newTail;
                tail = newTail;
            }
        }
        //case 8
        static void DLLdeleteHead() {
            if (head == null) {
                System.out.println("Cannot delete from empty list");
            }
            else if (head == tail) {
                head = tail = null;
            }
            else if (head.next == tail) {
                charDLLNode temp = head;
                head = tail;
                head.prev = head;
                head.next = head;
                temp = null;
            }
            else {
                charDLLNode temp = head;
                head = temp.next;
                tail.next = head;
                head.prev = tail;
                temp = null;
            }
            
        }
        //case 9
        static void DLLdeleteTail() {
            if (head == null) {
                System.out.println("Cannot delete from empty list");
            }
            else if (head == tail) {
                head = tail = null;
            }
            else if (head.next == tail) {
                charDLLNode temp = tail;
                tail = head;
                head.prev = head;
                head.next = head;
                temp = null;
            }
            else {
                charDLLNode temp = tail;
                tail = temp.prev;
                tail.next = head;
                head.prev = tail;
                temp = null;
            }
            
        }
        //case 10 
        static void DLLsearchDelete(char c) {
            if (head != null) {
                    if (head == tail && c == head.nodeChar) {
                        head = tail = null;
                    }
                    else if (head == tail) {
                        System.out.println("There is no such node in the list!");
                    }
                    else if (head.nodeChar == c) {
                        DLLdeleteHead();
                    }
                    else {
                        charDLLNode temp = head.next;
                        while (temp.nodeChar != c) {
                            if (temp == tail) {
                                break;
                            }
                            else {
                                temp = temp.next;
                            }
                        }
                        if (temp == null) {
                            
                        }
                        else if ( (temp == tail) && temp.nodeChar == c ) {
                            DLLdeleteTail();
                        }
                        else if (temp == tail) {
                            System.out.println("There is no such node in the list!");
                        }
                        else {
                            temp.prev.next = temp.next;
                            temp.next.prev = temp.prev;
                            temp = null;
                        }
                    }
            }
            else {
                System.out.println("Cannot delete from empty list");
            }
        }
        //case 11
        static void printDLL(charDLLNode head, charDLLNode tail) {
            charDLLNode current = head;
            charDLLNode stop = tail;
            System.out.print("Double Linked List: ");
            if (head == null) {
                System.out.println("empty list");
            }
            else if (head == tail) {
                System.out.print(current.nodeChar);
                System.out.println();
            }
            else {
                while (current != stop) {
                    System.out.print(current.nodeChar + " ");
                    current = current.next;
                }
                System.out.print(stop.nodeChar);
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //create lists
        SLL singleList = new SLL();
        DLL doubleList = new DLL();
        //initialize variables
        int input = 13;
        char c;
        while(input != 12) {
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
                    System.out.println("That number is not in the menu. Please pick a number 0-12.");
                    break;
                //single linked list
                case 0: 
                    c = sc.next().charAt(0);
                    singleList.SLLinsertHead(c);
                    break;
                
                case 1: 
                    c = sc.next().charAt(0);
                    singleList.SLLinsertTail(c);
                    break;
                
                case 2: singleList.SLLdeleteHead();
                    break;
            
                case 3: singleList.SLLdeleteTail();
                    break;
                
                case 4: 
                    c = sc.next().charAt(0);
                    singleList.SLLsearchDelete(c);
                    break;
                
                case 5: singleList.printSLL(singleList.head);
                    break;
                
                //double linked list
                case 6: 
                    c = sc.next().charAt(0);
                    doubleList.DLLinsertHead(c);
                    break;
                    
                case 7: 
                    c = sc.next().charAt(0);
                    doubleList.DLLinsertTail(c);
                    break;
                    
                case 8: doubleList.DLLdeleteHead();
                    break;
                
                case 9: doubleList.DLLdeleteTail();
                    break;
                
                case 10: 
                    c = sc.next().charAt(0);
                    doubleList.DLLsearchDelete(c);
                    break;
                    
                case 11:
                    doubleList.printDLL(doubleList.head, doubleList.tail);
                    break;
                //Exit
                case 12:
                    System.out.println("Goodbye.");
                    System.exit(0);
            }
            System.out.println();
        }
    }
}
