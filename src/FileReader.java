import org.w3c.dom.css.RGBColor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileReader {

    private static final String FILE_PATH = "D:\\Java\\BoxBlurAlghoritm\\src\\plik.png";

    public static BufferedImage readImage(){
        try {
            return ImageIO.read(new File(FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
