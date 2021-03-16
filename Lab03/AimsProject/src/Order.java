public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;
    private static int qtyOrdered = 0;
    private static double total = 0;
    
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    public int getQtyOrdered(){
        return qtyOrdered;
    }

    public DigitalVideoDisc[] getItemOrdered(){
        return itemOrdered;
    }


    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered < MAX_NUMBERS_ORDERED){
            System.out.println("This disc has been added.");
            itemOrdered[qtyOrdered] = disc;
            total += disc.getCost();
            qtyOrdered ++;
        }
        else{
            System.out.println("The order is already full");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        if(itemOrdered == null){
            System.out.println("order is null");
        }
        else{
            for(int i = qtyOrdered - 1; i > -1 ; i--){
                if(itemOrdered[i] == disc){
                    total -= disc.getCost();
                    for(int j = i ; j<qtyOrdered - 2; j++){
                        itemOrdered[j] = itemOrdered[j+1];
                    }
                    itemOrdered[qtyOrdered-1]=null;
                    qtyOrdered -= 1;
                    System.out.println("Remove successfully");
                    break;
                }
                if(i == 0 && itemOrdered[i] != disc){
                    System.out.println("This disc is not in order");
                }
            }
        }
    }

    public double totalCost(){
        return Math.round(total*100)/100.0;
    }

    public static void main(String[] args){
        
    }
    
}
