//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ua.kpi.comsys.test2.implementation;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import ua.kpi.comsys.test2.NumberList;

public class NumberListImpl implements NumberList {
    private Node head = null;
    private int size = 0;

    public boolean add(Byte value) {
        if (value == null) {
            return false;
        } else {
            Node newNode = new Node(value);
            if (this.head == null) {
                this.head = newNode;
                this.head.next = this.head;
            } else {
                Node cur;
                for(cur = this.head; cur.next != this.head; cur = cur.next) {
                }

                cur.next = newNode;
                newNode.next = this.head;
            }

            ++this.size;
            return true;
        }
    }

    public void add(int index, Byte value) {
        if (index >= 0 && index <= this.size) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                Node newNode = new Node(value);
                if (index == 0) {
                    if (this.head == null) {
                        this.head = newNode;
                        this.head.next = this.head;
                    } else {
                        Node tail;
                        for(tail = this.head; tail.next != this.head; tail = tail.next) {
                        }

                        newNode.next = this.head;
                        this.head = newNode;
                        tail.next = this.head;
                    }
                } else {
                    Node cur = this.head;

                    for(int i = 0; i < index - 1; ++i) {
                        cur = cur.next;
                    }

                    newNode.next = cur.next;
                    cur.next = newNode;
                }

                ++this.size;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public Byte get(int index) {
        if (index >= 0 && index < this.size) {
            Node cur = this.head;

            for(int i = 0; i < index; ++i) {
                cur = cur.next;
            }

            return cur.value;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public Byte set(int index, Byte value) {
        if (index >= 0 && index < this.size) {
            Node cur = this.head;

            for(int i = 0; i < index; ++i) {
                cur = cur.next;
            }

            Byte old = cur.value;
            cur.value = value;
            return old;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(Object o) {
        if (!(o instanceof Byte)) {
            return false;
        } else {
            Node cur = this.head;

            for(int i = 0; i < this.size; ++i) {
                if (cur.value.equals(o)) {
                    return true;
                }

                cur = cur.next;
            }

            return false;
        }
    }

    public boolean swap(int index1, int index2) {
        if (index1 >= 0 && index1 < this.size && index2 >= 0 && index2 < this.size) {
            if (index1 == index2) {
                return true;
            } else {
                Node node1 = this.head;
                Node node2 = this.head;

                for(int i = 0; i < index1; ++i) {
                    node1 = node1.next;
                }

                for(int i = 0; i < index2; ++i) {
                    node2 = node2.next;
                }

                Byte tmp = node1.value;
                node1.value = node2.value;
                node2.value = tmp;
                return true;
            }
        } else {
            return false;
        }
    }

    public void sortAscending() {
        if (this.size >= 2) {
            for(int i = 0; i < this.size - 1; ++i) {
                Node cur = this.head;

                for(int j = 0; j < this.size - 1; ++j) {
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
    }

    public void sortDescending() {
        if (this.size >= 2) {
            for(int i = 0; i < this.size - 1; ++i) {
                Node cur = this.head;

                for(int j = 0; j < this.size - 1; ++j) {
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
    }

    public void shiftLeft() {
        if (this.head != null) {
            this.head = this.head.next;
        }

    }

    public void shiftRight() {
        if (this.head != null) {
            Node cur;
            for(cur = this.head; cur.next != this.head; cur = cur.next) {
            }

            this.head = cur;
        }

    }

    public Byte remove(int index) {
        if (index >= 0 && index < this.size) {
            Byte val;
            if (index == 0) {
                val = this.head.value;
                if (this.size == 1) {
                    this.head = null;
                } else {
                    Node tail;
                    for(tail = this.head; tail.next != this.head; tail = tail.next) {
                    }

                    this.head = this.head.next;
                    tail.next = this.head;
                }
            } else {
                Node cur = this.head;

                for(int i = 0; i < index - 1; ++i) {
                    cur = cur.next;
                }

                val = cur.next.value;
                cur.next = cur.next.next;
            }

            --this.size;
            return val;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean addAll(Collection<? extends Byte> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends Byte> c) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }

    public Iterator<Byte> iterator() {
        return null;
    }

    public ListIterator<Byte> listIterator() {
        return null;
    }

    public ListIterator<Byte> listIterator(int index) {
        return null;
    }

    public List<Byte> subList(int fromIndex, int toIndex) {
        return null;
    }

    public Object[] toArray() {
        return null;
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    public int indexOf(Object o) {
        return -1;
    }

    public int lastIndexOf(Object o) {
        return -1;
    }

    public boolean remove(Object o) {
        return false;
    }
}
