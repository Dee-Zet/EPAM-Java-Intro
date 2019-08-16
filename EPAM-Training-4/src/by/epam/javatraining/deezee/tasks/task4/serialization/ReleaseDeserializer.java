package by.epam.javatraining.deezee.tasks.task4.serialization;

import by.epam.javatraining.deezee.tasks.task4.entities.*;
import by.epam.javatraining.deezee.tasks.task4.enums.Genre;
import by.epam.javatraining.deezee.tasks.task4.enums.ReleaseType;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReleaseDeserializer {
    private static final Logger log = Logger.getLogger(ReleaseDeserializer.class);

    private static String currentLine;
    private static int lineNumber = 0;

    private static SongData deserializeSong(String songString) {
        String[] songProps = songString.split(";");

        if (songProps.length == 4) {
            String titleString = songProps[0].trim();

            String artistString = songProps[1].trim();

            String durationString = songProps[2].trim();
            int durationInt;
            try {
                durationInt = Integer.parseInt(durationString);
            } catch (Exception e) {
                durationInt = 0;
            }

            String genreString = "";
            try {
                genreString = songProps[3].toUpperCase().replaceAll("[^a-zA-Z0-9]+", "");
            } catch (Exception e) {
                log.error("Error while parsing song genre.");
            }
            Genre genreValue;
            try {
                genreValue = Genre.valueOf(genreString);
            } catch (Exception e) {
                genreValue = Genre.UNKNOWN;
            }

            return new SongData(
                    titleString,
                    artistString,
                    durationInt,
                    genreValue
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
                currentLine += " ";

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

    public static ReleaseData deserialize(String filename) {
        ReleaseData release = null;
        currentLine = null;
        lineNumber = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            do {
                currentLine = br.readLine();
                lineNumber++;
            } while (currentLine.equals(""));

            String[] releaseProps;
            if (currentLine != null) {
                releaseProps = currentLine.split(";");
                if (releaseProps.length == 5) {

                    String releaseTypeString = "";
                    try {
                        releaseTypeString = releaseProps[0].toUpperCase().replaceAll("[^a-zA-Z0-9]+", "");
                    } catch (Exception e) {
                        //TODO
                    }
                    ReleaseType releaseTypeValue = ReleaseType.SP;
                    try {
                        releaseTypeValue = ReleaseType.valueOf(releaseTypeString);
                    } catch (Exception e) {
                        //releaseTypeValue = Genre.UNKNOWN;
                    }

                    String titleString = releaseProps[1].trim();

                    String artistString = releaseProps[2].trim();

                    String yearString = releaseProps[3].trim();
                    int yearInt = 0;
                    try {
                        yearInt = Integer.parseInt(yearString);
                    } catch (Exception e) {
                        //TODO
                    }

                    String genreString = "";
                    try {
                        genreString = releaseProps[4].toUpperCase().replaceAll("[^a-zA-Z0-9]+", "");
                    } catch (Exception e) {
                        //TODO
                    }
                    Genre genreValue;
                    try {
                        genreValue = Genre.valueOf(genreString);
                    } catch (Exception e) {
                        genreValue = Genre.UNKNOWN;
                    }

                    switch (releaseTypeValue) {
                        case EP: {
                            release = new EpData(
                                    releaseTypeValue,
                                    titleString,
                                    artistString,
                                    yearInt,
                                    genreValue,
                                    deserializeTracklist(br)
                            );
                            break;
                        }
                        case LP: {
                            release = new LpData(
                                    releaseTypeValue,
                                    titleString,
                                    artistString,
                                    yearInt,
                                    genreValue,
                                    deserializeDiscs(br)
                            );
                            break;
                        }
                        case SP: {
                            release = new SingleData(
                                    releaseTypeValue,
                                    titleString,
                                    artistString,
                                    yearInt,
                                    genreValue,
                                    deserializeSong(br.readLine())
                            );
                            break;
                        }
                    }
                }
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        if (release != null) {
            log.info("Release added: " + release.toString());
        } else {
            log.error("Unsuccessful release deserialization. Check input file.");
        }
        return release;
    }
}
