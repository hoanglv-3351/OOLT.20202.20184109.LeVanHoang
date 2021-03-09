public class Array {
    public static void main(String[] args){

        int []arr = new int [] {37,11,24,32,17,9,6,18,26, 2};

        System.out.print("original array: ");
        for(int i=0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        for(int i=0 ; i< arr.length ; i++){
            for(int j=i ; j<arr.length; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.print("Sorted array: ");
        for(int i=0 ; i<arr.length ; i++){
            System.out.print(arr[i] + " ");
        }

        int sum = 0;
        for(int i=0 ; i<arr.length ; i++){
            sum += arr[i];
        }
        double average = (double)sum/arr.length;
        
        System.out.println();
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);

    }
    
}
