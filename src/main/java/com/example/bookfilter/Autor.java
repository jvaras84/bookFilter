package com.example.bookfilter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Autor {
		private String name;
	    private String firstSurname;
	    private String bio;

	    @JsonCreator
	    public Autor(@JsonProperty("name") String name,
	                  @JsonProperty("firstSurname") String firstSurname,
	                  @JsonProperty("bio") String bio) {
	        this.name = name;
	        this.firstSurname = firstSurname;
	        this.bio = bio;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getFirstSurname() {
	        return firstSurname;
	    }

	    public String getBio() {
	        return bio;
	    }
}
