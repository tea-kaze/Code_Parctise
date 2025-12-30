//package Practice_Code;

abstract class shape {
    String name;
    public shape(String name) {
        this.name = name;
    }
    abstract double calculateArea();
    
}

class Rectangle extends shape {

    double length;
    double width;

    public Rectangle(String name, double length, double width) {
        super(name);
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }
}



class text_code {

     
}