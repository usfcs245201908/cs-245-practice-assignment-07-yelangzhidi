public class LinkedList<T> implements List<T> {
    Node head = null;
    int size = 0;
    class Node{
        T data;
        Node next;
        Node(T item){
            data = item;
        }
    }
    @Override
    public void add(T item) {
        if (head == null){
            head = new Node(item);
            ++size;
        }
        else{
            Node n = new Node(item);
            Node prev = head;
            while (prev.next != null)
                prev = prev.next;
            prev.next = n;
            ++size;
        }
    }

    @Override
    public void add(int pos, T item) {
        if (head == null) {
            head = new Node(item);
            ++size;
        }
        else {
            if (pos < 0 || pos > size)
                throw new IndexOutOfBoundsException();
            if (pos == 0) {
                Node n = new Node(item);
                n.next = head.next;
                head = n;
                ++size;
            } else {
                Node n = new Node(item);
                Node prev = head;
                for (int i = 0; i < pos - 1; i++)
                    prev = prev.next;
                n.next = prev.next;
                prev.next = n;
                ++size;
            }
        }
    }

    @Override
    public T get(int pos) {
        if (pos < 0||pos >= size)
            throw new IndexOutOfBoundsException();
        if(pos == 0)
            return head.data;
        else {
            Node prev = head;
            for (int i = 0; i < pos - 1; i++)
                prev = prev.next;
            return prev.next.data;
        }
    }

    @Override
    public T remove(int pos) {
        if (pos < 0||pos >= size)
            throw new IndexOutOfBoundsException();
        if (pos == 0) {
            Node n = head;
            head = head.next;
            --size;
            return n.data;
        }
        else{
            Node prev = head;
            for(int i = 0; i < pos-1; i++)
                prev = prev.next;
            T temp = prev.next.data;
            prev.next = prev.next.next;
            --size;
            return temp;
        }
    }

    @Override
    public int size() {
        return size;
    }
}
