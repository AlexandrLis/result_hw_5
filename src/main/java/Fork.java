import java.util.LinkedList;
import java.util.List;

public class Fork {

    List<Boolean> list = new LinkedList<>();

    public void addFork(){
        list.add(true);
    }

    public synchronized boolean canEating(int i){
        if(i == 0){
            if(list.get(i + 1) == true && list.get(list.size() - 1) == true){
                return true;
            }
        }
        else if (i == list.size() - 1) {
            if(list.get(0) == true && list.get(list.size() - 2) == true){
                return true;
            }
        }
        else if(i != 0 && i != list.size()){
            if(list.get(i - 1) == true && list.get(i + 1) == true){
                return true;
            }
        }
        return false;
    }


    public List<Boolean> getForkList(){
        return list;
    }


    public synchronized void makeTrue(int fork1, int fork2){
        list.set(fork1, true);
        list.set(fork2, true);
    }

    public synchronized void makeFalse(int fork1, int fork2){
        list.set(fork1, false);
        list.set(fork2, false);
    }

}
