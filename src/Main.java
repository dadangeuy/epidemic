import org.apache.commons.io.FileUtils;

import java.io.File;

public class Main {
    private static FilesManager manager = new FilesManager("./");

    public static void main(String[] args) throws Exception {
        for (File file : manager.getFiles(".jpeg", ".jpg", ".png")) {
            byte[] data = FileUtils.readFileToByteArray(file);
            byte[] dataZip = ByteUtils.compress(data);
            FileUtils.writeByteArrayToFile(file, dataZip);
        }
    }
}
