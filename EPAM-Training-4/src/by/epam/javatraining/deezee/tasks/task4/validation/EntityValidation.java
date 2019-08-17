package by.epam.javatraining.deezee.tasks.task4.validation;

import by.epam.javatraining.deezee.tasks.task4.entities.EpData;
import by.epam.javatraining.deezee.tasks.task4.entities.LpData;
import by.epam.javatraining.deezee.tasks.task4.entities.ReleaseData;
import by.epam.javatraining.deezee.tasks.task4.entities.SingleData;

public class EntityValidation {

    public static boolean isValidRelease(ReleaseData release) {
        if (release != null) {
            switch (release.getType()) {
                case SP: return ((SingleData)release).getSongData() != null;
                case EP: return ((EpData)release).getTracklist().size() > 0;
                case LP: return ((LpData)release).getDiscsCount() > 0;
            }
        }
        return false;
    }
}