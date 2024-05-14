import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileSaver {

    private static final String FILE_PATH = "output.jpg";

    public static void saveFile(BufferedImage image) throws IOException {
        ImageIO.write(image, "jpg", new File(FILE_PATH));
    }
}
