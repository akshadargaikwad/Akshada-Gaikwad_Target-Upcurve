package com.day6assign.inheritance2;

public class Program {

    public static void main(String[] args)
    {
        Shape[] shapes={new Circle(3.0,"red",true),
                new Rectangle(4.0, 5.0, "blue", false),
                new Square(6.0, "green", true),
                new Circle(2.5, "yellow", true),
                new Rectangle(3.0, 7.0, "orange", false),
                new Square(4.5, "purple", true),
                new Circle(1.8, "cyan", true),
                new Rectangle(2.0, 9.0, "pink", false),
                new Square(7.0, "brown", true),
                new Circle(3.5, "gray", true)};

        for(Shape shape:shapes)
        {
            System.out.println(shape);
            System.out.println("Area : "+shape.getPerimeter() );
            System.out.println("Perimeter : "+shape.getPerimeter());

            System.out.println();
        }
    }
}
