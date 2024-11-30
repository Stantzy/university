package com.myproject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Library {
    private final List<Literature> literatureList;

    public Library() {
        this.literatureList = new ArrayList<>();
    };
    
    public void sortList() {
        literatureList.sort(Comparator.comparing(Literature::getReleaseYear));
    }

    public void addLiterature(Literature literature) {
        this.literatureList.add(literature);
    }
    
    public void removeLiterature(Literature literature) {
        if(!literatureList.isEmpty()) {
            this.literatureList.remove(literature);
        }
    }

    public List<Literature> getLiteratureByYears(int minYear, int maxYear) {
        List<Literature> requestedLiterature = new ArrayList<>();

        for(Literature literature: this.literatureList) {
            Literature tmpLiterature = literature;
            if(tmpLiterature.getReleaseYear() <= maxYear && tmpLiterature.getReleaseYear() >= minYear) {
                requestedLiterature.add(tmpLiterature);
            }
        }

        return requestedLiterature;
    }

    public List<Book> getAllBooks() {
        List<Book> allBooks = new ArrayList<>();
        for(Literature literature: this.literatureList) {
            Literature tmpLiterature = literature;
            if(literature instanceof Book) {
                allBooks.add((Book)tmpLiterature);
            }
        }
        return allBooks;
    }

    public List<Journal> getAllJournals() {
        List<Journal> allJournals = new ArrayList<>();
        for(Literature literature: this.literatureList) {
            Literature tmpLiterature = literature;
            if(literature instanceof Journal) {
                allJournals.add((Journal)tmpLiterature);
            }
        }
        return allJournals;
    }
}


