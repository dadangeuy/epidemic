import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FilesManager {
    private Set<File> files = new HashSet<>();
    private File root;

    public FilesManager(String rootPath) {
        root = new File(rootPath);
        deepIndexing();
    }

    private void deepIndexing() {
        Queue<File> pendingFiles = new LinkedList<>();
        pendingFiles.add(root);
        while (!pendingFiles.isEmpty()) {
            File rootDirectory = pendingFiles.poll();
            File[] directories = rootDirectory.listFiles();
            if (directories != null) {
                for (File file : directories) {
                    if (file.isDirectory()) pendingFiles.add(file);
                    else files.add(file);
                }
            }
        }
    }

    public Set<File> getFiles() {
        return files;
    }

    public Set<File> getFiles(String... suffixes) {
        Set<File> files = new HashSet<>();
        for (String suffix : suffixes) {
            files.addAll(getFiles(suffix));
        }
        return files;
    }

    public Set<File> getFiles(String suffix) {
        Set<File> filteredFiles = new HashSet<>();
        for (File file : files) {
            if (file.getName().endsWith(suffix)) {
                filteredFiles.add(file);
            }
        }
        return filteredFiles;
    }
}
