package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    private int length;
    private String director;
    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }

    public Disc(String title) {
        super(title);
    }

    public Disc(String title, String category, float cost, int id, int length, String director) {
        super(title, category, cost, id);
        this.length = length;
        this.director = director;
    }

}
