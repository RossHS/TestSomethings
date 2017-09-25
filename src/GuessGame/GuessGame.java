package GuessGame;
//TODO добавить сортировку и сделать код по правилам ООП

/**
 * Created by Ross on 23.09.2017.
 */
public class GuessGame {
    static int answer;
    int userGuess;
    int rightUserGuess;
    GuessGame[] user;
    GuessGame[] range;
    int rangeValue;
    int value = 0;

    public void main() {


        user = new GuessGame[10_000];
        for (int i = 0; i < 10_000; i++) {
            user[i] = new GuessGame();
        }
        range = new GuessGame[user.length];
        for (int i = 0; i < user.length; i++) {
            range[i] = new GuessGame();
            range[i].rangeValue = i;
        }
        for (int x = 0; x < 100; x++) {
            answer = 1 + (int) (Math.random() * 10);
            for (int i = 0; i < 10_000; i++) {
                user[i].userGuess = 1 + (int) (Math.random() * 10);
            }
            for (int i = 0; i < 10_000; i++) {
                if (answer == user[i].userGuess) {
                    user[i].rightUserGuess += 1;
                }
            }
        }
        for (int i = 0; i < 10_000; i++) {
            for (int j = i + 1; j < 10_000; j++) {
                if (user[i].rightUserGuess == user[j].rightUserGuess) {

                }
            }
        }
        for (int i = 0; i < user.length; i++) {
            for (int j = 0; j < user.length; j++) {
                if (user[i].rightUserGuess == range[j].rangeValue) {
                    range[j].value++;
                }
            }
        }
        System.out.println("игрок 1 угадал " + user[0].rightUserGuess + " раз.");
        System.out.println("игрок 2 угадал " + user[1].rightUserGuess + " раз.");
        System.out.println("игрок 3 угадал " + user[9000].rightUserGuess + " раз.");
        System.out.println(range[10].value);
    }
}
