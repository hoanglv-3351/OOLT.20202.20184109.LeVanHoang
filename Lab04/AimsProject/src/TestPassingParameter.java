public class TestPassingParameter {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    // public static void swap(Object o1, Object o2){
    //     Object tmp = o1;
    //     o1 = o2;
    //     o2 = tmp;
    // }

    public static void swap(Object o1, Object o2){
        DigitalVideoDisc d1 = (DigitalVideoDisc)o1;
        DigitalVideoDisc d2 = (DigitalVideoDisc)o2;
        if(d1 != null) {
            if(d2 != null) {
                String tmp = d1.getTitle();
                d1.setTitle(d2.getTitle());
                d2.setTitle(tmp);
            }
            else{
                System.out.println("object 2 is not a type of DVD");
            }
        }
        else {
            System.out.println("object 1 is not a type of DVD");
        }
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }


}
