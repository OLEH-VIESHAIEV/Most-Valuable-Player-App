import java.util.List;
import model.Game;
import model.Player;
import service.FileReaderService;
import service.GameHandlerStrategy;
import service.MvpService;
import service.ParseDataService;
import service.WriteDataService;
import service.impl.FileReaderServiceImpl;
import service.impl.GameHandlerStrategyImpl;
import service.impl.MvpServiceImpl;
import service.impl.ParseDataServiceImpl;
import service.impl.WriteDataServiceImpl;

public class Main {
    private static final String FROM_FILE1 = "src/main/resources/database1.csv";
    private static final String FROM_FILE2 = "src/main/resources/database2.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> dataFromFile = fileReaderService.read(FROM_FILE1);
        ParseDataService parseDataService = new ParseDataServiceImpl();
        List<Game> games = parseDataService.parse(dataFromFile);
        GameHandlerStrategy gameHandlerStrategy = new GameHandlerStrategyImpl();
        WriteDataService writeDataService = new WriteDataServiceImpl(gameHandlerStrategy);
        writeDataService.apply(games);
        MvpService mvpService = new MvpServiceImpl();
        Player mvp = mvpService.getMvp();
        System.out.println(mvp);
    }
}
