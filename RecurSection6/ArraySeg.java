package RecurSection6;

public class ArraySeg {

    public static void main(String[] args)
    {
       // GenerateBinSequence(2);
        GenerateSubsets("ABC");
        //GenerateMArySequence(2, 10);
       // Combinations("ABC", 2);
       /* int arr[] = {1, 2, 3,4};
        int r = 2;
        int n = arr.length;
        printCombination(arr, n, r);*/

        //GenerateSubsets("ABC");
      //  Permutations("AAB", 2);
       //` Console.WriteLine("Hello World!");*/
    }

    static void printCombination(int arr[], int n, int r)
    {
        // A temporary array to store all combination one by one
        int data[]=new int[r];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, n, r, 0, data, 0);
    }


    static void combinationUtil(int arr[], int n, int r, int index,
                                int data[], int i)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            for (int j=0; j<r; j++)
                System.out.print(data[j]+" ");
            System.out.println("");
            return;
        }

        // When no more elements are there to put in data[]
        if (i >= n)
            return;

        // current is included, put next at next location
        data[index] = arr[i];
        combinationUtil(arr, n, r, index+1, data, i+1);

        // current is excluded, replace it with next (Note that
        // i+1 is passed, but index is not changed)
        combinationUtil(arr, n, r, index, data, i+1);
    }

    /*static void GenerateBinSequence(int n){
        if(n <= 0)
            return;
        int[] result = new int[n];
        GenerateBinSequence(result, 0);*/
   // }

  /*  static void GenerateBinSequence(int[] result, int current) {

        if (current == result.length) {
            // print array
            for(int i=0;i<2;i++) {
                System.out.print(result[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < 2; i++) {
            result[current] = i;
            GenerateBinSequence(result, current + 1);
        }
    }*/



    static void Combinations(String str, int m){
        int[] result = new int[m];
        Combinations(result, 0, m, str);
    }

    static void Combinations(int[] result, int current, int m,String str){

        if(current == result.length){
            // print array
           // PrintCombinations1(result, str);
            System.out.print(str.charAt(result[0]));
            System.out.print(str.charAt(result[1]));
            System.out.println();
            return;
        }

        for(int i = 0 ; i < str.length(); i ++){
            result[current] = i;
            Combinations(result, current +1, m, str);
        }
    }

    static void PrintCombinations1(int[] result, String str){
        for(int i = 0 ; i < result.length; i ++){
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }




    static void GenerateSubsets(String str){
        if(str.equals(null))
            return;
        int[] result = new int[str.length()];
        GenerateSubsets(result, 0, str);
    }

    static void GenerateSubsets(int[] result, int current, String str){

        if(current == result.length){
            // print array
            PrintSubsets(result, str);
            return;
        }

        for(int i = 0 ; i < 2; i ++){
            result[current] = i;
            GenerateSubsets(result, current +1, str);
        }
    }

    static void PrintSubsets(int[] result, String str){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(int i = 0 ; i< result.length; i ++){
            if(result[i] == 1)
                sb.append(str.charAt(i) +  " ");
        }
        sb.append("}");
        System.out.println(sb.toString());
    }



    static void Permutations(String str, int m){
        if(str.equals(null))
            return ;
        int[] result = new int[str.length()];
        Permutations(result, 0, str);

    }
    static void Permutations(int[] result, int current, String str){

        if(current == result.length){
            // print array
          //  PrintCombinations(result, str);
            System.out.print(str.charAt(result[0]));
            System.out.print(str.charAt(result[1]));
            System.out.print(str.charAt(result[2]));
            System.out.println();
            return;
        }

        for(int i = 0 ; i < str.length(); i ++){
            if(IsValid(result, current, i)){
                result[current] = i;
                Permutations(result, current +1,str);
            }
        }
    }

    static boolean IsValid(int[] result, int current, int num){
        for(int i = 0 ; i < current; i ++){
            if(result[i] == num)
                return false;
        }
        return true;
    }




    static void PrintCombinations(int[] result, String str){
        for(int i = 0 ; i < result.length; i++){
            System.out.print(str.charAt(i));
        }
        System.out.println();
        }




}
