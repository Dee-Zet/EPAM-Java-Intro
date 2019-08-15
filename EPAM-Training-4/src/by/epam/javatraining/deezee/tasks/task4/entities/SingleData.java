package by.epam.javatraining.deezee.tasks.task4.entities;

import by.epam.javatraining.deezee.tasks.task4.enums.Genre;
import by.epam.javatraining.deezee.tasks.task4.enums.ReleaseType;

public class SingleData extends ReleaseData {
    private SongData songData;

    public SingleData(ReleaseType type, String title, String artist, int year, Genre genre, SongData songData) {
        super(type, title, artist, year, genre);
        this.songData = songData;
    }

    public SongData getSongData() {
        return songData;
    }

    public void setSongData(SongData songData) {
        this.songData = songData;
    }
}