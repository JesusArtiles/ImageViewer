package implementation.view.persistence;

import model.Image;
import view.persistence.ImageLoader;

import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class FileImageLoader implements ImageLoader {

    private final File[] files;
    private final static String [] extensions = new String []{"jpg","png","bmp"};

    public FileImageLoader(String folder) {
        this.files = new File(folder).listFiles(withImageExtension());
    }

    private FilenameFilter withImageExtension() {
        return (dir, name) -> {
            for (String extension : extensions)
                if(name.endsWith(extension)) return true;
            return false;
        };
    }

    @Override
    public Image load() {
        return getImageAtIndex(0);
    }

    private Image getImageAtIndex(int pos){
        return new Image(){

            @Override
            public byte[] bitmap() {
                try {
                    FileInputStream input = new FileInputStream(files[pos]);
                    return read(input);
                } catch (IOException ex) {
                    return new byte[0];
                }
            }

            private byte[] read(FileInputStream is) throws IOException {
                byte[] buffer = new byte[4096];
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                while(true){
                    int length = is.read(buffer);
                    if(length < 0) break;
                    os.write(buffer, 0, length);
                }
                return os.toByteArray();
            }

            @Override
            public Image next() {
                if(pos < files.length-1){
                    return getImageAtIndex(pos+1);
                }
                return getImageAtIndex(0);
            }

            @Override
            public Image previous() {
                if(pos > 0){
                    return getImageAtIndex(pos-1);
                }
                return getImageAtIndex(files.length-1);
            }
        };
    }



}
