package list;

import list.core.lists.GBArrayList;
import list.core.GBList;

public class ArrayListMain {
    public static void main(String[] args) {
        GBList<Integer> list = new GBArrayList<>();
        list.add(3);
        list.add(5);
        list.add(6);
        System.out.println(list);
        System.out.println(list.get(1));
        list.remove(0);
        System.out.println(list);
        System.out.println(list.size());
    }
}
