package service;

import java.util.List;
import model.Game;

public interface WriteDataService {
    void apply(List<Game> games);
}
