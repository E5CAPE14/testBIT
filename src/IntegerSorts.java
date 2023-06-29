import java.util.Arrays;

public class IntegerSorts {

    public static void Sort(int[] A,int p,int r){

        if(p < r){
            int q;
            /*
                Округление в большую сторону.
             */
            if(((p + r) / 2) % 2 == 0){
                q=(int) (double) ((p + r) / 2);
            } else {
                q=(int) (double) ((p + r) / 2)+1;
            }

            /*
                Мы привязанны к индексам , отсчет индексов с 0;
            */
            p = p - 1;

            Arrays.sort(A,p,q);
            Arrays.sort(A,q+1,r);
            merge(A,p,q,r);
        }
    }

    private static void merge(int[] A,int p,int q,int r){
        int[] mass1 = new int[q - p + 1];
        int[] mass2 = new int[r - q + 1];
        /*
            Краевые верхние значения, которые не должны попасть в результирующий массив.
         */
        mass1[mass1.length - 1] = Integer.MAX_VALUE;
        mass2[mass2.length - 1] = Integer.MAX_VALUE;
        /*
            Копируем
         */
        System.arraycopy(A,p,mass1,0,q - p);
        System.arraycopy(A,q,mass2,0,r - q);
        /*
            Запись значений в массив А
         */
        int i = 0,j = 0,l1 = p;
        while (l1 < r ) {
            if (mass1[i] <= mass2[j]) {
                A[l1] = mass1[i];
                i++;
            } else {
                A[l1] = mass2[j];
                j++;
            }
            l1++;
        }
    }


}
