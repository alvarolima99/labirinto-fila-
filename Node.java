public class Node<T> {
    T data;
    Node<T> previous;

    public Node(T data, Node<T> previous) {
        this.data = data;
        this.previous = previous;
    }

    public T getData() {
        return data;
    }

    public Node<T> getPrevious() {
        return previous;
    }
}