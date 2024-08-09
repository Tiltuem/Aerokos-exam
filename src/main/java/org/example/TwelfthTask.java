package org.example;

import java.util.HashSet;
import java.util.Set;

/***
 * Определить наличие цикла в односвязном списке
 */

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class TwelfthTask {
    public static void main(String[] args) {
        Node test1 = new Node(1);
        test1.next = new Node(2);
        test1.next.next = test1;
        Node test2 = new Node(1);
        test2.next = new Node(2);
        test2.next.next = new Node(3);
        System.out.println(hasCycle(test1));
        System.out.println(hasCycle(test2));
    }
    public static boolean hasCycle(Node node) {
        Set<Node> visited = new HashSet<>();
        visited.add(node);
        node = node.next;

        while (node != null) {
            if (!visited.add(node))
                return true;
            node = node.next;
        }

        return false;
    }
}
