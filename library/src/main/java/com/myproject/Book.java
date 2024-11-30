package com.myproject;

public class Book implements Literature {
    private String title;
    private String bookAuthor;
    private String bookGenre;
    private int releaseYear;

    public Book(String bookTitle, String bookAuthor,
        String bookGenre, int releaseYear) {
            this.title = bookTitle;
            this.bookAuthor = bookAuthor;
            this.bookGenre = bookGenre;
            this.releaseYear = releaseYear;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }
    
    @Override
    public String getTitle() {
        return title;
    }
    
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}