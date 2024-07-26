package Java.basics;
 
import java.security.Key;
import java.util.*;

public class CollectionsCheck {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // sc.close();

        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(89);
        // list.add(71);
        // list.addFirst(47);
        // System.out.println(list);

        // ArrayList<Integer> nlist = new ArrayList<>();
        // nlist.add(99);
        // System.out.println(nlist);
        // nlist.addAll(list);
        // System.out.println(nlist);

        // int[] arr = {1, 2, 3, 4};
        // for(int ele: arr){
        //     list.add(ele);
        // }
        // System.err.println(list);

        // list.remove(2);
        // list.reversed();
        // list.sort(null);
        // System.out.println(list);

        // LinkedList<Integer> ll = new LinkedList<>();
        // ll.addAll(list);
        // System.out.println(ll);
        // System.out.println(ll.iterator());
        // System.out.println(ll.hashCode());
        // System.out.println(list.hashCode());
        // list.removeFirst();
        // System.out.println(list.hashCode());

        // System.out.println(list.reversed());


        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        System.out.println(hm);
        hm.put("Mihiresh", 89);
        hm.put("Joshi", 4);
        hm.put("Deadpool", 69);
        hm.put("Wolverine", 24);
        System.out.println(hm);
        for(Map.Entry m: hm.entrySet()){
            System.out.println(m.getKey() + " " + m.getValue());
        }
        List<Map.Entry<String, Integer>> nl = new ArrayList<>(hm.entrySet());
        System.out.println(nl.get(3));
    
        Collections.sort(nl, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b){
                return a.getValue().compareTo(b.getValue());
            }
        });

        System.out.println("NL here>>>> "+nl);

        LinkedHashMap<String, Integer> lm = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> e: nl){
            lm.put(e.getKey(), e.getValue());
        }
        System.out.println(lm);
        
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.putAll(hm);
        System.out.println(tm);
        System.out.println(tm.hashCode());
        System.out.println(hm.hashCode());

    }
}
