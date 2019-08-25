package by.epam.javatraining.deezee.tasks.task4.entities;

import by.epam.javatraining.deezee.tasks.task4.enums.Genre;
import by.epam.javatraining.deezee.tasks.task4.enums.ReleaseType;

public abstract class ReleaseData {
    private ReleaseType type;
    private String title;
    private String artist;
    private int year;
    private Genre genre;

    public ReleaseData(ReleaseType type, String title, String artist, int year, Genre genre) {
        this.type = type;
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
    }

    @Override
    public int hashCode() {
        return (title == null ? 0 : title.hashCode()) ^ (artist == null ? 0 : artist.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof ReleaseData)) {
            return false;
        }

        ReleaseData release = (ReleaseData)obj;

        return (this.title  != null && this.title.equals(release.title)) &&
               (this.artist != null && this.artist.equals(release.title));
    }

    @Override
    public String toString() {
        return this.type.toString() + "; " +    // Concatenation is much faster then sb.append in most cases.
                this.title + "; " +             // So used it here and String Builder for Song Data,
                this.artist + "; " +            // because SongData.toString() may be called significantly more often
                this.year + "; " +              // during serialization.
                this.genre;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public ReleaseType getType() {
        return type;
    }

    public void setType(ReleaseType type) {
        this.type = type;
    }
}
