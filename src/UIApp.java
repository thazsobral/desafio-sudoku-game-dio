import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.com.dio.ui.custom.frame.MainFrame;
import br.com.dio.ui.custom.panel.MainPanel;

public class UIApp {
    public static void main(String[] args) {

        var dimension = new Dimension(680, 600);

        JPanel mainPanel = new MainPanel(dimension);
        JFrame mainFrame = new MainFrame(dimension, mainPanel);

        mainFrame.revalidate();
        mainFrame.repaint();
    }
}
