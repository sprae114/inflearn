package hello.thymeleaf.listbindingexample;

import lombok.Data;

@Data
public class Book {

    private long id;

    private String title;

    private String author;

    private Boolean selected;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }
}
