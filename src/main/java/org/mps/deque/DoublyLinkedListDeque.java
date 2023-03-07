package org.mps.deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void prepend(T value) {
        if (size() == 0) {
            first = new DequeNode(value, null, null);
            last = first;
        } else {
            DequeNode<T> aux = first;
            first = new DequeNode(value, null, aux);
            aux.setPrevious(first);
        }
        size++;
    }

    @Override
    public void append(T value) {
        if (size() == 0) {
            first = new DequeNode(value, null, null);
            last = first;
        } else {
            DequeNode<T> aux = last;
            last = new DequeNode(value, aux, null);
            aux.setNext(last);
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        if (size() == 0) {
            throw new DoubleEndedQueueException("Attempt to delete the first element from an empty DoubleLinkedListDeque");
        }
        DequeNode<T> aux = first;
        first = aux.getNext();
        first.setPrevious(null);
        aux.setNext(null);
        size--;
    }

    @Override
    public void deleteLast() {
        if (size() == 0) {
            throw new DoubleEndedQueueException("Attempt to delete the last element from an empty DoubleLinkedListDeque");
        }
        DequeNode<T> aux = last;
        last = aux.getPrevious();
        last.setNext(null);
        aux.setPrevious(null);
        size--;
    }

    @Override
    public T first() {
        if (size() == 0) {
            throw new DoubleEndedQueueException("Attempt to get the first element from an empty DoubleLinkedListDeque");
        }
        return first.getItem();
    }

    @Override
    public T last() {
        if (size() == 0) {
            throw new DoubleEndedQueueException("Attempt to get the last element from an empty DoubleLinkedListDeque");
        }
        return last.getItem();
    }

    @Override
    public int size() {
        return size;
    }
}
