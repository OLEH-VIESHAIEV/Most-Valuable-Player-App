package service;

import java.util.List;
import model.Game;

public interface ParseDataService {
    List<Game> parse(List<String> dataFromFile);
}
