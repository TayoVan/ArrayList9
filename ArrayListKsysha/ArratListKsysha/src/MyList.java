public interface MyList {
    void add(String element);
    void add(int index, String element);
    String get(int index);
    String remove(int index);
    void set(int index, String element);
    int size();
    void clear();
}
