package list.core.lists;

import list.core.GBList;

import java.util.Iterator;

public class LinkList<T> implements GBList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    private boolean isOutOfBoundsException(int index) {
        return index < 0 || index >= size();
    }

    @Override
    public void add(T elem) {
        Node<T> newNoda = new Node<>();
        newNoda.value = elem;
        newNoda.next = head;
        newNoda.previous = null;

        if (head != null) {
            head.previous = newNoda;
        }
        head = newNoda;
        size++;
    }

    @Override
    public void addLast(T elem) {
        Node<T> newNoda = new Node<>();
        newNoda.value = elem;
        if (head == null){
            head = newNoda;
        }else{
            Node<T> last = head;
            while (last.next != null){
                last = last.next;
            }
            last.next = newNoda;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        if (isOutOfBoundsException(index)) {
            throw new IndexOutOfBoundsException("index" + index + ", size" + size());
        }
        if (index == 0) {
            head = head.next;
            head.previous = null;
        } else {
            Node<T> current = head;
            for (int i = 0; i != index; i++) {
                current = current.next;
            }
            if (current != null) {
                current.next.previous = current.previous;
            }
            if(current.previous != null){
            current.previous.next = current.next;
            }
        }
        size--;
    }

    @Override
    public T get(int index) {
        if (isOutOfBoundsException(index)) {
            throw new IndexOutOfBoundsException("index" + index + ", size" + size());
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> prev = null;
            Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                prev = current;
                current = current.next;
                return prev.value;
            }
        };
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        if (size == 0) {
            return "[]";
        }
        Node<T> current = head;
        while (current != null) {
            builder.append(current.value).append(", ");
            current = current.next;
        }
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}
