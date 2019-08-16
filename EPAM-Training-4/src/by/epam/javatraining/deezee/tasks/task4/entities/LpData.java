package by.epam.javatraining.deezee.tasks.task4.entities;

import by.epam.javatraining.deezee.tasks.task4.enums.Genre;
import by.epam.javatraining.deezee.tasks.task4.enums.ReleaseType;

import java.util.List;

public class LpData extends ReleaseData {
    private List<List<SongData>> discs;

    public LpData(ReleaseType type, String title, String artist, int year, Genre genre, List<List<SongData>> discList) {
        super(type, title, artist, year, genre);
        this.discs = discList;
    }

    public List<List<SongData>> getDiscs() {
        return discs;
    }

    public void setDiscs(List<List<SongData>> discs) {
        this.discs = discs;
    }

    public int getDiscsCount() {
        return discs.size();
    }
}
