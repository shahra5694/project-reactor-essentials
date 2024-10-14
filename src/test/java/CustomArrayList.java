
interface ICustomArrayList<T> {
    public void set(int index, T value);
    public T get(int index);
    public int size();
    public void add(T value);
    public boolean isEmpty();
    public void insert(int index, T value);
    public void delete(int index);
    public boolean contains(T value);
}

public class CustomArrayList<T> implements ICustomArrayList<T> {
    private T[] array;
    private int size;

    public CustomArrayList() {
        array = (T[]) new Object[3];
        size = 0;
    }

    @Override
    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = value;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
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
    public void add(T value) {
        if (size == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size++] = value;
    }

    @Override
    public void insert(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }
}

class CheckArrayList {
    public static void main(String[] args) {
        ICustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list.toString());

        list.insert(2,10);
        System.out.println(list.isEmpty());
        System.out.println(list.contains(4));
        System.out.println(list.get(1));
        list.delete(2);
        list.set(2,11);
        System.out.println(list.size());
    }
}
