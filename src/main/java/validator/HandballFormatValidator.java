package validator;

import exception.DataFormatException;
import java.util.List;

public class HandballFormatValidator {
    public static void validate(List<String> players) {
        String pattern = "[a-zA-Z\\d]+;[a-zA-Z\\d]+;\\d+;[a-zA-Z\\d ]+;\\d+;\\d+";
        if (players.size() == 0) {
            throw new DataFormatException("Empty file");
        }
        for (String player : players) {
            if (!player.matches(pattern)) {
                throw new DataFormatException("Invalid data format");
            }
        }
    }
}
