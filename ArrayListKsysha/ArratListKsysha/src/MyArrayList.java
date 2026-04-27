import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MyArrayList<T> implements Comparator, Comparable {
    private Object[] data = new Object[10];
    private int size = 0;
    public void add(Object value) {
        if (size == data.length) {
            resize();
        }
        data[size++] = value;
    }
    public void add(int index, Object value) {
        if (index < 0 || index > size) {
            throw new MyException("Невірний індекс");
        }
        if (size == data.length) {
            resize();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }
    public void addFirst(Object value) {
        add(0, value);
    }
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new MyException("Невірний індекс");
        }
        return (T) data[index];
    }
    public int size() {
        return size;
    }
    public int capacity() {
        return data.length;
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new MyException("Невірний індекс");
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
    }
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }
    private void resize() {
        Object[] newArr = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newArr[i] = data[i];
        }
        data = newArr;
    }
    public void sort() {
        Arrays.sort(data);
        }
    public void printList() {
        for (int i = 0; i < size(); i++) {
            System.out.println(get(i));
        }
    }
    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public void menu () {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1 - add");
            System.out.println("2 - add first");
            System.out.println("3 - add by index");
            System.out.println("4 - get");
            System.out.println("5 - remove");
            System.out.println("6 - print");
            System.out.println("7 - clear");
            System.out.println("8 - size");
            System.out.println("9 - capacity");
            System.out.println("10 - sort");
            System.out.println("0 - exit");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 0) break;
            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    add(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    addFirst(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Enter index: ");
                    int indexAdd = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter value: ");
                    add(indexAdd, sc.nextLine());
                    break;
                case 4:
                    System.out.print("Enter index: ");
                    int indexGet = sc.nextInt();
                    sc.nextLine();
                    System.out.println(get(indexGet));
                    break;
                case 5:
                    System.out.print("Enter index: ");
                    int indexRemove = sc.nextInt();
                    sc.nextLine();
                    remove(indexRemove);
                    System.out.println("Removed");
                    break;
                case 6:
                    printList();
                    break;
                case 7:
                    clear();
                    break;
                case 8:
                    System.out.println("Size: " + size());
                    break;
                case 9:
                    System.out.println("Capacity: " + capacity());
                    break;
                case 10:
                    sort();
                    System.out.println("Відсортовано");
                    break;
            }
        }
        sc.close();
    }
}