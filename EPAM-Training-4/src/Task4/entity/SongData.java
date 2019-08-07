package Task4.entity;

public class SongData {
    private int id;
    private int duration;
    private String title;
    private String artist;
    private AudioUrl audio;
    private ImageUrl cover;
    private Genre genre = Genre.UNKNOWN;

    public SongData(String title, String artist, int duration, AudioUrl audio, ImageUrl cover, Genre genre) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.cover = cover;
        this.audio = audio;
        this.genre = genre;

        this.id = (int)System.currentTimeMillis() ^ duration;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof SongData)) {
            return false;
        }

        return (this.id == obj.hashCode());
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

    public AudioUrl getAudio() {
        return audio;
    }

    public void setAudio(AudioUrl audio) {
        this.audio = audio;
    }

    public ImageUrl getCover() {
        return cover;
    }

    public void setCover(ImageUrl cover) {
        this.cover = cover;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}