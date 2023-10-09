package javaprojeto;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javax.swing.*;
import java.util.concurrent.ExecutionException;

public class MusicPlayer {
    private Clip clip;
    private Player mp3Player;
    private ArrayList<File> playlist = new ArrayList<>();
    private int currentTrackIndex = 0;
    private boolean isRepeat = false;

    public void addToPlaylist(File file) {
        playlist.add(file);
    }

    public void loadMusic(File file) {
        try {
            String fileName = file.getName().toLowerCase();
            if (fileName.endsWith(".wav")) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
            } else if (fileName.endsWith(".mp3")) {
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                mp3Player = new Player(bis);
            } else {
                System.out.println("Formato de arquivo não suportado: " + fileName);
            }
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException | JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                if (clip != null) {
                    clip.start();
                } else if (mp3Player != null) {
                    try {
                        mp3Player.play();
                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };
    
        worker.execute();
    }
    

    public void pause() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        } else if (mp3Player != null && !mp3Player.isComplete()) {
            mp3Player.close();
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        } else if (mp3Player != null && !mp3Player.isComplete()) {
            mp3Player.close();
        }
    }

    public void repeat() {
        isRepeat = !isRepeat;
    }

    public void playNext() {
        currentTrackIndex = (currentTrackIndex + 1) % playlist.size();
        loadMusic(playlist.get(currentTrackIndex));
        play();
    }

    public void playPrevious() {
        currentTrackIndex = (currentTrackIndex - 1 + playlist.size()) % playlist.size();
        loadMusic(playlist.get(currentTrackIndex));
        play();
    }

    public void close() {
        if (clip != null) {
            clip.close();
        } else if (mp3Player != null) {
            mp3Player.close();
        }
    }
}
