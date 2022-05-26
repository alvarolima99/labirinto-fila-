public class Queue<T> {
    Node<T> head = null;
    Node<T> tail = null;


    public T peek() {
        if (this.head == null) {
            System.out.println("Não é possível ver o elemento, pois a fila esta vazia");
        }
        return this.tail.getData();
    }

    public void enqueue(T data) {
        this.tail = new Node<>(data, this.tail);
    }

    public void dequeue() {
        if (this.head == null) {
            System.out.print("Não é possível remover o elemento de uma fila vazia");
        }
        this.tail = this.tail.getPrevious();
    }

    public boolean empty() {
        if (this.head == null) {
            return tail == null;
        }
        return false;
    }
}


