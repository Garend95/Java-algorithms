public class Merge_Sort {
    public static void main(String[] Args) {

        int array[] = {4,2,1,6,7,3,7,-4,0};
        Merge_Sort test = new Merge_Sort();
        test.MergeSort(array, 0, array.length - 1);

        int i = 0;
        while (i < array.length) {
            System.out.print(array[i] + " ");   //prints the sorted elements
            i++;
        }

    }

        private void MergeSort(int[] array, int startIndex, int endIndex){
            if (endIndex > startIndex){
                int middle = startIndex + (endIndex - startIndex)/2 ;   //sometimes the start index isn't 0
                MergeSort(array, startIndex, middle);
                MergeSort(array, middle + 1, endIndex);
                Merge(array, startIndex, middle, endIndex); // this function will merge from the bottom (where only single elements lie) to the top
        }
    }

    private void Merge(int[] array, int startIndex, int middle, int endIndex){
        int leftArray[] = new int[middle - startIndex + 1];    //these arrays are temporary so that we would not
        int rightArray[] = new int[endIndex - middle]; //have to replace the original positions

        int i = startIndex, j = 0, k = 0;
        while (i <= middle) {
            leftArray[j] = array[i];
            i++; j++;
        }

        while (i <= endIndex) {
            rightArray[k] = array[i];
            i++; k++;
        }


        i = startIndex;  //index of the original array as we will begin to rewrite it
        j = 0; //index of the left array
        k = 0; //index of the right array


        while (j < leftArray.length && k < rightArray.length) {
            if (leftArray[j] < rightArray[k]) {
                array[i] = leftArray[j];
                i++;
                j++;

            } else {
                array[i] = rightArray[k];
                i++;
                k++;
            }
        }

        while (j < leftArray.length) {  //in case one of the arrays finishes faster than the other
            array[i] = leftArray[j];
            i++;
            j++;
        }

        while (i < rightArray.length) {
            array[i] = leftArray[k];
            i++;
            k++;
        }
    }
}
