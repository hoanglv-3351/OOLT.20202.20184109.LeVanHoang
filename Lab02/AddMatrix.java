public class AddMatrix {
    public static void main(String[] args){
        int [][]arrA = {{1,2,3,10},
                        {4,5,6,20},
                        {7,8,9,30} };

        int [][]arrB = {{2,3,4,11}, 
                        {5,6,7,22},
                        {8,9,10,33}};

        int [][]arrC = new int[3][4];
        

       
        
        for(int i = 0 ; i < 3 ; i++){
            for(int j=0 ; j<4 ; j++){
                arrC[i][j] = arrA[i][j] + arrB[i][j];
            }
        }

        System.out.println("arrA");
        for(int i = 0 ; i < 3 ; i++){
            for(int j=0 ; j<4 ; j++){
                System.out.printf("%4d", arrA[i][j]);
            }
            System.out.println();
        }
        System.out.println("arrB");
        for(int i = 0 ; i < 3 ; i++){
            for(int j=0 ; j<4 ; j++){
                System.out.printf("%4d", arrB[i][j]);
            }
            System.out.println();
        }
        System.out.println("arrC = arrA + arrB");
        for(int i = 0 ; i < 3 ; i++){
            for(int j=0 ; j<4 ; j++){
                System.out.printf("%4d", arrC[i][j]);
            }
            System.out.println();
        }

    }
}
