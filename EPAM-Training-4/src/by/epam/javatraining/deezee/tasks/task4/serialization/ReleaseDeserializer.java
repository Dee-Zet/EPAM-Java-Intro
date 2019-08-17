package by.epam.javatraining.deezee.tasks.task4.serialization;

import by.epam.javatraining.deezee.tasks.task4.entities.*;
import by.epam.javatraining.deezee.tasks.task4.enums.Genre;
import by.epam.javatraining.deezee.tasks.task4.enums.ReleaseType;
import by.epam.javatraining.deezee.tasks.task4.exceptions.DeserializationException;
import by.epam.javatraining.deezee.tasks.task4.validation.ParameterValidator;
import by.epam.javatraining.deezee.tasks.task4.validation.EntityValidation;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReleaseDeserializer {
    private static final Logger log = Logger.getLogger(ReleaseDeserializer.class);

    private static String currentLine;
    private static int lineNumber = 0;

    public static int getLineNumber() {
        return lineNumber;
    }

    private static SongData deserializeSong(String songString) {
        if (songString == null) {
            log.error("No parameters for song constructor specified in file.");
            return null;
        }
        songString += " "; // to split correctly if Genre field is empty (nothing goes after last ';')
        String[] songProps = songString.split(";");

        if (songProps.length == 4) {
            String title = songProps[0].trim();
            String artist = songProps[1].trim();
            int duration = ParameterValidator.validateDuration(songProps[2]);
            Genre genre = ParameterValidator.validateGenre(songProps[3]);
            return new SongData(
                    title,
                    artist,
                    duration,
                    genre
            );
        } else {
            log.warn("Wrong parameters for SongData constructor in line " + lineNumber + ". Skipping line.");
            return null;
        }
    }

    private static List<SongData> deserializeTracklist(BufferedReader br) throws IOException {
        List<SongData> tracklist = new ArrayList<>();
        while ((currentLine = br.readLine()) != null && !currentLine.equals("/cd")) {
            lineNumber++;
            if (!currentLine.equals("")) {
                SongData song = deserializeSong(currentLine);
                if (song != null){
                    tracklist.add(song);
                }
            }
        }
        return tracklist;
    }

    private static List<List<SongData>> deserializeDiscs(BufferedReader br) throws IOException {
        List<List<SongData>> tracklist = new ArrayList<>();

        while (currentLine != null) {
            tracklist.add(deserializeTracklist(br));
        }

        return tracklist;
    }

    public static ReleaseData deserialize(String filename) throws DeserializationException {
        ReleaseData release = null;
        currentLine = null;
        lineNumber = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            if ((currentLine = br.readLine()) == null) {
                throw new DeserializationException("Release data file is empty.");
            }
            lineNumber++;

            while (currentLine.equals("")) {    // skipping empty lines at the beginning of a file
                currentLine = br.readLine();
                lineNumber++;
            }

            String[] releaseProps = currentLine.split(";");
            if (releaseProps.length == 5) {
                ReleaseType releaseType = ParameterValidator.validateReleaseType(releaseProps[0]);
                String title = releaseProps[1].trim();
                String artist = releaseProps[2].trim();
                int year = ParameterValidator.validateYear(releaseProps[3]);
                Genre genre = ParameterValidator.validateGenre(releaseProps[4]);

                switch (releaseType) {
                    case EP:
                        release = new EpData(
                                releaseType,
                                title,
                                artist,
                                year,
                                genre,
                                deserializeTracklist(br)
                        );
                        break;
                    case LP:
                        release = new LpData(
                                releaseType,
                                title,
                                artist,
                                year,
                                genre,
                                deserializeDiscs(br)
                        );
                        break;
                    case SP:
                        release = new SingleData(
                                releaseType,
                                title,
                                artist,
                                year,
                                genre,
                                deserializeSong(br.readLine())
                        );
                        break;
                }
            } else {
                log.warn("Wrong parameters for ReleaseData constructor in line " + lineNumber);
            }
        }
        catch (IOException ex) {
            log.error(ex.getMessage());
        }

        if (EntityValidation.isValidRelease(release)) {
            log.info("Release deserialized: " + release.toString());
            return release;
        } else {
            throw new DeserializationException("Unsuccessful release deserialization. Check input file.");
        }
    }
}