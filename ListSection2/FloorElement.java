package ListSection2;

/*Find Floor of value X in a sorted array*/
public class FloorElement {

    public static void main(String[] args) {
        FloorElement f = new FloorElement();
        int[] arr0 = {6,9};
        int[] arr1 = {2,2,2,2,2,2,5,7,9};
        int[] arr2 = {10, 15, 18, 30, 40};
        int[] arr3 = {9, 17, 20, 25, 30};
        int[] arr4 = {1,1,1,1,1,1,1,1,1};
        int[] arr5 = {1,1,1,2,2,2,3,3,3,4,4,4,60};
        int[] arr6 = {1,1,1,2,2,2,3,3,3,4,4,4,70};
        int[] arr7 = {2, 3, 4, 18, 19};
        int[] ar8 = {1,1,1,2,2,2,3,3,3,4,4,4,70,100};

        int[][] inputs = { arr0, arr1, arr2, arr3, arr4, arr5, arr6, arr7, ar8};

        int[] elementsSearch = {7, 2, -4, 18, 21, 60, 69, 4, 150};
        int[] resultsShouldBe = {6, 2, -1, 17, 1, 60, 4, 4, 100};
        for(int i=0; i<inputs.length; i++) {
            int firstGreater =  f.floorCall(inputs[i], elementsSearch[i], 0, inputs[i].length - 1); //calls the
            // floorCall method with array, element,start and end values of array
            if(firstGreater == resultsShouldBe[i]) {
                System.out.println("Yes!! For " + i + " input code is working");
            } else {
                System.out.println("No!! For " + i + " input code is not  working");
            }
        }
    }

    public int floorCall(int[] arr, int element, int start, int end) {
        if(end==-1)// if array is empty
        {return -1;}
        if (arr[start] > element) {
            return -1;
        } else if (arr[end] <= element) {
            return arr[end];
        } else {
            return this.floor(arr, element, start, arr.length - 1); //floor method is called
        }
    }

    public int floor(int[] arr, int element, int start, int end) {
        if(start > end) {
            return -1;
        }
        if(start == end) {
            return arr[start];
        }
        if (arr[end] <= element) {
            return arr[end];
        }
        int mid = (start + end) / 2;
        if(arr[mid]==element) {
            return arr[mid];
        } else {
            if (arr[mid] < element) {
                if (arr[mid + 1] > element) {
                    return arr[mid];
                } else {
                    return floor(arr, element, mid, end);
                }
            } else {
                return floor(arr, element, start, mid - 1);
            }
        }
    }
}
