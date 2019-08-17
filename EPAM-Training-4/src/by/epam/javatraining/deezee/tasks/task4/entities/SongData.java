package by.epam.javatraining.deezee.tasks.task4.entities;

import by.epam.javatraining.deezee.tasks.task4.enums.Genre;

public class SongData {
    private String title;
    private String artist;
    private int duration;
    private Genre genre;

    public SongData(String title, String artist, int duration, Genre genre) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return new StringBuffer(this.title).append("; ")
                .append(this.artist).append("; ")
                .append(this.duration).append("; ")
                .append(this.genre)
                .toString();
    }

    /*@Override
    public int hashCode() {
        //return this.id;
        return 0;
    }*/

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof SongData)) {
            return false;
        }

        SongData song = (SongData)obj;

        return this.title.equals(song.title) && this.artist.equals(song.artist) && this.getDuration() == song.duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}