import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

import br.com.dio.ui.custom.screen.MainScreen;

public class App {
    public static void main(String[] args) {
        if (args.length > 0) {

            System.out.println("board instructions: "+args[0]);
            
            final var gameConfig = Stream.of(args)
                                        .collect(toMap(
                                            k -> k.split(";")[0],
                                            v -> v.split(";")[1]
                                        ));
            
            var mainScreen = new MainScreen(gameConfig);
            mainScreen.buildMainScreen();
        } else {
            System.out.println("Nenhuma instrução foi fornecida");
        }
    }
}
