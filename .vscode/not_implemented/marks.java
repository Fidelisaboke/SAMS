import java.util.ArrayList;
import java.util.List;

// Observer pattern implementation
interface Observer {
    void update(Marks subject);
}

class Marks {
    private List<Observer> observers;
    private String state;

    public Marks() {
        observers = new ArrayList<>();
        state = "null";
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    public String getState() {
        return state;
    }
}

class MarksObserver implements Observer {
    @Override
    public void update(Marks subject) {
        System.out.println("Marks for " + subject.getState());
    }
}

// Usage example
public class Main {
    public static void main(String[] args) {
        Marks math = new Marks();
        Marks english=new Marks();
        Marks science=new Marks();

        // Create and register observers
        Observer observer1 = new MarksObserver();
        Observer observer2 = new MarksObserver();

        math.registerObserver(observer1);
        english.registerObserver(observer1);
        science.registerObserver(observer1);


        // Set the initial state
        math.setState("null");
        english.setState("null");
        science.setState("null");

        // Simulate state changes
        math.setState("45");
        english.setState("50");
        science.setState("98");

    }
}