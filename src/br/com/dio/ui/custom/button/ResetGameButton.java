package br.com.dio.ui.custom.button;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ResetGameButton extends JButton {

    public ResetGameButton(final ActionListener actionListener) {
        this.setText("Resetar");
        this.addActionListener(actionListener);
    }
}
