package Dzien5;

public interface InterfacesExample {

    void addSomething();

    default void somethingElse(){
        System.out.println("No way");
    }


}
