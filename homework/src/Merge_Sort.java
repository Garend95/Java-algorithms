public class Merge_Sort {
    public static void main(String[] Args) {

        int array[] = {4,2,1,6,7,3,7,-4,0};
        Merge_Sort test = new Merge_Sort();
        test.MergeSort(array, 0, array.length - 1);

        int i = 0;
        while (i < array.length) {
            System.out.println(array[i]);
        }

    }

    private void MergeSort(int[] array, int startIndex, int endIndex){
        if (endIndex > startIndex){
            int middle = startIndex + (endIndex - startIndex)/2 ;   //sometimes the start index isn't 0
            MergeSort(array, startIndex, middle);
            MergeSort(array, middle + 1, endIndex);
            Merge(array, startIndex, middle, endIndex);
        }
    }

    private void Merge(int[] array, int startIndex, int middle, int endIndex){
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

        i = startIndex;  //index of the original array as we will begin to rewrite it
        int j = 0, k = 0; //indexes of the left and right arrays respectively

        while (j < leftArray.length || k < rightArray.length) {
            if (leftArray[j] < rightArray[k])
            {
                array[i] = leftArray[j];
                i++; j++;
            }
            else if (leftArray[j] >= rightArray[k])
            {
                array[i] = rightArray[k];
                i++; k++;
            }
            else if (j == leftArray.length - 1) array[i] = rightArray[k]; // if the left array has been fully used
            else if (k == rightArray.length - 1) array[i] = leftArray[j]; // if the right array has been fully used
        }
    }
}
