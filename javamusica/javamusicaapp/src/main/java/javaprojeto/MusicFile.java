package javaprojeto;

import java.io.File;

public class MusicFile {
    private String title;
    private File file;

    public MusicFile(String title, File file) {
        this.title = title;
        this.file = file;
    }

    public String getTitle() {
        return title;
    }

    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        return title;
    }
}
