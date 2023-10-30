public class Driver {
    public static void main(String[] args) {
        int[] x = new int[]{5,7,3,8,43,2,6,8,4,7,432,45,673,42387,823432,658,3,1};
        printArray(x);
        sortMedia(x);
        printArray(x);
        System.out.println(binSearch(x, 3));

        String a = "a";
        String b = "b";
        System.out.println(a.compareTo(b));

    }

    public static void sortMedia(int[] x) {
        for (int i = 1; i < x.length; i++) {
            for (int j = 0; j < x.length - i; j++) {
                if (x[j] > x[j+1]) {
                    int l = x[j];
                    x[j] = x[j+1];
                    x[j+1] = l;
                }
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + "; ");
        }
        System.out.println();
    }

    public static int binSearch(int[] arr, int searchFor) {
        int min = 0;
        int max = arr.length - 1;
        while(min <= max) {
            int mid = (min + max) / 2;
            if (arr[mid] == searchFor) {
                return mid;
            }
            if (searchFor < arr[mid]) {
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }
        }
        return -1;
    }
}
