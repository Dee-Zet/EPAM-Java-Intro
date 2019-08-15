package by.epam.javatraining.deezee.tasks.task4;

import by.epam.javatraining.deezee.tasks.task4.entities.*;
import by.epam.javatraining.deezee.tasks.task4.serialization.ReleaseDeserializer;
import by.epam.javatraining.deezee.tasks.task4.serialization.ReleaseSerializer;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class);

    private static List<ReleaseData> releaseCatalog = new ArrayList<>();

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in).useDelimiter("\n");;
        int n;

        do {
            System.out.println("Enter a number: 1. Add release, 2. Show releases, 3. Show tracklist, 4. Sort, 5. Store, 0. Exit");
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
                case 5: {
                    System.out.println("Enter release number:");
                    int releaseNumber = reader.nextInt();
                    if (releaseNumber >= 0 && releaseNumber < releaseCatalog.size()) {
                        try {
                            System.out.println("Release stored to " +
                                    ReleaseSerializer.serializeToFile(releaseCatalog.get(releaseNumber)));
                        } catch (IOException e) {
                            log.error("Error while trying to serialize release.");
                        }
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