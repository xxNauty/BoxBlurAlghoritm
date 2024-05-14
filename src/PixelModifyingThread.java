import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

public class PixelModifyingThread implements Runnable{

    private final BufferedImage image;
    private volatile Color color;
    private final int radius;
    private final int x;
    private final int y;

    public PixelModifyingThread(BufferedImage image, int radius, int x, int y) {
        this.image = image;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.color = new Color(0);
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void run() {

    }
}
