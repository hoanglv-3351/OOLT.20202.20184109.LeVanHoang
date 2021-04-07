package hust.soict.hedspi.aims.media;

public class Media {
    private String title;
    private String category;
    private float cost;
    private int id;
    
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
    public float getCost() {
        return (float) (Math.round(cost*100)/100.0);

    }
    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean search(String name) {
        String nameList[] = name.toLowerCase().split("\\s++");
        for (String str : nameList) {
            if(getTitle().toLowerCase().contains(str) == false){
                return false;
            }
        }
        return true;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
}
