package by.epam.javatraining.deezee.tasks.task4.serialization;

import by.epam.javatraining.deezee.tasks.task4.entities.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ReleaseSerializer {

    public static String serializeToString(ReleaseData release) {

        StringBuffer releaseString = new StringBuffer(release.toString() + "\n");

        switch (release.getType()) {
            case EP: {
                EpData ep = (EpData)release;
                for (SongData song : ep.getTracklist()) {
                    releaseString.append(song.toString()).append("\n");
                }
                break;
            }
            case LP: {
                LpData lp = (LpData)release;
                for (List<SongData> disc : lp.getDiscs()) {
                    for (SongData song : disc) {
                        releaseString.append(song.toString()).append("\n");
                    }
                }
                break;
            }
            case SP: {
                SingleData sp = (SingleData)release;
                releaseString.append(sp.getSongData().toString());
                break;
            }
        }

        return releaseString.toString();
    }

    public static void serializeToFile(ReleaseData release, String filename) throws IOException {
        FileOutputStream stream = new FileOutputStream(filename);
        OutputStreamWriter streamWriter = new OutputStreamWriter(stream, StandardCharsets.UTF_8);
        streamWriter.write(serializeToString(release));
        streamWriter.close();
        stream.close();
    }

    public static String serializeToFile(ReleaseData release) throws IOException {
        String filename = release.getArtist() + " - " + release.getTitle();
        if (filename.length() > 64) {
            filename = filename.substring(0, 63);
        }
        filename += ".txt";
        serializeToFile(release, filename);
        return filename;
    }
}
