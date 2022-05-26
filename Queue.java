public class Queue<T> {
    Node<T> head = null;

    public Queue() {

    }

    public T peek() {
        if (this.head == null) {
            System.out.println("Não é possível ver o elemento, pois a fila esta vazia");
        }
        return this.head.getData();
    }

    public void insert(T data) {
        Node new_node = new Node(data,null);

        if (this.head == null) {
            this.head = new_node;
        }
        else {
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
    }

    public void printQueue(){
        Node base = this.head;

        // Traverse through the LinkedList
        while (base != null) {
            // Print the data at current node
            System.out.print(base.data + " ");
            base = base.next;
        }
    }

    public void clearQueue(){
        this.head = null;
    }

    public T dequeue() {
        if (this.head == null) {
            System.out.print("Não é possível remover o elemento de uma fila vazia");
            return  null;
        }
        T value = this.head.data;
        this.head = this.head.next;
        return value;
    }

    public boolean empty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }
}