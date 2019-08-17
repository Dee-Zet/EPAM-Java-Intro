package by.epam.javatraining.deezee.tasks.task4.validation;

import by.epam.javatraining.deezee.tasks.task4.enums.Genre;
import by.epam.javatraining.deezee.tasks.task4.enums.ReleaseType;
import by.epam.javatraining.deezee.tasks.task4.serialization.ReleaseDeserializer;
import org.apache.log4j.Logger;

public class ParameterValidator {
    private static final Logger log = Logger.getLogger(ParameterValidator.class);

    public static Genre validateGenre(String unvalidatedString) {
        String genreString;
        Genre genreValue = Genre.UNKNOWN;
        try {
            genreString = unvalidatedString.toUpperCase().replaceAll("[^a-zA-Z0-9]+", "");
            try {
                genreValue = Genre.valueOf(genreString);
            } catch (Exception e) {
                log.warn("Unrecognized genre in line " + ReleaseDeserializer.getLineNumber());
            }
        } catch (Exception e) {
            log.warn("Unrecognized genre format in line " + ReleaseDeserializer.getLineNumber());
        }
        return genreValue;
    }

    public static ReleaseType validateReleaseType(String unvalidatedString) {
        String releaseTypeString;
        ReleaseType releaseTypeValue = ReleaseType.SP;
        try {
            releaseTypeString = unvalidatedString.toUpperCase().replaceAll("[^a-zA-Z0-9]+", "");
            try {
                releaseTypeValue = ReleaseType.valueOf(releaseTypeString);
            } catch (Exception e) {
                log.warn("No correct release type specified. Will try to deserialize as a single.");
            }
        } catch (Exception e) {
            log.warn("Unrecognized release type format. Will try to deserialize as a single.");
        }
        return releaseTypeValue;
    }

    public static int validateYear(String unvalidatedString) {
        try {
            String yearString = unvalidatedString.trim();
            return Integer.parseInt(yearString);
        } catch (Exception e) {
            log.warn("Unable to parse release year in line " + ReleaseDeserializer.getLineNumber() +
                    ". Returning 0 year.");
            return 0;
        }
    }

    public static int validateDuration(String unvalidatedString) {
        try {
            String durationString = unvalidatedString.trim();
            return Integer.parseInt(durationString);
        } catch (Exception e) {
            log.warn("Unable to parse duration in line " + ReleaseDeserializer.getLineNumber() +
                    ". Returning 0 duration.");
            return 0;
        }
    }
}
