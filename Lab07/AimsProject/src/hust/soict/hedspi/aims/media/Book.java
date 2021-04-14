package hust.soict.hedspi.aims.media;


import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors = new ArrayList<>();

    public Book(String title) {
        super(title);
    }
    public Book(String title, String category, float cost, int id) {
        super(title, category, cost, id);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    
    public void addAuthor(String authorName) {
        boolean exists = false;
        for (int i=0; i<authors.size(); i++) {
            if(authors.get(i).equals(authorName)) {
                exists = true;
            }
        }
        if(exists) {
            System.out.println("Author " + authorName + " has already been in list of authors");
        }
        else {
            authors.add(authorName);
            System.out.println("Add author successfully");
        }
    }

    public void removeAuthor(String authorName) {
        if(authors.isEmpty()) {
            System.out.println("This author is not in list of authors");
        }
        else {
            for (int i=0; i<authors.size(); i++) {
                if(authors.get(i).equals(authorName)) {
                    authors.remove(authorName);
                    System.out.println("Remove author " + authorName + " successfully");
                    break;
                }
            }
        }
    }  
}