package Task4.entity;

public class ImageUrl {
    private String large;
    private String medium;
    private String small;

    public ImageUrl(String smallCoverUrl, String mediumCoverUrl, String largeCoverUrl) {
        this.large = largeCoverUrl;
        this.medium = mediumCoverUrl;
        this.small = smallCoverUrl;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }
}
