package hust.soict.hedspi.aims.media;

public abstract class Media {
    private String title;
    private String category;
    private float cost;
    private int id;
    
    public Media(String title) {
        this.title = title;
    }
    public Media(String title, String category, float cost, int id) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }
    
    public float getCost() {
        return (float) (Math.round(cost*100)/100.0);
    }

    public int getId() {
        return id;
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
}
