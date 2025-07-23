import java.awt.Dimension;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.com.dio.ui.custom.frame.MainFrame;
import br.com.dio.ui.custom.panel.MainPanel;
import br.com.dio.ui.custom.screen.MainScreen;

public class UIApp {
    public static void main(String[] args) {

        final var gameConfig = Stream.of(args)
                                    .collect(toMap(
                                        k -> k.split(";")[0],
                                        v -> v.split(";")[1]
                                    ));
        var mainScreen = new MainScreen(gameConfig);
        mainScreen.buildMainScreen();
    }
}
