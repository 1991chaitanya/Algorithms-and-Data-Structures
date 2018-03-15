import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chaitanya.Chobharkar on 3/1/2018.
 */
public class CustomLinkedList {

    private Node head;
    private Node current;

    public Node createNode(int data) {
        Node node = new Node(data);
        node.next = null;
        return node;
    }

    public void addNode(Node node) {
        if (head == null) {
            head = node;
            current = head;
        } else {
            current.next = node;
            current = node;
        }
        current.next = null;
    }

    public void addNode(Node node, int pos) {
        Node finderNode = head;
        for (int i=0; i< pos-1; i++) {
            finderNode = finderNode.next;
        }
        node.next = finderNode.next;
        finderNode.next = node;
    }

    public Node removeNode(int pos) {
        Node finderNode = head;
        for (int i=0; i< pos-1; i++) {
            finderNode = finderNode.next;
        }
        Node removedNode = finderNode.next;
        finderNode.next = finderNode.next.next;

        removedNode.next = null;
        return removedNode;
    }

    public Node removeNode(Node node) {
        Node removedNode = head;
        for (Node currNode=head; currNode != null; currNode = currNode.next) {
           if (currNode.next.data == node.data) {
               removedNode = currNode;
               break;
           }
        }
        removedNode.next = removedNode.next.next;
        removedNode = node;
        removedNode.next = null;
        return removedNode;
    }

    public void reverse() {
        Node p1 = head;
        Node p2 = p1.next;
        Node p3 = p2.next;
        p1.next = null;
        while(p3 !=null) {
            p2.next = p1;
            p1=p2;
            p2=p3;
            p3 = p3.next;
        }
        p2.next = p1;
        head = p2;
    }

    public int size() {
        int length = 0;
        for (Node node=head; node.next != null; node = node.next) {
            length++;
        }
        return length;
    }


    public void print() {
        for (Node node=head; node != null; node = node.next) {
            if (node.next == null) {
                System.out.print(""+node.data+"->"+"null");
            } else {
                System.out.print(""+node.data+"->");
            }

        }
    }



    public void removeDuplicates() {
        Set<Integer> set = new HashSet<>();
        set.add(head.data);
        Node node = head;
        Node nextNode = node.next;
        while (node.next != null) {
            boolean add = set.add(nextNode.data);
            if (!add) {
                node.next = nextNode.next;
                nextNode.next = null;
                nextNode = node.next;
            } else {
                node = node.next;
                nextNode = node.next;
            }
        }
    }

    @Override
    protected CustomLinkedList clone() throws CloneNotSupportedException {
        return (CustomLinkedList) super.clone();
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Node node = new Node(data);
            node.next = next;
            return node;
        }
    }
}
