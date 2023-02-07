public class Main {
public static void main(String [] args){
    int array[]= {3,6,1,8,12,4,7};
    int i = array.length;
    System.out.println("Unsorted Array");
    for(int x = 0;  x < i ; x++){
        System.out.print(array[x]+",");
    }
    System.out.println();
    System.out.println("Calling heapsort");
    heapSort(array,i);
    System.out.println("Sorted Array");
    for(int x = 0;  x < i ; x++){
        System.out.print(array[x]+",");
    }

}// HEAPSORT(A)
    // 1 BUILD-MAX-HEAP(A)
    //2 for i ← length[A] downto 2
    //3 do exchange A[1] ↔ A[i]
    //4 heap-size[ A] ← heap-size[A] − 1
    //5 MAX-HEAPIFY(A,1)
public static void heapSort(int [] arr,int n){

buildMaxHeap(arr,n);
for(int j = n/2-1 ;j >= 0; j--){
    int temp = arr[0];
    arr[0] = arr[j];
    arr[j] = temp;

maxHeapify(arr,j,0);
}


}
//MAX-HEAPIFY(A,i)

//1 l←LEFT(i)
//2 r←RIGHT(i)
//3 if l ≤ heap-size[A] and A[l] > A[i]
//4 then largest ← l
//5 else largest ← i
//6 if r ≤ heap-size[A] and A[r] > A[largest]
//7 then largest ← r
//8 if largest ̸= i
//9 then exchange A[i] ↔ A[largest]
//10 MAX-HEAPIFY(A, largest)

    public static void maxHeapify(int arr[], int i,int n){

        int largest;
        int l = left(i);
        int r = right(i);
        if(l <= arr.length && arr[l] > arr[i]) {
            largest = l;
        }
        else{
            largest = i;
        }
        if(r <= arr.length && arr[r] > arr[i]){
         largest = r;
        }
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr,i,largest);
        }
    }
    //BUILD-MAX-HEAP(A)
    //1 heap-size[A] ← length[A]
    //2 for i ← ⌊length[A]/2⌋ downto 1
    //3 do MAX-HEAPIFY(A,i)
    public static void buildMaxHeap(int arr[],int n){

for (int i = n / 2 - 1; i >= 0; i--){
       maxHeapify(arr, n, i);

    }}
    public static int left(int i){
        return 2*i;
    }
    public static int right(int i){
        return 2*i+1;
    }
    public static int parent(int i){
        return i/2;
    }
}
