package com.company.utils;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by agnie on 3/10/2016.
 */
public class FilePicker {

    public File getFilePath() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        FileDialog fileDialog = new FileDialog(frame, "Import graph", FileDialog.LOAD);
        fileDialog.setVisible(true);
        String directory = fileDialog.getDirectory();
        String file = fileDialog.getFile();
        String fileDirectory = directory + file;
        File graphFile = new File(fileDirectory);
        frame.setVisible(false);
        return graphFile;
    }

}
