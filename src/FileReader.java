import org.w3c.dom.css.RGBColor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileReader {

    private static final String FILE_PATH = "path_to_input_image";

    public static BufferedImage readImage(){
        try {
            return ImageIO.read(new File(FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
