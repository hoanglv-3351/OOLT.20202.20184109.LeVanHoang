package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Media implements Playable{

    private String artist;
    ArrayList<Track> tracks = new ArrayList<>(); 

    public CompactDisc(String title) {
        super(title);
    }
    public CompactDisc(String title, String category, float cost, int id, String artist) {
        super(title, category, cost, id);
        this.artist = artist;
    }
    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        boolean flag = false;
        for (Track tmp : tracks) {
            if (tmp.equals(track)) {
                flag = true;
            }
        }
        if(flag == true) {
            System.out.println("Track " + track.getTitle() + " has been already in list of track");
        }
        else {
            tracks.add(track);
            System.out.println("Add new track successfully");
        }
    }

    public void removeTrack(Track track) {
        boolean flag = false;
        for (Track tmp : tracks) {
            if(tmp.equals(track)) {
                tracks.remove(track);
                flag = true;
            }
        }
        if(flag == true) {
            System.out.println("Remove " + track.getTitle() + " successfully");
        }
        else {
            System.out.println("Track " + track.getTitle() + " is not in list of tracks");
        }
    }

    public int getLength() {
        int length = 0;
        for(Track track: tracks) {
            length += track.getLength();
        }
        return length;
    }
    @Override
    public void play() {
        for(Track track: tracks) {
            track.play();
        }
    }
    @Override
    public int compareTo(Media o) {
        if(o instanceof CompactDisc){
            if(this.tracks.size() > ((CompactDisc) o).tracks.size())
                return 1;
            else if (this.tracks.size() < ((CompactDisc) o).tracks.size())
                return -1;
            else{
                if(this.getLength() > ((CompactDisc) o).getLength())
                    return 1;
                else if (this.getLength() > ((CompactDisc) o).getLength())
                    return -1;
                else
                    return super.compareTo(o);
            }
        }
        else
            return super.compareTo(o);
    }
}
