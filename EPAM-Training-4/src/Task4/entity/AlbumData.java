package Task4.entity;

public class AlbumData extends Tracklist {
    private int id;
    private long date;
    private String title;
    private String artist;
    private ImageUrl cover;

    public AlbumData(String title, String author,
                     String smallCoverUrl, String mediumCoverUrl, String largeCoverUrl) {
        this.title = title;
        this.artist = author;
        this.cover = new ImageUrl(smallCoverUrl, mediumCoverUrl, largeCoverUrl);

        this.date = System.currentTimeMillis();

        this.id = (int)System.currentTimeMillis() ^ smallCoverUrl.length();
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

        if (!(obj instanceof AlbumData)) {
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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public ImageUrl getCover() {
        return cover;
    }

    public void setCover(ImageUrl cover) {
        this.cover = cover;
    }
}