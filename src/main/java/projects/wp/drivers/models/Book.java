package projects.wp.drivers.models;

import org.openqa.selenium.WebElement;

public class Book {

    private WebElement title;
    private WebElement name;
    private WebElement description;
    private WebElement image;
    private WebElement publisher;
    private WebElement author;

    public Book(WebElement title, WebElement image) {
        this.title = title;
        this.image = image;
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getDescription() {
        return description;
    }

    public WebElement getImage() {
        return image;
    }

    public WebElement getPublisher() {
        return publisher;
    }

    public WebElement getAuthor() {
        return author;
    }
}
