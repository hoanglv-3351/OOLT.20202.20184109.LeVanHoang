import java.util.Scanner;

/*      *
       ***
      *****
     *******
    *********

    height = 5

*/

public class DrawTriangle{
    public static void main(String[] args){
        System.out.print("Nhap chieu cao cua tam giac: ");
        Scanner keyboard = new Scanner(System.in);
        int height = keyboard.nextInt();
        int i,j;
        for(i=0 ; i<height ; i++){
            for(j=0 ; j<2*height-1; j++){
                if(j<height-i-1 | j>height+i-1)
                    System.out.print(" ");
                else System.out.print("*");
            }
            System.out.println();
        }
        System.exit(0);
    }
}