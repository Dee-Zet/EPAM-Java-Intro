package Task4.entity;

public class PlaylistData extends Tracklist {
    private int id;
    private long date;
    private String title;
    private String author;
    private ImageUrl cover; // can be null

    public PlaylistData(String title, String author) {
        this.title = title;
        this.author = author;

        this.id = (int)System.currentTimeMillis() ^ title.length();
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

        if (!(obj instanceof PlaylistData)) {
            return false;
        }

        return (this.id == obj.hashCode());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String artist) {
        this.author = artist;
    }

    public ImageUrl getCover() {
        return cover;
    }

    public void setCover(ImageUrl cover) {
        this.cover = cover;
    }
}
