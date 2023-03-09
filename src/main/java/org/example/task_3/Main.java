package org.example.task_3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 0;
        System.out.println("Print array size: (only integer):");
        try {
            size = scanner.nextInt();
        } catch (Exception e){
            System.out.println("Invalid array size");
        }
        int[] arrayList = new int[size];
        int step = 0;
//        ArrayList<Integer> arrayList = new ArrayList<Integer>(size);
        int i;
        while (step != size) {
            System.out.println("Enter number. \nPrint text to stop adding");
            try{
                i = scanner.nextInt();
                arrayList[step] = i;
                step++;
            } catch (Exception e) {
                break;
            }
        }
        System.out.println("Reversed array:");
        int[] reversedArrayList = Arrays.stream(arrayList).toArray();
        Collections.reverse(Arrays.asList(reversedArrayList));
        System.out.println(Arrays.toString(reversedArrayList));

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int o:reversedArrayList){
            hashMap.put(o,o);
        }
        hashMap.put(9,8);
        hashMap.put(5,2);
        hashMap.put(3,9);
        hashMap.put(7,4);
        System.out.println(hashMap);
        hashMap.remove(9, 8);
        System.out.println(hashMap);

        System.out.println(hashMap.containsKey(3));
        System.out.println(hashMap.containsKey(9));
        System.out.println(hashMap.get(3));
        System.out.println(hashMap);

        try {
            System.out.println(arrayList[arrayList.length]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Catched error: " + e);
            System.out.println("Причина проста як світ, індексація йде з 0 а не з 1, викликали цю помилку за допомогою довжини масиву.");
        }
    }

}
