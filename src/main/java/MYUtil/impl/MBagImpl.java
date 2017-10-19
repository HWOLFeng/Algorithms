package MYUtil.impl;

import MYUtil.MBag;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author HWOLF
 * @version create in：17-10-19 上午10:35
 * @descrption
 */
public class MBagImpl implements MBag<MBagImpl>,Iterable<MBagImpl>{

    public MBagImpl() {
    }

    @Override
    public void add(MBagImpl item) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
    @Override
    public Iterator<MBagImpl> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super MBagImpl> action) {

    }

    @Override
    public Spliterator<MBagImpl> spliterator() {
        return null;
    }
}
