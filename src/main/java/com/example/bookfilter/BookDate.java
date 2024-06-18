package com.example.bookfilter;

public class BookDate extends Book {
	 private String date;

	    // Constructor
	    public BookDate(Book book, String date) {
	        super(book.getId(), book.getTitle(), book.getSummary(), book.getPages(), book.getPublicationTimestamp(), book.getAutor());
	        this.date = date;
	    }

	    // Getter
	    public String getDate() {
	        return date;
	    }
}
