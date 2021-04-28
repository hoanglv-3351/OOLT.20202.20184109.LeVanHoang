package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost, int id, int length, String director) {
        super(title, category, cost, id, length, director);
    }
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public int compareTo(Media o) {
        if(o instanceof DigitalVideoDisc) {
            DigitalVideoDisc dvd = (DigitalVideoDisc) o;
            if(this.getCost() > dvd.getCost()) {
                return 1;
            }
            else if(this.getCost() == dvd.getCost()) {
                if(this.getLength() > dvd.getLength()) {
                    return 1;
                }
                else if(this.getLength() == dvd.getLength()) {
                    if(this.getTitle().compareTo(dvd.getTitle()) > 0) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

}