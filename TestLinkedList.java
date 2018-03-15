/**
 * Created by Chaitanya.Chobharkar on 3/1/2018.
 */
public class TestLinkedList {


    public static void main(String[] args) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        CustomLinkedList.Node node1 = customLinkedList.createNode(1);
        customLinkedList.addNode(node1);

        CustomLinkedList.Node node9 = customLinkedList.createNode(2);
        customLinkedList.addNode(node9);

        CustomLinkedList.Node node10 = customLinkedList.createNode(3);
        customLinkedList.addNode(node10);

        CustomLinkedList.Node node2 = customLinkedList.createNode(6);
        customLinkedList.addNode(node2);

        CustomLinkedList.Node node3 = customLinkedList.createNode(10);
        customLinkedList.addNode(node3);

        CustomLinkedList.Node node4 = customLinkedList.createNode(6);
        customLinkedList.addNode(node4);

        CustomLinkedList.Node node5 = customLinkedList.createNode(7);
        customLinkedList.addNode(node5);

        CustomLinkedList.Node node6 = customLinkedList.createNode(9);
        customLinkedList.addNode(node6);

        CustomLinkedList.Node node7 = customLinkedList.createNode(9);
        customLinkedList.addNode(node7);

        CustomLinkedList.Node node8 = customLinkedList.createNode(10);
        customLinkedList.addNode(node8);
        customLinkedList.print();

        /*CustomLinkedList.Node node6 = customLinkedList.createNode(6);
        customLinkedList.addNode(node6, 3);
        customLinkedList.print();*/
        System.out.println("");
        /*CustomLinkedList.Node removedNode = customLinkedList.removeNode(2);
        customLinkedList.print();*/
       /* customLinkedList.reverse();
        System.out.println("");
        customLinkedList.print();*/
        customLinkedList.removeDuplicates();
        customLinkedList.print();
    }

}
