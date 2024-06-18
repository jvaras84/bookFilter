package com.example.bookfilter;



import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
	  private int id;
	    private String title;
	    private String summary;
	    private int pages;
	    private Long publicationTimestamp;
	    private Autor autor;

	    @JsonCreator
	    public Book(@JsonProperty("id") int id,
	                @JsonProperty("title") String title,
	                @JsonProperty("summary") String summary,
	                @JsonProperty("pages") int pages,
	                @JsonProperty("publicationTimestamp") Long publicationTimestamp,
	                @JsonProperty("author") Autor autor) {
	        this.id = id;
	        this.title = title;
	        this.summary = summary;
	        this.pages = pages;
	        this.publicationTimestamp = publicationTimestamp;
	        this.autor = autor;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public String getSummary() {
	        return summary;
	    }

	    public int getPages() {
	        return pages;
	    }

	    public Long getPublicationTimestamp() {
	        return publicationTimestamp;
	    }

	    public Autor getAutor() {
	        return autor;
	    }
}
