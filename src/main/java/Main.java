import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {

        Fork fork = new Fork();

        fork.addFork();
        fork.addFork();
        fork.addFork();
        fork.addFork();
        fork.addFork();

        Library library = new Library();

        Philosoph philosoph1 = new Philosoph(fork,"Иван", 0);
        Philosoph philosoph2 = new Philosoph(fork,"Константин", 1);
        Philosoph philosoph3 = new Philosoph(fork,"Степан", 2);
        Philosoph philosoph4 = new Philosoph(fork,"Николай", 3);
        Philosoph philosoph5 = new Philosoph(fork,"Павел", 4);

        library.addPhilosoph(philosoph1);
        library.addPhilosoph(philosoph2);
        library.addPhilosoph(philosoph3);
        library.addPhilosoph(philosoph4);
        library.addPhilosoph(philosoph5);

        library.tableStart();

    }
}
















