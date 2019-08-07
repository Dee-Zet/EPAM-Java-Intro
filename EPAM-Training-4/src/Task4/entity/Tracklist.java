package Task4.entity;

import java.util.List;

public class Tracklist {
    private List<List<SongData>> discs;

    public int getDiscsCount() {
        return discs.size();
    }
}