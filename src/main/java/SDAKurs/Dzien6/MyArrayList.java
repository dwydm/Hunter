package SDAKurs.Dzien6;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    private int myArrayListSize = 0;
    E[] internalArray = (E[]) new Object[10];


    @Override
    public int size() {
        return myArrayListSize;
    }

    @Override
    public boolean isEmpty() {
        if(myArrayListSize == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if(internalArray.length == myArrayListSize) {
            internalArray = expandArray();
        }
        myArrayListSize++;
        internalArray[myArrayListSize] = e;
        return false;
    }

    @Override
    public boolean remove(Object o) {


        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        if(index > myArrayListSize) {
            throw new NoSuchElementException();
        }
        E oldElement = internalArray[index];
        internalArray[index] = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        if(myArrayListSize < internalArray.length - 1) {
            E [] tempArray = (E[]) new Object[internalArray.length];
        }

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }


    private E[] expandArray() {
        E[] newList = (E[]) new Object[(myArrayListSize * 2) + 1];
        for (int i = 0; i < internalArray.length; i++) {
            newList[i] = internalArray[i];
        }
        return newList;
    }
}
