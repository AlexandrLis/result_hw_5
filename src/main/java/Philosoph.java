import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Philosoph extends Thread{

    public Fork fork;
    private String name;
    private int numberPhilosoph;
    Random random = new Random();
    private int counter = 3;

    public Philosoph(Fork fork, String name, int numberPhilosoph) {
        this.fork = fork;
        this.name = name;
        this.numberPhilosoph = numberPhilosoph;
    }


    public int getNumberPhilosoph() {
        return numberPhilosoph;
    }


    @Override
    public void run() {
        makesOfPhilosoph();
    }



    public void makesOfPhilosoph(){
        while (counter > 0){
            try {
                if(fork.canEating(getNumberPhilosoph())){
                    if(getNumberPhilosoph() == 0){
                        fork.makeFalse(fork.list.size() - 1, getNumberPhilosoph());
                        eat();
                        fork.makeTrue(fork.list.size() - 1, getNumberPhilosoph());
                        counter--;
                    }
                    else if (getNumberPhilosoph() == fork.list.size()) {
                        fork.makeFalse(getNumberPhilosoph(), 0);
                        eat();
                        fork.makeTrue(getNumberPhilosoph(), 0);
                        counter--;
                    }
                    else {
                        fork.makeFalse(getNumberPhilosoph() - 1, getNumberPhilosoph());
                        eat();
                        fork.makeTrue(getNumberPhilosoph() - 1, getNumberPhilosoph());
                        counter--;
                    }
                }
                else {
                    think();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }




    public void think() throws Exception{
        System.out.println("Философ " + name + " думает" + " | номер философа: " + getNumberPhilosoph());
        Thread.sleep(random.nextInt(1000, 3000));
    }

    public void eat() throws Exception{
        System.out.println("Философ " + name + " кушает" + " | номер философа: " + getNumberPhilosoph());
        Thread.sleep(random.nextInt(1000, 3000));
    }


    public static void me(Fork fork){
        for (Boolean b : fork.getForkList()) {
            System.out.println(b);
        }
    }


    @Override
    public String toString() {
        return name;
    }
}
