package solid.liskov.example2.before;

public class Woodpecker extends Bird {
    
    @Override
    public void fly(){
        System.out.println("I can fly");
    };
    
    @Override
    public void walk(){
        System.out.println("I can walk");
    };
}
