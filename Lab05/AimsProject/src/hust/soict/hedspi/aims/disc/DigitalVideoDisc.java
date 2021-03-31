package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private double cost;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public double getCost() {
        return Math.round(cost*100)/100.0;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public DigitalVideoDisc(String title){
        super();
        this.title = title;
    }

    public boolean search(String name) {
        String nameList[] = name.toLowerCase().split("\\s++");
        for (String str : nameList) {
            if(title.toLowerCase().contains(str) == false){
                return false;
            }
        }
        return true;
    }
}