package com.example.bookfilter;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class BookFilter {
	public Optional<BookDate> filter(String filter, List<Book> books) {
		
        if (filter == null || books == null) {
            throw new IllegalArgumentException("Filter and books list must not be null");
        }
        // Paso 1: Escribir por pantalla los libros que no tengan fecha de publicación
        books.stream()
                .filter(book -> book.getPublicationTimestamp() == null)
                .forEach(book -> System.out.println("Libro sin fecha de publicación: " + book.getTitle()));

        // Paso 2: Buscar libros que contengan la cadena en nombre, resumen o biografía del autor
        List<Book> matchingBooks = books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(filter.toLowerCase()) ||
                        book.getSummary().toLowerCase().contains(filter.toLowerCase()) ||
                        book.getAutor().getBio().toLowerCase().contains(filter.toLowerCase()))
                .collect(Collectors.toList());

        // Ordenar los libros encontrados por fecha de publicación mas reciente
        matchingBooks.sort((b1, b2) -> {
            if (b1.getPublicationTimestamp() == null && b2.getPublicationTimestamp() == null) {
                return 0;
            } else if (b1.getPublicationTimestamp() == null) {
                return 1;
            } else if (b2.getPublicationTimestamp() == null) {
                return -1;
            } else {
                return b2.getPublicationTimestamp().compareTo(b1.getPublicationTimestamp());
            }
        });

        // Obtener el libro más reciente (si existe)
        Optional<Book> mostRecentBook = matchingBooks.stream().findFirst();
        BookDate bookDate=null;
        if (mostRecentBook.isPresent()) {
            Book book = mostRecentBook.get();
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            String formattedDate = book.getPublicationTimestamp() != null ? sdf.format(new Date(book.getPublicationTimestamp() * 1000)) : null;
           
            bookDate = new BookDate(book,formattedDate );
           
            
        }

        // Paso 3: Ordenar la lista original de libros agrupada por fecha de publicación y luego por biografía del autor más corta
        books.sort(Comparator
                .comparing((Book book) -> book.getPublicationTimestamp() == null ? Long.MAX_VALUE : book.getPublicationTimestamp())
                .thenComparingInt(book -> book.getAutor().getBio().length()));

        return Optional.of(bookDate);
    }

}
