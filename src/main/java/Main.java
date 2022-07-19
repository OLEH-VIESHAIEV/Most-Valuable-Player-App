import java.util.List;
import model.Player;
import service.FileReaderService;
import service.MvpService;
import service.ParseDataService;
import service.impl.FileReaderServiceImpl;
import service.impl.MvpServiceImpl;
import service.impl.ParseDataServiceImpl;

public class Main {
    private static final String FROM_FILE1 = "src/main/resources/database1.csv";
    private static final String FROM_FILE2 = "src/main/resources/database2.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> dataFromFile = fileReaderService.read(FROM_FILE1);
        ParseDataService parseDataService = new ParseDataServiceImpl();
        parseDataService.handleData(dataFromFile);
        List<String> dataFromFile2 = fileReaderService.read(FROM_FILE2);
        parseDataService.handleData(dataFromFile2);
        MvpService mvpService = new MvpServiceImpl();
        Player mvp = mvpService.getMvp();
        System.out.println(mvp);
    }
}
