public class Main {
    public static void main(String[] args) {
        OrderedList<Integer> orderedList = new OrderedList<>(false);
        orderedList.add(5);
        orderedList.add(2);
        orderedList.add(8);
        orderedList.add(3);

        System.out.println(orderedList.getAll());
        System.out.println(orderedList.count());
        orderedList.delete(5);
        System.out.println(orderedList.getAll());
        System.out.println(orderedList.find(3));
        System.out.println(orderedList.find(5));
    }
}
