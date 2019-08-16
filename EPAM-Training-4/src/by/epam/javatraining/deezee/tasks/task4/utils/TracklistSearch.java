package by.epam.javatraining.deezee.tasks.task4.utils;

import by.epam.javatraining.deezee.tasks.task4.entities.*;

import java.util.ArrayList;
import java.util.List;

public class TracklistSearch {

    public static ArrayList<SongData> searchTrackByDurationRange(ReleaseData release, int minDuration, int maxDuration) {
        ArrayList<SongData> result = new ArrayList<>();
        switch (release.getType()) {
            case EP: {
                for (SongData song : ((EpData)release).getTracklist()) {
                    if (song.getDuration() <= maxDuration && song.getDuration() >= minDuration) {
                        result.add(song);
                    }
                }
                break;
            }
            case LP: {
                for (List<SongData> disc : ((LpData)release).getDiscs()) {
                    for (SongData song : disc) {
                        if (song.getDuration() <= maxDuration && song.getDuration() >= minDuration) {
                            result.add(song);
                        }
                    }
                }
                break;
            }
            case SP: {
                SongData song = ((SingleData)release).getSongData();
                if (song.getDuration() <= maxDuration && song.getDuration() >= minDuration) {
                    result.add(song);
                }
                break;
            }
        }
        return result;
    }
}
