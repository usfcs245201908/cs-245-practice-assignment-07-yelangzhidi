import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    int size = 0;
    T[] a = (T[]) new Object[10];
    @Override
    public void add(T item) {
        if (size == a.length)
            growArray();

        a[size++] = item;
    }

    @Override
    public void add(int pos, T item) {
        if (pos > size || pos < 0)
            throw new IndexOutOfBoundsException();
        if (size == a.length)
            growArray();
        for(int i = size; i > pos; i--)
            a[i] = a[i-1];
        a[pos] = item;
        ++size;
    }

    @Override
    public T get(int pos) {
        if (pos >= size || pos < 0)
            throw new IndexOutOfBoundsException();
        return a[pos];
    }

    @Override
    public T remove(int pos) {
        if (pos >= size || pos < 0)
            throw new IndexOutOfBoundsException();
        T item = a[pos];
        System.arraycopy(a,pos+1,a,pos,a.length-1-pos);
        /*
        for (int i = pos; i < size-1; i++)
            a[i] = a[i+1];
         */
        --size;
        return item;
    }

    @Override
    public int size() {
        return size;
    }
    protected void growArray(){
        a = Arrays.copyOfRange(a,0,a.length*2);
    }
    /*
    class ListIterator{
        int pos = 0;
        boolean hasNext(){
            return pos+1< size;
        }
        T next(){
            return a[pos++];
        }
    }
     */
}
