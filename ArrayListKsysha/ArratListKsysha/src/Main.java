public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.menu();
        MyArrayList<String> list1 = new MyArrayList<>();
        list1.menu();
        System.out.println("CompareTo: ");
        System.out.println(list.compareTo(list1));
        System.out.println("Compare: ");
        System.out.println(list.compare(list1,list));
    }
}