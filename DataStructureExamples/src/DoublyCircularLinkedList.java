class Node {
    int data;
    Node prev, next;

    public Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

class DoublyCircularLinkedList {
    private Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;
            last.next = newNode;
            newNode.prev = last;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    public void delete(int key) {
        if (head == null) return;

        Node current = head, prevNode = null;

        // Buscar el nodo a eliminar
        do {
            if (current.data == key) {
                if (current == head && current.next == head) { // Único nodo en la lista
                    head = null;
                } else {
                    if (current == head) head = head.next;
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            prevNode = current;
            current = current.next;
        } while (current != head);
    }

    public void display() {
        if (head == null) {
            System.out.println("Lista vacía");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ⇄ ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(regresa al inicio)");
    }

    public static void main(String[] args) {
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        System.out.println("Lista Circular Doble:");
        list.display();

        list.delete(20);
        System.out.println("Después de eliminar 20:");
        list.display();
    }
}
