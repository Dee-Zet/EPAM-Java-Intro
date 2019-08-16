package by.epam.javatraining.deezee.tasks.task4.serialization;

import by.epam.javatraining.deezee.tasks.task4.entities.*;
import org.apache.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ReleaseSerializer {
    private static final Logger log = Logger.getLogger(ReleaseDeserializer.class);

    public static String serializeToString(ReleaseData release) {

        StringBuilder releaseString = new StringBuilder(release.toString() + "\n");

        switch (release.getType()) {
            case EP: {
                for (SongData song : ((EpData)release).getTracklist()) {
                    releaseString.append(song.toString()).append("\n");
                }
                break;
            }
            case LP: {
                for (List<SongData> disc : ((LpData)release).getDiscs()) {
                    for (SongData song : disc) {
                        releaseString.append(song.toString()).append("\n");
                    }
                }
                break;
            }
            case SP: {
                releaseString.append(((SingleData)release).getSongData().toString());
                break;
            }
        }

        return releaseString.toString();
    }

    public static void serializeToFile(ReleaseData release, String filename) {
        try {
            FileOutputStream stream = new FileOutputStream(filename);
            OutputStreamWriter streamWriter = new OutputStreamWriter(stream, StandardCharsets.UTF_8);
            streamWriter.write(serializeToString(release));
            streamWriter.close();
            stream.close();
            log.info("Release stored to " + filename);
        } catch (IOException e) {
            log.error("Error while trying to serialize release.");
        }
    }

    public static String serializeToFile(ReleaseData release) {
        String filename = release.getArtist() + " - " + release.getTitle();
        if (filename.length() > 64) {
            filename = filename.substring(0, 63);
        }
        filename += ".txt";
        serializeToFile(release, filename);
        return filename;
    }
}
