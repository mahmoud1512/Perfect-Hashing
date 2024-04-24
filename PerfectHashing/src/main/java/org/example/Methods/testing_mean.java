package org.example.Methods;

public class testing_mean {

    public static void main(String[] args) {
        NSquareSpace<Integer>x=new NSquareSpace<>(32);

        double searchingtimeN2=0;
        double inserttimeN2=0;
        for (int i = 0; i < 1000; i++) {
            long startTimeN2 = System.nanoTime();
            boolean res=x.insert(i);
            long endTimeN2 = System.nanoTime();
            inserttimeN2+=endTimeN2+startTimeN2;
        }
        for (int i = 0; i < 5000; i++) {
            long startTimeN2 = System.nanoTime();
            boolean res=x.search(i);
            long endTimeN2 = System.nanoTime();
            searchingtimeN2+=endTimeN2+startTimeN2;
        }
       // System.out.println("averge insertion time in n square is"+inserttimeN2/1000.0+"\n averge time to search is "+searchingtimeN2/5000.0);

        NSpace<Integer>Y=new NSpace<>(32,10);

        double searchingtimeN=0;
        double inserttimeN=0;
        for (int i = 0; i < 1000; i++) {
            long startTimeN = System.nanoTime();
            boolean res=Y.insert(i);
            long endTimeN = System.nanoTime();
            inserttimeN+=endTimeN+startTimeN;
        }
        for (int i = 0; i < 5000; i++) {
            long startTimeN = System.nanoTime();
            boolean res=x.search(i);
            long endTimeN = System.nanoTime();
            searchingtimeN+=endTimeN+startTimeN;
        }
        System.out.println("averge insertion time in n space is"+inserttimeN/1000.0+"\n averge time to search is "+searchingtimeN/5000.0);
    }
}
