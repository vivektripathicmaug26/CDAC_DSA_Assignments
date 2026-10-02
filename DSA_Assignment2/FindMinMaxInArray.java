public class FindMinMaxInArray {

    public static void main(String[] args) {

        int[] num = {-10};

        int max = num[0];
        int min = num[0];

        for (int i = 1; i < num.length; i++) {

            if (num[i] > max) {
                max = num[i];
            }

            if (num[i] < min) {
                min = num[i];
            }
        }

        System.out.println(max + " is greater in all");
        System.out.println(min + " is smallest in all");
    }
}