import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] A = new int[]{5,2,4,6,1,3,2,6};

        IntegerSorts.Sort(A,1,A.length);

        Arrays.stream(A).boxed().forEach(x -> {
            System.out.print(x + " ");
        });
    }
}