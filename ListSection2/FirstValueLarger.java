package ListSection2;/* Find First Value larger than K in a sorted array in recursive manner
This program helps in finding the first value larger than k.
 */

public class FirstValueLarger {

    public static void main(String[] args) {
        FirstValueLarger f = new FirstValueLarger();
        int[] arr1 = {2,2,2,2,2,2,5,7,9};
        int[] arr2 = {10, 15, 18, 30, 40};
        int[] arr3 = {9, 17, 20, 25, 30};
        int[] arr4 = {1,1,1,1,1,1,1,1,1};
        int[] arr5 = {1,1,1,2,2,2,3,3,3,4,4,4,60};
        int[] arr6 = {};
        int[] arr7 = {2, 3, 4, 18, 19};

        int[][] inputs = {arr1, arr2, arr3, arr4, arr5, arr6, arr7};

        int[] elementsSearch = {2, -4, 18, 2, 60, 60, 7};
        int[] resultsShouldBe = {5, 10, 20, -1, -1, -1, 18};
        for(int i=0; i<inputs.length; i++) {
            int firstGreater = f.first(inputs[i], elementsSearch[i], 0, inputs[i].length - 1); //calls the
            // first method with array, element larger and start and end values of array
            if(firstGreater == resultsShouldBe[i]) {
                System.out.println("Yes!! For " + i + " input code is working");
            } else {
                System.out.println("No!! For " + i + " input code is not  working");
            }
        }
    }


    public int first(int[] arr, int element, int start, int end) {
//this method tests the very basic condition and then passes the array to method firstLarger
        if(end==-1)// if array is empty
        {return -1;}
        if (arr[start] > element) {
            return (arr[start]);
        } else if (arr[end] <= element) {
            return -1;
        } else {
            return this.firstLarger(arr, element, start, arr.length - 1);
        }
    }

    public int firstLarger(int[] arr, int element, int start, int end) {
        if(start > end) {
            return -1;
        }
        if(start == end) {
            return arr[start];
        }
        int mid = (start + end) / 2;
        if (arr[mid] <= element) {
            return  firstLarger(arr, element, mid + 1, end);
        } else {
            return firstLarger(arr, element, start, mid);
        }
    }

}
