import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ImageModifier {

    public static BufferedImage addBlurEffect(BufferedImage image, int radius) {

        int halfOfRadius = radius / 2;

        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                //red
                List<Integer> surroundingColorsRed = new ArrayList<>();
                for(int a = x - halfOfRadius; a <=x + halfOfRadius; a++) {
                    for(int b = y - halfOfRadius; b <=y + halfOfRadius; b++) {
                        if(a < 0 || a >= image.getWidth() || b < 0 || b >= image.getHeight()) {
                            surroundingColorsRed.add(new Color(image.getRGB(x, y)).getRed());
                        }
                        else {
                            surroundingColorsRed.add(new Color(image.getRGB(a, b)).getRed());
                        }

                    }
                }
                surroundingColorsRed.remove(halfOfRadius + 1);
                int newRed = surroundingColorsRed.stream().mapToInt(c -> c).sum() / surroundingColorsRed.size();

                //green
                List<Integer> surroundingColorsGreen = new ArrayList<>();
                for(int c = x - halfOfRadius; c <=x + halfOfRadius; c++) {
                    for(int d = y - halfOfRadius; d <=y + halfOfRadius; d++) {
                        if(c < 0 || c >= image.getWidth() || d < 0 || d >= image.getHeight()) {
                            surroundingColorsGreen.add(new Color(image.getRGB(x, y)).getGreen());
                        }
                        else {
                            surroundingColorsGreen.add(new Color(image.getRGB(c, d)).getGreen());
                        }
                    }
                }
                surroundingColorsGreen.remove(halfOfRadius + 1);
                int newGreen = surroundingColorsGreen.stream().mapToInt(c -> c).sum() / surroundingColorsGreen.size();

                //blue
                List<Integer> surroundingColorsBlue = new ArrayList<>();
                for(int e = x - halfOfRadius; e <=x + halfOfRadius; e++) {
                    for(int f = y - halfOfRadius; f <=y + halfOfRadius; f++) {
                        if(e < 0 || e >= image.getWidth() || f < 0 || f >= image.getHeight()) {
                            surroundingColorsBlue.add(new Color(image.getRGB(x, y)).getBlue());
                        }
                        else {
                            surroundingColorsBlue.add(new Color(image.getRGB(e, f)).getBlue());
                        }
                    }
                }
                surroundingColorsBlue.remove(halfOfRadius + 1);
                int newBlue = surroundingColorsBlue.stream().mapToInt(c -> c).sum() / surroundingColorsBlue.size();

                Color color = new Color(newRed, newGreen, newBlue);

                newImage.setRGB(x, y, color.getRGB());
            }
        }
        return newImage;
    }
}
