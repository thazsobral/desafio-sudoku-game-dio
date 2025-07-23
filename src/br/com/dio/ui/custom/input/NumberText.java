package br.com.dio.ui.custom.input;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Dimension;
import java.awt.Font;

import static java.awt.Font.PLAIN;

import br.com.dio.model.Space;

public class NumberText extends JTextField {

    private final Space space;

    public NumberText(final Space space) {

        var dimension = new Dimension(50,50);
        
        this.space = space;
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setVisible(true);
        this.setFont(new Font("Arial", PLAIN, 20));
        this.setHorizontalAlignment(CENTER);
        this.setDocument(new NumberTextLimit());
        this.setEnabled(!space.isFixed());

        if (space.isFixed()) {
            this.setText(space.getActual().toString());
        }

        this.getDocument().addDocumentListener(new DocumentListener(){

            private void changeSpace() {
                
                if (getText().isEmpty()) {
                    
                    space.clearSpace();
                    return;
                } else {
                    
                    space.setActual(Integer.parseInt(getText()));
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                
                changeSpace();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                
                changeSpace();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
                changeSpace();
            }
            
        });
    }
}
