public class Merge_Sort {
    public static void main(String[] Args) {

        int array[] = {4,2,1,6,7,3,7,-4,0};


    }

    public void MergeSort(int[] array, int startIndex, int endIndex){
        if (endIndex > startIndex){
            int middle = startIndex + (endIndex - startIndex)/2 ;   //sometimes the start index isn't 0
            MergeSort(array, startIndex, middle);
            MergeSort(array, middle + 1, endIndex);

        }
    }

    public void Merge(int[] array, int startIndex, int middle, int endIndex){
        int leftArray[] = new int[middle - startIndex];    //these arrays are temporary so that we would not
        int rightArray[] = new int[endIndex - middle + 1]; //have to replace the original positions

        int i = 0;
        while (i < middle - startIndex) {
            leftArray[i] = array[i];
            i++;
        }
        while (i < array.length) {
            rightArray[i] = array[i];
            i++;
        }

        i = 0;  //index of the original array as we will begin to rewrite it
        int j = 0, k = 0; //indexes of the left and right arrays respectively

    }
}
