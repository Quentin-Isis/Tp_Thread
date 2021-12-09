package bandeau;

import java.util.LinkedList;
import java.util.List;

public class MonThread extends Thread{
    private Bandeau b;
    private List<ScenarioElement> myElements = new LinkedList<>();
    public MonThread(Bandeau b, List<ScenarioElement> l){
        this.b =b;
        this.myElements=l;
    }
    public void run() {
        synchronized(b){
            for (ScenarioElement element : myElements) {
                for (int repeats = 0; repeats < element.repeats; repeats++) {
                    element.effect.playOn(b);
                }
            }
        }
    }

}
