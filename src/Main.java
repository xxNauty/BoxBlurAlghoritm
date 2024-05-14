import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        benchmark(() -> {
            for (int i = 0; i < 10; i++){
                benchmark(() -> {
                    try {
                        BufferedImage input = FileReader.readImage();
                        BufferedImage output = ImageModifier.addBlurEffect(input, 20);
                        FileSaver.saveFile(output);
                    }
                    catch (IOException e){
                        System.out.println("There is an error with file");
                    }
                }, false);
            }
        }, true);
    }

    private static void benchmark(final Runnable action, boolean isTotal) {
        final long start = System.nanoTime();
        action.run();
        final long end = System.nanoTime();

        if(isTotal){
            System.out.println("Total time: " + (end - start) / 1000000 + "ms");
            System.out.println("Avg: " + ((end - start) / 10000000) + "ms");
        }
        else{
            System.out.println("Time = " + (end - start) / 1000000 + "ms");
        }
    }
}