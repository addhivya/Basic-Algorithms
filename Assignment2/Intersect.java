package Assignment2;

public class Intersect {

    public Node checkIntersect(LinkedList l1, LinkedList l2) {
        int l1Length = l1.length();
        int l2Length = l2.length();
        Node l1tail = l1.getNNode(l1Length);
        Node l2tail = l2.getNNode(l2Length);
        if (l1tail == l2tail) {
            System.out.println("Both linked list Intersect");
        } else {
            System.out.println("Both linked list does not Intersect");
            return null;
        }

        int diff = Math.abs(l1Length - l2Length);

        LinkedList small = l1Length < l2Length ? l1 : l2;
        int smallLength = small.length();
        int move = smallLength - diff;
        Node intersect = small.getNNode(move);
        System.out.println("Node at intersection :" + intersect.data);
        return intersect;
    }


    public static void main(String[] args) {
        Intersect I = new Intersect();
        LinkedList l1 = new LinkedList();
        for (int i = 1; i < 3; i++) {
            Node newNode = new Node(i);
            l1.addNode(newNode);
        }
        Node cNode1 = new Node(4);
        l1.addNode(cNode1);
        Node cNode2 = new Node(5);
        l1.addNode(cNode2);
        System.out.println("Linked List1");
        l1.print();
        LinkedList l2 = new LinkedList();
        Node newNode1 = new Node(6);
        l2.addNode(newNode1);
        l2.addNode(cNode1);
        System.out.println("Linked List2");
        l2.print();
        Node intersectingNode = I.checkIntersect(l1, l2);
    }
}
