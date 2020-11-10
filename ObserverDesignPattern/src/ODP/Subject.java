package ODP;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

@SuppressWarnings("deprecation")
public class Subject  extends Observable implements Runnable {

    private int state;
    
    public Subject(int val) {
		this.setState(val);
	}

 public int getState() {
    return state;
 }

 @SuppressWarnings("deprecation")
public void setState(int state) {
    this.state = state;
    setChanged();
    notifyObservers(state);
 }

 public void subscribe(Observer observer){
    addObserver(observer);		
 }
 
 public void unsubscribe(Observer observer){
	deleteObserver(observer); }


@Override
public void run() {
try {
		while (!Thread.currentThread().isInterrupted()) {
			this.setState((this.getState() + 1) % 60);
			Thread.sleep(2000);
		}
	} catch (InterruptedException e) {
	}
}


}

