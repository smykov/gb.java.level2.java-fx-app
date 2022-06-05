package ru.gb.smykov.javafxapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    @FXML
    private TextField userAnswer;
    @FXML
    private TextArea historyArea;

    private Game game;
    private int step;

    public Controller() {
        this.game = new Game();
    }

    public void clickCheckButton() {
        String answer = userAnswer.getText();
        if (answer.isBlank()) {
            return;
        }

        Game.BullsAndCowsCount count = game.calculateBullsAndCows(answer);
        String text = String.format("%d: Введено число %s. Количество быков %d. Количество коров %d\n", ++step, answer, count.getBulls(), count.getCows());
        historyArea.appendText(text + "\n");
        userAnswer.clear();
        userAnswer.requestFocus();

        if (count.getBulls() == 4) {
            if (ifWantPlayAgain()) {
                clickNewGame();
            } else {
                clickExit();
            }
        }
    }

    private boolean ifWantPlayAgain() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Поздравляю, вы выйграли!\n" +
                        "Загаданное число " + game.getGuessNum() + "\n\n" +
                        "Желаете сыграть еще?",
                new ButtonType("Да", ButtonBar.ButtonData.YES),
                new ButtonType("Нет", ButtonBar.ButtonData.NO)
        );
        alert.setTitle("Поздравляю!!!");
        ButtonType answer = alert.showAndWait().get();

        return answer.getButtonData() == ButtonBar.ButtonData.YES;
    }

    public void clickExit() {
        System.exit(0);
    }

    public void clickNewGame() {
        step = 0;
        historyArea.clear();
        this.game = new Game();
    }
}