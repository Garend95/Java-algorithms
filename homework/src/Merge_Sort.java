public class Merge_Sort {
    public static void main(String[] Args) {

        int array[] = {4,2,1,6,7,3,7,-4,0};


    }

    public void MergeSort(int[] array, int startIndex, int endIndex){
        if (endIndex > startIndex){
            int middle = startIndex + (endIndex - startIndex)/2 ;
            MergeSort(array, startIndex, middle);
            MergeSort(array, middle + 1, endIndex);

        }
    }

    public void Merge(int[] array, int startIndex, int middle, int endIndex){

    }
}
