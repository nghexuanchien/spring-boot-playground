package springmvcdemo.model;

import java.util.List;

/**
 * @author chiennghe
 */
public class Student {
    private String name;
    private List<String> books;

    public List<String> getBooks() {
        return books;
    }
    public void setBooks(List<String> books) {
        this.books = books;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
