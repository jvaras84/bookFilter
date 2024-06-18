package com.example.bookfilter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.*;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		 ObjectMapper mapper = new ObjectMapper();
	        List<Book> books = null;

	        try (InputStream inputStream = Main.class.getResourceAsStream("/books.json")) {
	            if (inputStream == null) {
	                throw new IOException("Error leyendo el archivo de libros: books.json");
	            }
	            books = mapper.readValue(inputStream, new TypeReference<List<Book>>(){});
	        } catch (IOException e) {
	            System.err.println("Error leyendo el archivo de libros: books.json: " + e.getMessage());
	            return;
	        }

	        // Usar la función filter
	        BookFilter bookFilter = new BookFilter();
	        Optional<BookDate> result = bookFilter.filter("born", books);

	        
	        // Mostrar el resultado
            result.ifPresent(bookDate -> {
                System.out.println("Libro encontrado con caracter: " + bookDate.getTitle());
                System.out.println("Fecha de publicación: " + bookDate.getDate());
            });

	        
	        // Mostrar la lista ordenada
            System.out.println("Lista de libros ordenada:");
            books.forEach(book -> System.out.println(
                    book.getTitle() + " - " + 
                    (book.getPublicationTimestamp() != null ? new java.util.Date(book.getPublicationTimestamp() * 1000) : "Sin fecha de publicación") + 
                    " - " + book.getAutor().getBio().length() + " caracteres en la biografía"
            ));
 
	}

}
