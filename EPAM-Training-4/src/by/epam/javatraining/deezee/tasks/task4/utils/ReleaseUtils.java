package by.epam.javatraining.deezee.tasks.task4.utils;

import by.epam.javatraining.deezee.tasks.task4.entities.ReleaseData;
import by.epam.javatraining.deezee.tasks.task4.enums.SortParameter;

public class ReleaseUtils {

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

    }

    private static void sortByDuration(ReleaseData release) {

    }

    private static void sortByArtist(ReleaseData release) {

    }

    private static void sortByTitle(ReleaseData release) {

    }

    public static int searchTrackByDurationRange(ReleaseData release, int minDuration, int maxDuration) {
        int index = -1;

        return index;
    }
}
