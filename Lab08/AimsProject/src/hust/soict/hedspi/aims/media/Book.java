package hust.soict.hedspi.aims.media;

import java.util.*;



public class Book extends Media{
    private List<String> authors = new ArrayList<>();
    private String content;
    public List<String>contentTokens =  new ArrayList<String>();
    public Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();

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
    @Override
    public int compareTo(Media o) {
        return super.compareTo(o);
    }

    @Override
    public String toString() {
        String string = "";
        string += "Id: " + super.getId() + "\n";
        string += "Title: "	+ super.getTitle() + "\n";
        string += "Category: " + super.getCategory() + "\n";
        string += "Cost: " + super.getCost()+ "\n";
        string += "Author: " + getAuthors()+ "\n";
        string += "Number of tokens: " + contentTokens.size() + "\n";
        string += "Work frequency \t" + "Word" + "\n";
        for(Map.Entry<String, Integer> entry: wordFrequency.entrySet()) {
            string += entry.getKey() + " - "+ entry.getValue() + "\n";
        }
        return string;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        processContent();
    }
    private void processContent() {
        content = content.replace('.',' ');
        content = content.replace(',', ' ');
        contentTokens.addAll(Arrays.asList(content.split("\\s+")));
        Collections.sort(contentTokens);
        Iterator<String> iterator = contentTokens.iterator();
        while(iterator.hasNext()) {
            String string = iterator.next();
            if (wordFrequency.containsKey(string) == false) {
                wordFrequency.put(string, 1);
            }
            else {
                int numOfToken = wordFrequency.get(string);
                numOfToken++;
                wordFrequency.put(string, numOfToken);
            }
        }
    }
}