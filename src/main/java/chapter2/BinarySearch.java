package chapter2;

/**
 * first return left and last return right
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 15:31 2017/11/22
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,4,7,7,11,13,17,23,44,56,111,132,281};
        System.out.println(binarySearch(arr,11));
        System.out.println(binarySearch(arr,12));
        System.out.println(findFirstEqual(arr,7));
        System.out.println(findLastEqual(arr,7));
        System.out.println(findLastEqualOrSmaller(arr,8));
        System.out.println(findLastSmaller(arr,7));
        System.out.println(findFirstEqualOrLarger(arr,8));
    }

    public static int binarySearch(int[] arr, int key){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] == key){
                return mid;
            }else if(arr[mid] < key){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * @param arr
     * @param key
     * @return
     */
    public static int findFirstEqual(int[] arr, int key){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] >= key){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(left < arr.length && arr[left] == key){
            return left;
        }
        return -1;
    }

    public static int findLastEqual(int[] arr, int key){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] <= key){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if(right >= 0 && arr[right] == key){
            return right;
        }
        return -1;
    }

    public static int findLastEqualOrSmaller(int[] arr, int key){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] > key){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }

    public static int findLastSmaller(int[] arr, int key){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] >= key){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }

    public static int findFirstEqualOrLarger(int[] arr, int key){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] >= key){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

}
