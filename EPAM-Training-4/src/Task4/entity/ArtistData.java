package Task4.entity;

public class ArtistData {
    private int id;
    private String name;
    private ImageUrl photo;
    private String bio = "";

    public ArtistData(String name) {
        this.name = name;

        this.id = (int)System.currentTimeMillis() ^ name.length();
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

        if (!(obj instanceof ArtistData)) {
            return false;
        }

        return (this.id == obj.hashCode());
    }


    public String getName() {
        return name;
    }

    public ImageUrl getPhoto() {
        return photo;
    }

    public void setPhoto(ImageUrl photo) {
        this.photo = photo;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
