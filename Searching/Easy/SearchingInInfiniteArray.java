public class SearchingInInfiniteArray {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 7, 8, 10, 11, 12, 15, 20, 23, 30, 32};
        int target = 15;
        int result = findInRange(arr, target);
        System.out.println(result);
    }
    public static int findInRange(int[] arr, int target) {
        // find the range
        int start = 0;
        int end = 1;

        while(arr[end] < target) {
            // keep doubling
            int temp = end + 1;
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return binarySearch(arr, target, start, end);
    }
    public static int binarySearch(int[] arr, int target, int start, int end) {

        while(start <= end) {
            int mid = start + (end-start)/2;

            if(target == arr[mid]) {
                return mid;
            } else if(target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}

