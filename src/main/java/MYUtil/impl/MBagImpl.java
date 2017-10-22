package MYUtil.impl;

import MYUtil.MBag;
import MYUtil.Node;

import java.util.Iterator;

/**
 * @author HWOLF
 * @version create in：17-10-19 上午10:35
 * @descrption
 */
public class MBagImpl<T> implements MBag<T>,Iterable<T>{

    private Node pre;
    private int size = 0;
    public MBagImpl() {

    }

    @Override
    public void add(T item) {
        Node next = pre;
        pre = new Node();
        pre.setItem(item);
        pre.setNext(next);
        size++;
    }

    @Override
    public boolean isEmpty() {
        return pre == null;
    }

    @Override
    public int size() {
        return getSize();
    }

    private class ListIterator implements Iterator<T>{

        private Node node = pre;

        @Override
        public boolean hasNext() {
            return node!=null;
        }

        @Override
        public T next() {
            T item = (T) node.getItem();
            node = node.getNext();
            return item ;
        }

    }
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
