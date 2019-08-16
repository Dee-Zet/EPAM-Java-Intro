package by.epam.javatraining.deezee.tasks.task4.utils;

import by.epam.javatraining.deezee.tasks.task4.entities.EpData;
import by.epam.javatraining.deezee.tasks.task4.entities.LpData;
import by.epam.javatraining.deezee.tasks.task4.entities.ReleaseData;
import by.epam.javatraining.deezee.tasks.task4.entities.SongData;
import by.epam.javatraining.deezee.tasks.task4.enums.SortParameter;

import java.util.Comparator;
import java.util.List;

public class TracklistSort {

    public static void sortTracklist(ReleaseData release, SortParameter sort) {
        switch (sort) {
            case ARTIST:    sortByArtist(release);   break;
            case DURATION:  sortByDuration(release); break;
            case GENRE:     sortByGenre(release);    break;
            case TITLE:     sortByTitle(release);    break;
            default: {}
        }
    }

    private static void sortByGenre(ReleaseData release) {
        switch (release.getType()) {
            case EP:
                ((EpData) release).getTracklist().sort(Comparator.comparing(SongData::getGenre));
                break;
            case LP:
                for (List<SongData> tracklist : ((LpData) release).getDiscs()) {
                    tracklist.sort(Comparator.comparing(SongData::getGenre));
                }
                break;
        }
    }

    private static void sortByDuration(ReleaseData release) {
        switch (release.getType()) {
            case EP:
                ((EpData) release).getTracklist().sort(Comparator.comparing(SongData::getDuration));
                break;
            case LP:
                for (List<SongData> tracklist : ((LpData) release).getDiscs()) {
                    tracklist.sort(Comparator.comparing(SongData::getDuration));
                }
                break;
        }
    }

    private static void sortByArtist(ReleaseData release) {
        switch (release.getType()) {
            case EP:
                ((EpData) release).getTracklist().sort(Comparator.comparing(SongData::getArtist));
                break;
            case LP:
                for (List<SongData> tracklist : ((LpData) release).getDiscs()) {
                    tracklist.sort(Comparator.comparing(SongData::getArtist));
                }
                break;
        }
    }

    private static void sortByTitle(ReleaseData release) {
        switch (release.getType()) {
            case EP:
                ((EpData) release).getTracklist().sort(Comparator.comparing(SongData::getTitle));
                break;
            case LP:
                for (List<SongData> tracklist : ((LpData) release).getDiscs()) {
                    tracklist.sort(Comparator.comparing(SongData::getTitle));
                }
                break;
        }
    }
}
