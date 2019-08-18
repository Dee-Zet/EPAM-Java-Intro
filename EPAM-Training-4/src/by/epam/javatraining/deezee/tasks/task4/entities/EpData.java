package by.epam.javatraining.deezee.tasks.task4.entities;

import by.epam.javatraining.deezee.tasks.task4.enums.Genre;
import by.epam.javatraining.deezee.tasks.task4.enums.ReleaseType;

import java.util.Collections;
import java.util.List;

public class EpData extends ReleaseData {
    private List<SongData> tracklist;

    public EpData(ReleaseType type, String title, String artist, int year, Genre genre, List<SongData> songList) {
        super(type, title, artist, year, genre);
        this.tracklist = songList;
    }

    public List<SongData> getTracklist() {
        return Collections.unmodifiableList(tracklist);
    }

    public void setTracklist(List<SongData> tracklist) {
        this.tracklist = tracklist;
    }
}