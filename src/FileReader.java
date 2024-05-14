import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileReader {

    private static final String FILE_PATH = "plik.jpg";

    public static BufferedImage readImage() throws IOException {
        return ImageIO.read(new File(FILE_PATH));
    }
}
