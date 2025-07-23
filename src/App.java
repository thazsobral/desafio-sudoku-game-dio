import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.dio.model.Board;
import br.com.dio.model.Space;
import static br.com.dio.util.BoardTemplate.BOARD_TEMPLATE;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class App {

    private final static Scanner scanner = new Scanner(System.in);

    private static Board board;

    private final static int BOARD_LIMITE = 9;

    public static void main(String[] args) throws Exception {

        final var positions = Stream.of(args)
                                        .collect(Collectors.toMap(
                                            k -> k.split(";")[0],
                                            v -> v.split(";")[1]
                                        ));

        var option = -1;
        
        while (true) {
            System.out.println("Seleciona uma das opções a seguir:");
            System.out.println("1- inluir um novo jogo");
            System.out.println("2- colocar um novo número");
            System.out.println("3- remover um número");
            System.out.println("4- visualizar jogo atual");
            System.out.println("5- verificar status do jogo");
            System.out.println("6- limpar jogo");
            System.out.println("7- finalizar jogo");
            System.out.println("8- sair");

            option = scanner.nextInt();

            switch (option) {
                case 1 -> startGame(positions);
                case 2 -> inputNumber();
                case 3 -> removeNumber();
                case 4 -> showCurrentGame();
                case 5 -> showGameStatus();
                case 6 -> clearGame();
                case 7 -> finishGame();
                case 8 -> System.exit(0);
                default -> System.out.println("opção inválida, por favor seleciona alguma das opções do menu.");
            }
            System.out.println("\n");
        }
    }

    private static void finishGame() {

        if (isNull(board)) {
        
            System.out.println("o jogo ainda nao foi iniciado");
            return;
        } else {

            if (board.gamesIsFinished()) {
                
                System.out.println("parabéns, você coclui o jogo");
                showCurrentGame();
                board = null;
            } else if (board.hasErrors()) {
                
                System.out.println("o jogo contém erros, por favor verifique");
            } else {
                System.out.println("você ainda precisa preencher algum espaço");
            }
        }
    }

    private static void clearGame() {

        if (isNull(board)) {
        
            System.out.println("o jogo ainda nao foi iniciado");
            return;
        } else {

            System.out.println("têm certeza que deseja limpar seu jogo e perder seu progresso? (Sim|Não)");
            var confirm = scanner.next();
            while (!confirm.equalsIgnoreCase("sim") && !confirm.equalsIgnoreCase("não")) {
                
                System.out.println("informe 'sim' ou 'não'.");
                confirm = scanner.next();
            }

            if (confirm.equalsIgnoreCase("sim")) {
                board.reset();
            } else {
                return;
            }
        }
    }

    private static void showGameStatus() {
        
        if (isNull(board)) {
        
            System.out.println("o jogo ainda nao foi iniciado");
            return;
        } else {
            
            System.out.println("o jogo atualmente se encontra no status %s.".formatted(board.getStatus().getLabel()));

            if (board.hasErrors()) {
                System.out.println("o jogo contém erros");
            } else {
                System.out.println("o jogo não contém erros");
            }
        }
    }

    private static void showCurrentGame() {
        
        if (isNull(board)) {
        
            System.out.println("o jogo ainda nao foi iniciado");
            return;
        } else {
            
            var args = new Object[81];
            var argPos = 0;
            
            for (int i = 0; i < BOARD_LIMITE; i++) {
                
                for (var col : board.getSpaces()) {
                    
                    args[argPos ++] = " " + ((isNull(col.get(i).getActual())) ? " " : col.get(i).getActual());
                }
            }

            System.out.println("seu jogo está da seguinte forma");
            System.out.println((BOARD_TEMPLATE) + "%n".formatted(args));
        }
    }

    private static void removeNumber() {

        if (isNull(board)) {
        
            System.out.println("o jogo ainda nao foi iniciado");
            return;
        } else {
        
            System.out.println("informe a coluna em que o número será inserido");
            var col = runUntilGetValidNumber(0, 8);
            System.out.println("informe a linha em que o número será inserido");
            var row = runUntilGetValidNumber(0, 8);

            if (!board.clearValue(col, row)) {
                
                System.out.println("a posição [%s, %s]] têm o valor fixo".formatted(col, row));
            }
        }
    }

    private static void inputNumber() {

        if (isNull(board)) {
        
            System.out.println("o jogo ainda nao foi iniciado");
            return;
        } else {
        
            System.out.println("informe a coluna em que o número será inserido");
            var col = runUntilGetValidNumber(0, 8);
            System.out.println("informe a linha em que o número será inserido");
            var row = runUntilGetValidNumber(0, 8);
            System.out.println("informe o número que vai entrar na posição [%s,$s]".formatted(col, row));
            var value = runUntilGetValidNumber(1, 9);

            if (!board.changeValue(col, row, value)) {
                
                System.out.println("a posição [%s, %s]] têm o valor fixo".formatted(col, row));
            }
        }
    }

    private static int runUntilGetValidNumber(final int min, final int max) {
        
        var current = scanner.nextInt();
        while (current < min || current > max) {
            
            System.out.println("informe um número entre %s e %s".formatted(min, max));
            current = scanner.nextInt();
        }

        return current;
    }

    private static void startGame(final Map<String, String> positions) {
        if (nonNull(board)) {
            
            System.out.println("o jogo ja foi iniciado");
            return;
        } else {

            List<List<Space>> spaces = new ArrayList<>();
            for (int i = 0; i < BOARD_LIMITE; i++) {
                
                spaces.add(new ArrayList<>());
                for (int j = 0; j < BOARD_LIMITE; j++) {
                    var positionConfig = positions.get("%s %s".formatted(i, j));
                    var expected = Integer.parseInt(positionConfig.split(",")[0]);
                    var fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);
                    var currentSpace = new Space(expected, fixed);
                    spaces.get(i).add(currentSpace);
                }
            }

            board = new Board(spaces);
            System.out.println("o jogo está pronto para começar");
        }

    }
}
