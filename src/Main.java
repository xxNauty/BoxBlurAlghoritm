import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[] args) {
        benchmark(() -> {
            BufferedImage input = FileReader.readImage();
            BufferedImage output = ImageModifier.addBlurEffect(input, 15);
            FileSaver.saveFile(output);
        });
    }

    private static void benchmark(final Runnable action) {
        final var start = System.nanoTime();
        action.run();
        final var end = System.nanoTime();

        System.out.println("time = " + (end - start) / 1000000 + "ms");
    }
}