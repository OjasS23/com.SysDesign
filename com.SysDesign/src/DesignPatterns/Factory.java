package DesignPatterns;

interface Shape{
    void draw();
}

class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("Drawing a Rectangle");
    }
}

class ShapeFactory{
    public Shape getShape(String shapeType){
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        return null;
    }
}

// Logistic Interface
interface Logistics {
    void send();
}

// Class implementing the Logistics Interface
class Road implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by road logic");
    }
}

// Class implementing the Logistics Interface
class Air implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by air logic");
    }
}

// Factory Class taking care of Logistics
class LogisticsFactory {
//    Making the method static won't require us to create the object of LogisticsFactory
    public static Logistics getLogistics(String mode) {
        if (mode.equalsIgnoreCase("Air")) {
            return new Air();
        } else if (mode.equalsIgnoreCase("Road")) {
            return new Road();
        }
        throw new IllegalArgumentException("Unknown logistics mode: " + mode);
    }
}

// Class implementing the Logistics Services
class LogisticsService {
    public void send(String mode) {
        /* Using the Logistics Factory to get the
        desired object based on the mode */
        Logistics logistics = LogisticsFactory.getLogistics(mode);
        logistics.send();
    }
}


public class Factory {
    public static void main(String[] args) {
//        ShapeFactory shapeFactory = new ShapeFactory();
//        Shape shape1 = shapeFactory.getShape("circle");
//        shape1.draw();

        LogisticsService service = new LogisticsService();
        service.send("Air");
        service.send("Road");
    }
}
