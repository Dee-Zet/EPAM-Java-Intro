package Task4.entity;

public class AudioUrl {
    private String hq;
    private String sd;
    private String lq;

    public AudioUrl(String lowQualityAudioUrl, String standardQualityAudioUrl, String highQualityAudioUrl) {
        this.hq = highQualityAudioUrl;
        this.sd = standardQualityAudioUrl;
        this.lq = lowQualityAudioUrl;
    }

    public AudioUrl(String lowQualityAudioUrl, String standardQualityAudioUrl) { // if no HQ files available
        this.hq = standardQualityAudioUrl;
        this.sd = standardQualityAudioUrl;
        this.lq = lowQualityAudioUrl;
    }

    public AudioUrl(String lowQualityAudioUrl) { // for only lo-fi audio provided
        this.hq = lowQualityAudioUrl;
        this.sd = lowQualityAudioUrl;
        this.lq = lowQualityAudioUrl;
    }

    public String getHq() {
        return hq;
    }

    public void setHq(String hq) {
        this.hq = hq;
    }

    public String getSd() {
        return sd;
    }

    public void setSd(String sd) {
        this.sd = sd;
    }

    public String getLq() {
        return lq;
    }

    public void setLq(String lq) {
        this.lq = lq;
    }
}
