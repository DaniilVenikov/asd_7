import java.util.*;


class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
        if (v1 instanceof Comparable && v2 instanceof Comparable) {
            Comparable<T> comparableV1 = (Comparable<T>) v1;
            return comparableV1.compareTo(v2);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void add(T value)
    {
        if (head == null) {
            head = new Node<>(value);
            tail = head;
            return;
        }

        Node<T> prev = null;
        for (Node<T> current = head; current != null; current = current.next) {
            int cmp = compare(current.value, value);
            if ((_ascending && cmp > 0) || (!_ascending && cmp < 0)) {
                Node<T> newNode = new Node<>(value);
                if (prev == null) {
                    newNode.next = head;
                    head.prev = newNode;
                    head = newNode;
                } else {
                    prev.next = newNode;
                    newNode.prev = prev;
                    newNode.next = current;
                    current.prev = newNode;
                }
                return;
            }
            prev = current;
        }

        Node<T> newNode = new Node<>(value);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public Node<T> find(T val)
    {
        for (Node<T> current = head;current != null; current = current.next) {
            int cmp = compare(current.value, val);
            if (cmp == 0) {
                return current;
            } else if ((_ascending && cmp > 0) || (!_ascending && cmp < 0)) {
                return null;
            }
        }
        return null;
    }

    public void delete(T val)
    {
        for (Node<T> current = head; current != null; current = current.next) {
            if (current.value.equals(val)) {
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                    if (head == null) {
                        tail = null;
                    }
                } else {
                    current.prev.next = current.next;
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }
                    if (current.next == null) {
                        tail = current.prev;
                    }
                }
                return;
            }
        }
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        head = null;
        tail = null;
    }

    public int count()
    {
        int count = 0;
        for (Node<T> current = head; current != null; current = current.next) {
            count++;
        }
        return count;
    }

    ArrayList<Node<T>> getAll()
    {
        ArrayList<Node<T>> result = new ArrayList<>();
        for (Node<T> node = head; node != null; node = node.next) {
            result.add(node);
        }
        return result;
    }
}

