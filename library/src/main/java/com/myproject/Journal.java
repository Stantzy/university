package com.myproject;

public class Journal implements Literature {
    private String title;
    private String journalTopic;
    private int releaseYear;

    public Journal(String journalTitle, String journalTopic, int releaseYear) {
        this.title = journalTitle;
        this.journalTopic = journalTopic;
        this.releaseYear = releaseYear;
    }
    
    public String getJournalTopic() {
        return journalTopic;
    }

    public void setJournalTopic(String journalTopic) {
        this.journalTopic = journalTopic;
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

