package javaprojeto;

import javax.swing.*;
import java.io.File;

public class MusicPlayerApp {
    private JFrame frame;
    private JButton searchButton;
    private JButton playButton;
    private JButton pauseButton;
    private JButton repeatButton;
    private JButton nextButton;  // Botão de próxima música
    private JButton prevButton;  // Botão de música anterior
    private JComboBox<MusicFile> musicComboBox;
    private MusicPlayer musicPlayer;

    public MusicPlayerApp() {
        frame = new JFrame("Music Player");
        searchButton = new JButton("Buscar Música");
        playButton = new JButton("Play");
        pauseButton = new JButton("Pause");
        repeatButton = new JButton("Repeat");
        nextButton = new JButton("Próxima");  // Adicionado botão de próxima música
        prevButton = new JButton("Anterior");  // Adicionado botão de música anterior
        musicComboBox = new JComboBox<>();
        musicPlayer = new MusicPlayer();

        searchButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                MusicFile musicFile = new MusicFile(selectedFile.getName(), selectedFile);
                musicComboBox.addItem(musicFile);
                musicPlayer.loadMusic(selectedFile);
            }
        });

        playButton.addActionListener(e -> musicPlayer.play());
        pauseButton.addActionListener(e -> musicPlayer.pause());
        repeatButton.addActionListener(e -> musicPlayer.repeat());

        nextButton.addActionListener(e -> musicPlayer.playNext());
        prevButton.addActionListener(e -> musicPlayer.playPrevious());

        musicComboBox.addActionListener(e -> {
            MusicFile selectedMusic = (MusicFile) musicComboBox.getSelectedItem();
            musicPlayer.loadMusic(selectedMusic.getFile());
        });

        frame.add(searchButton);
        frame.add(playButton);
        frame.add(pauseButton);
        frame.add(repeatButton);
        frame.add(nextButton);
        frame.add(prevButton);
        frame.add(musicComboBox);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MusicPlayerApp app = new MusicPlayerApp();
            app.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        });
    }
}
