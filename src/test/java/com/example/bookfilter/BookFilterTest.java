package com.example.bookfilter;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class BookFilterTest {
	 @Test
	    public void testFilter() {
	        List<Book> books = Arrays.asList(
	            new Book(1, "The Hunger Games", "Sixteen-year-old Katniss Everdeen...", 374, null, new Autor("Suzanne", "Collins", "Since 1991, Suzanne Collins...")),
	            new Book(2, "Harry Potter and the Sorcerer's Stone", "Harry Potter has no idea...", 309, 867308140L, new Autor("J.K.", "Rowling", "Although she writes under...")),
	            new Book(3, "The Help", "Twenty-two-year-old Skeeter...", 464, 1234252540L, new Autor("Kathryn", "Stockett", "Kathryn Stockett was born..."))
	        );

	        BookFilter bookFilter = new BookFilter();
	        Optional<BookDate> result = bookFilter.filter("Potter", books);

	        assertTrue(result.isPresent());
	        assertEquals("Harry Potter and the Sorcerer's Stone", result.get().getTitle());
	        assertEquals("07-10-1997", result.get().getDate());
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testFilterWithNullInput() {
	        BookFilter bookFilter = new BookFilter();
	        bookFilter.filter(null, null);
	    }
}
