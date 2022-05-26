public class Node<T> {
    T data;
    Node<T> next;

    public Node(T data, Node<T> previous) {
        this.data = data;
        this.next = previous;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }
}