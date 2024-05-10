import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileSaver {

    private static final String FILE_PATH = "path_to_output_file";

    public static void saveFile(BufferedImage image){
        File file = new File(FILE_PATH);
        try {
            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
