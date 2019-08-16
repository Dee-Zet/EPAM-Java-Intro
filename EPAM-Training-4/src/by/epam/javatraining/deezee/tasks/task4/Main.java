package by.epam.javatraining.deezee.tasks.task4;

import by.epam.javatraining.deezee.tasks.task4.entities.*;
import by.epam.javatraining.deezee.tasks.task4.enums.SortParameter;
import by.epam.javatraining.deezee.tasks.task4.serialization.ReleaseDeserializer;
import by.epam.javatraining.deezee.tasks.task4.serialization.ReleaseSerializer;
import by.epam.javatraining.deezee.tasks.task4.utils.TracklistSearch;
import by.epam.javatraining.deezee.tasks.task4.utils.TracklistSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<ReleaseData> releaseCatalog = new ArrayList<>();

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in).useDelimiter("\n");;
        int n;

        do {
            System.out.print("Enter a number: ");
            System.out.println("1. Add release, 2. Show releases, 3. Show tracklist, 4. Sort, 5. Search, 6. Store, 0. Exit");
            n = reader.nextInt();
            switch (n) {
                case 1: {
                    System.out.println("Enter file name:");
                    String filename = reader.next();
                    ReleaseData release = ReleaseDeserializer.deserialize(filename);
                    if (release != null) {
                        releaseCatalog.add(release);
                        System.out.println("Release added:");
                        System.out.println(release.toString());
                    }
                    break;
                }
                case 2: {
                    System.out.println("Release catalog:");
                    if (releaseCatalog.size() > 0) {
                        for (int i = 0; i < releaseCatalog.size(); i++) {
                            System.out.print(i);
                            System.out.println(". " + releaseCatalog.get(i).toString());
                        }
                    } else {
                        System.out.println("Empty.");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter release number:");
                    int releaseNumber = reader.nextInt();
                    if (releaseNumber >= 0 && releaseNumber < releaseCatalog.size()) {
                        System.out.println(ReleaseSerializer.serializeToString(releaseCatalog.get(releaseNumber)));
                    } else {
                        System.out.println("No such release in the catalog.");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Enter release number:");
                    int releaseNumber = reader.nextInt();
                    if (releaseNumber >= 0 && releaseNumber < releaseCatalog.size()) {
                        System.out.println("Enter sort parameter: 1. GENRE, 2. DURATION, 3. TITLE, 4. ARTIST");
                        switch (reader.nextInt()) {
                            case 1: {
                                TracklistSort.sortTracklist(releaseCatalog.get(releaseNumber), SortParameter.GENRE);
                                break;
                            }
                            case 2: {
                                TracklistSort.sortTracklist(releaseCatalog.get(releaseNumber), SortParameter.DURATION);
                                break;
                            }
                            case 3: {
                                TracklistSort.sortTracklist(releaseCatalog.get(releaseNumber), SortParameter.TITLE);
                                break;
                            }
                            case 4: {
                                TracklistSort.sortTracklist(releaseCatalog.get(releaseNumber), SortParameter.ARTIST);
                                break;
                            }
                            default: System.out.println("Wrong parameter.");
                        }
                    } else {
                        System.out.println("No such release in the catalog.");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Enter release number:");
                    int releaseNumber = reader.nextInt();
                    if (releaseNumber >= 0 && releaseNumber < releaseCatalog.size()) {
                        System.out.println("Enter min duration:");
                        int minDuration = reader.nextInt();
                        System.out.println("Enter max duration:");
                        int maxDuration = reader.nextInt();
                        for (SongData song : TracklistSearch.searchTrackByDurationRange(
                                releaseCatalog.get(releaseNumber), minDuration, maxDuration)) {
                            System.out.println(song.toString());
                        }
                    } else {
                        System.out.println("No such release in the catalog.");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Enter release number:");
                    int releaseNumber = reader.nextInt();
                    if (releaseNumber >= 0 && releaseNumber < releaseCatalog.size()) {
                        System.out.println("Release stored to " +
                                ReleaseSerializer.serializeToFile(releaseCatalog.get(releaseNumber)));
                    } else {
                        System.out.println("No such release in the catalog.");
                    }
                    break;
                }
                case 0: System.out.println("Exiting. Have a nice day!");
                default: System.out.println("Invalid input.");
            }
            System.out.println();
        } while (n != 0);
    }
}