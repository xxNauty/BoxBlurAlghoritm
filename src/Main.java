import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[] args) {
        BufferedImage input = FileReader.readImage();
        BufferedImage output = ImageModifier.addBlurEffect(input, 15);
        FileSaver.saveFile(output);
    }
}