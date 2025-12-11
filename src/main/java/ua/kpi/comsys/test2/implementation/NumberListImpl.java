/**
 * Implementation of NumberList for variant 4 (circular singly-linked list).
 * Does not use standard Java collections.
 *
 * @author Vashchenko Anhelina, ІП-33, № 4
 */

package ua.kpi.comsys.test2.implementation;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import ua.kpi.comsys.test2.NumberList;

public class NumberListImpl implements NumberList {

    private static class Node {
        Byte value;
        Node next;

        Node(Byte value) {
            this.value = value;
        }
    }

    private Node head;
    private int size;

    public NumberListImpl() {
        head = null;
        size = 0;
    }

    @Override
    public boolean add(Byte value) {
        if (value == null) return false;
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node cur = head;
            while (cur.next != head) cur = cur.next;
            cur.next = newNode;
            newNode.next = head;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, Byte value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (value == null) throw new NullPointerException();
        Node newNode = new Node(value);
        if (index == 0) {
            if (head == null) {
                head = newNode;
                head.next = head;
            } else {
                Node tail = head;
                while (tail.next != head) tail = tail.next;
                newNode.next = head;
                head = newNode;
                tail.next = head;
            }
        } else {
            Node cur = head;
            for (int i = 0; i < index - 1; i++) cur = cur.next;
            newNode.next = cur.next;
            cur.next = newNode;
        }
        size++;
    }

    @Override
    public Byte get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        return cur.value;
    }

    @Override
    public Byte set(int index, Byte value) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        Byte old = cur.value;
        cur.value = value;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (!(o instanceof Byte)) return false;
        Node cur = head;
        for (int i = 0; i < size; i++) {
            if (cur.value.equals(o)) return true;
            cur = cur.next;
        }
        return false;
    }

    @Override
    public boolean swap(int index1, int index2) {
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) return false;
        if (index1 == index2) return true;
        Node node1 = head, node2 = head;
        for (int i = 0; i < index1; i++) node1 = node1.next;
        for (int i = 0; i < index2; i++) node2 = node2.next;
        Byte tmp = node1.value;
        node1.value = node2.value;
        node2.value = tmp;
        return true;
    }

    @Override
    public void sortAscending() {
        if (size < 2) return;
        for (int i = 0; i < size - 1; i++) {
            Node cur = head;
            for (int j = 0; j < size - 1; j++) {
                Node next = cur.next;
                if (cur.value > next.value) {
                    Byte tmp = cur.value;
                    cur.value = next.value;
                    next.value = tmp;
                }
                cur = cur.next;
            }
        }
    }

    @Override
    public void sortDescending() {
        if (size < 2) return;
        for (int i = 0; i < size - 1; i++) {
            Node cur = head;
            for (int j = 0; j < size - 1; j++) {
                Node next = cur.next;
                if (cur.value < next.value) {
                    Byte tmp = cur.value;
                    cur.value = next.value;
                    next.value = tmp;
                }
                cur = cur.next;
            }
        }
    }

    @Override
    public void shiftLeft() {
        if (head != null) head = head.next;
    }

    @Override
    public void shiftRight() {
        if (head != null) {
            Node cur = head;
            while (cur.next != head) cur = cur.next;
            head = cur;
        }
    }

    @Override
    public Byte remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Byte val;
        if (index == 0) {
            val = head.value;
            if (size == 1) {
                head = null;
            } else {
                Node tail = head;
                while (tail.next != head) tail = tail.next;
                head = head.next;
                tail.next = head;
            }
        } else {
            Node cur = head;
            for (int i = 0; i < index - 1; i++) cur = cur.next;
            val = cur.next.value;
            cur.next = cur.next.next;
        }
        size--;
        return val;
    }

    // Методи List<Byte>, які не обов'язково реалізовувати для завдання, залишаються порожніми
    @Override public boolean addAll(java.util.Collection<? extends Byte> c) {return false;}
    @Override public boolean addAll(int index, java.util.Collection<? extends Byte> c) {return false;}
    @Override public boolean containsAll(java.util.Collection<?> c) {return false;}
    @Override public boolean removeAll(java.util.Collection<?> c) {return false;}
    @Override public boolean retainAll(java.util.Collection<?> c) {return false;}
    @Override public void clear() { head = null; size = 0; }
    @Override public java.util.Iterator<Byte> iterator() {return null;}
    @Override public java.util.ListIterator<Byte> listIterator() {return null;}
    @Override public java.util.ListIterator<Byte> listIterator(int index) {return null;}
    @Override public java.util.List<Byte> subList(int fromIndex, int toIndex) {return null;}
    @Override public Object[] toArray() {return null;}
    @Override public <T> T[] toArray(T[] a) {return null;}
    @Override public int indexOf(Object o) {return -1;}
    @Override public int lastIndexOf(Object o) {return -1;}
    @Override public boolean remove(Object o) {return false;}
}
