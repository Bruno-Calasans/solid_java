package solid.liskov.example2.before;

public class Peguin extends Bird {

    @Override
    public void fly(){
       throw new RuntimeException("I cant fly");
    };

    @Override
    public void walk(){
        System.out.println("I can walk");
    };
    
    
}
