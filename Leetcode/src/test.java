import WeeklyGames.g10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class test {
    private final static int threadCount = 20;

    public static String pictureToBase64(String path)  {
        String pictureBase64;
        try {
            byte[] pictureBytes = Files.readAllBytes(Paths.get(path));
            pictureBase64= "data:image/png;base64,"+ Base64.getEncoder().encodeToString(pictureBytes);
        }catch (IOException e) {
            return null;
        }
        return pictureBase64;
    }
    public static void main(String[] args) {
//        String path="C:\\Users\\Phoenix\\Desktop\\1.jpg";
//        System.out.println(pictureToBase64(path));

        String currentDirectory = System.getProperty("user.dir");
        System.out.println("Current working directory: " + currentDirectory);

        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire(); // 获取一个许可
                    test(threadNum);
                    semaphore.release(); // 释放一个许可
                } catch (Exception e) {
                  return;
                }
            });
        }
        exec.shutdown();


    }
    private static void test(int threadNum) throws Exception {
        System.out.println(("{}"+ threadNum));
        Thread.sleep(1000);
    }

}
