package HomeWork;

public abstract class Animal{
    String type;
    String name;
    int maxRunDistance;
    int maxSwimDistance;
    boolean onDistance;

    public boolean isOnDistance(){
        return onDistance;
    }

    public Animal(String type, String name, int maxRunDistance, int maxSwimDistance){
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    public void run(int distance){
        if (distance <=maxRunDistance){
            System.out.println(type + " " + name + " " + " успешно пробежал");
        } else {
            System.out.println(type + " " + name + " " + " не смог пробежать");
            onDistance = false;
        }
    }

    public void swim(int distance){
        if (maxSwimDistance == 0){
            System.out.println(type + " " + name + " не умеет плавать");
            onDistance = false;
            return;
        }
        if (distance <=maxSwimDistance){
            System.out.println(type + " " + name + " " + " успешно проплыл");
        } else {
            System.out.println(type + " " + name + " " + " не смог проплыть");
            onDistance = false;
        }
    }

    public void showResult(){
        System.out.println(type + " " + name + ": " + onDistance);
    }
}
