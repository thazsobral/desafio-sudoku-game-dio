package br.com.dio.ui.custom.panel;

import java.awt.Dimension;

import javax.swing.JPanel;

public class SudokuSector extends JPanel {

    public SudokuSector() {
        var dimension = new Dimension(170, 170);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
    }
}
