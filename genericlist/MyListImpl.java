package genericlist;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class MyListImpl<T> implements MyList<T> {

    private int size = 0;
    private int capacity;
    private Object[] objects;

    MyListImpl() {
        this(10);
    }

    public MyListImpl(int capacity) {
        this.capacity = capacity;
        this.objects = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void add(T data) {
        if (capacity <= size) {
            capacity = capacity * 2;
            objects = Arrays.copyOf(objects, capacity);
        }
        objects[size] = data;
        size++;
    }

    @Override
    public T get(int index) {
        if (isValidIndex(index)) {
            return (T) objects[index];
        }
        return null;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public T remove(int index) {
        if (isValidIndex(index)) {
            System.arraycopy(objects, index + 1, objects, index, size - index);
            --size;
            return (T) objects[index];
        }
        return null;
    }

    @Override
    public T set(int index, T data) {
        if (isValidIndex(index)) {
            objects[index] = data;
            return data;
        }
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.stream(objects).filter(this::notNull).toArray());
    }

    private boolean notNull(Object o) {
        return o != null;
    }

    @Override
    public int indexOf(T data) {
        for (int idx = 0; idx < size; idx++) {
            if (objects[idx].equals(data)) {
                return idx;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (objects[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T[] toArray() {
        return (T[]) objects;
    }

    @Override
    public void clear() {
       size = 0;
       objects = new Object[capacity];
    }

    @Override
    public MyList<T> sublist(int start, int finish) {
        if (isValidIndex(start) && isValidIndex(finish)) {
            MyList<T> myList = new MyListImpl<>();
            IntStream.rangeClosed(start, finish).mapToObj(i -> (T) objects[i]).forEach(myList::add);
            return myList;
        }
        return null;
    }

    @Override
    public boolean contains(T data) {
        for (int i = 0; i < size; i++) {
            if (objects[i].equals(data)) {
                return true;
            }
        }
        return false;
    }
}
