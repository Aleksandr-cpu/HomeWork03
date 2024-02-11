package list;

import list.core.GBList;
import list.core.lists.LinkList;

public class LinkListMain {
    public static void main(String[] args) {
        GBList<Integer> lst = new LinkList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
        lst.add(5);
        lst.add(6);
        lst.add(67);

        System.out.println(lst);

        lst.addLast(34);

        System.out.println(lst);

        System.out.println(lst.size());

        System.out.println("index[0] = " + lst.get(0));
        System.out.println("index[7] = " + lst.get(7));

        lst.remove(4);
        System.out.println(lst);
    }
}
