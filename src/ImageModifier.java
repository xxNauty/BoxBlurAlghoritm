import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ImageModifier {

    public static BufferedImage addBlurEffect(BufferedImage image, int radius) {

        class PixelDensity {
            int r, g, b;

            public PixelDensity add(PixelDensity rhd) {
                r += rhd.r;
                g += rhd.g;
                b += rhd.b;
                return this;
            }

            public PixelDensity devide(int size) {
                this.r = r / size;
                this.g = g / size;
                this.b = b / size;
                return this;
            }
        }

        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {

                final List<PixelDensity> pixels = new ArrayList<>();

                // [ 0 ; 0 ; 0 ; 0 ; 0 ; 0 ; 0 ]
                for (int a = x - radius; a <= x + radius; a++) {
                    for (int b = y - radius; b <= y + radius; b++) {
                        if (a > 0 && a < image.getWidth() && b > 0 && b < image.getHeight()) {
                            final var color = new Color(image.getRGB(a, b));

                            PixelDensity density = new PixelDensity();
                            density.r = color.getRed();
                            density.g = color.getGreen();
                            density.b = color.getBlue();
                            pixels.add(density);
                        }
                    }
                }

                PixelDensity result = pixels.stream()
                        .reduce(PixelDensity::add)
                        .map(pixel -> pixel.devide(pixels.size()))
                        .get();
                Color color = new Color(Math.min(result.r, 255), Math.min(result.g, 255), Math.min(result.b, 255));

                newImage.setRGB(x, y, color.getRGB());
            }
        }
        return newImage;
    }
}
