package com.orders.distributionsystem.watcher;

import com.orders.distributionsystem.parsing.ParsingService;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;


public class WatcherService {

    private final ParsingService parsingService;

    public WatcherService() {
        this.parsingService = new ParsingService();
    }

    public void startWatching(String watchedFolder) throws IOException {
        WatchService watchService
                = FileSystems.getDefault().newWatchService();

        Path path;
        try {
            path = Paths.get(watchedFolder);
            path.register(
                    watchService,
                    StandardWatchEventKinds.ENTRY_CREATE);
            System.out.println("Watching for new files in " + watchedFolder);

            WatchKey key;
            while ((key = watchService.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    String context = event.context().toString();
                    File orderFile = new File(watchedFolder + "/" + context);
                    if (parsingService.processOrderFile(orderFile.getAbsolutePath())){
                        System.out.println("File processed successfully: " + context);
                    }else{
                        System.out.println("An error occurred processing : " + context);
                    }
                }
                key.reset();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        WatcherService ws = new WatcherService();
        ws.startWatching("orderFiles");
    }
}
