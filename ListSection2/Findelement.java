package ListSection2;

public class Findelement {


    public static void main(String[] args) {
        Findelement f = new Findelement();
        int[] arr = {1,2,2,2,2, 10, 15};
        int start = 0;
        // int result = f.single(arr, 2, start, arr.length - 1);
        //  System.out.println(result);
        //  int[] arr1 = {1, 1, 2, 2, 2};
        // int result1 = f.firstoccurance(arr1, 2, start, arr1.length - 1);
        // System.out.println(result1);
        int result = f.nearest(arr, 2 , start, arr.length - 1);
          System.out.println(result);

    }

    public int single(int[] arr, int element, int start, int end) {
        //int i=0;

        int mid = (start + end) / 2;
        if (end >= start) {
            if (arr[mid] == element) {
                return mid;
            } else if (arr[mid] < element) {
                return single(arr, element, mid + 1, arr.length - 1);
            } else {
                return single(arr, element, start, mid - 1);
            }
        } else
            return -1;

    }

    public int firstoccurance(int[] arr, int element, int start, int end) {
        int mid = (start + end) / 2;
        if (end >= start) {
            if (arr[mid] == element) {

                int firstIndex = mid;

                int indexNow = firstoccurance(arr, element, start, mid - 1);

                return indexNow == -1 ? firstIndex : indexNow;

            } else if (arr[mid] < element) {
                return firstoccurance(arr, element, mid + 1, arr.length - 1);
            } else {

                return firstoccurance(arr, element, start, mid - 1);
            }
        } else
            return -1;

    }

    public int nearest(int[] arr, int element, int start, int end) {

        if (arr[start] > element) {
            return arr[start];
        }
        else
         if (arr[end] < element) {
            return arr[end];
        } else if(arr[end]==element)
         {
             return arr[end];
         }
        else return nearest1(arr,element,start,end);
    }

    public int nearest1(int[] arr, int element, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            int before = 0, after = 0;
            if (arr[mid] == element) {
               return arr[mid];
            } else if (arr[mid] < element) {
                if(arr[mid+1]>element)
                {   before = arr[mid];
                    after = arr[mid + 1];
                    while (before != element && after != element)
                    {
                        before++;
                        after--;
                    }
                    return before == element ? arr[mid] : arr[mid+1];
                }
                else
                return nearest1(arr, element, mid, end);
            } else {
                return nearest1(arr, element,start, mid);
            }
        }
        return -1;
    }

}

/*

 if (mid - 1 >= start) {
         before = arr[mid - 1];
         after = arr[mid + 1];
         while (before != arr[mid] && after != arr[mid])
         {
         before++;
         after--;
         }
         }
         return before == arr[mid] ? arr[mid - 1] : arr[mid + 1]*/;