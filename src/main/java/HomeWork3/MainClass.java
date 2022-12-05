package HomeWork3;



public class MainClass {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple(1.0f));
        appleBox.addFruit(new Apple(1.0f));
        appleBox.addFruit(new Apple(1.0f));
        appleBox.addFruit(new Apple(1.0f));
        appleBox.addFruit(new Apple(1.0f));
        appleBox.addFruit(new Apple(1.0f));

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange(1.5f));
        orangeBox.addFruit(new Orange(1.5f));
        orangeBox.addFruit(new Orange(1.5f));
        orangeBox.addFruit(new Orange(1.5f));

        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());

        System.out.println(orangeBox.compare(appleBox));
    }
}
