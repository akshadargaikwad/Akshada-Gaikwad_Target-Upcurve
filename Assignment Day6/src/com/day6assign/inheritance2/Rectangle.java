package com.day6assign.inheritance2;

public class Rectangle extends Shape {

    double width=1.0;
    double length=1.0;

    public Rectangle()
    {

    }

    public Rectangle(double width,double length)
    {
        this.width=width;
        this.length=length;
    }

    public Rectangle(double width,double length,String color,boolean filled)
    {
        super(color,filled);
        this.width=width;
        this.length=length;

    }

    public double getWidth()
    {
        return this.width;
    }

    public void setWidth(double width)
    {
        this.width=width;

    }

    public double setLength()
    {
        return this.length;
    }

    public void setLength(double length)
    {
        this.length=length;
    }

    @Override
    public double getArea()
    {
         return width*length;
    }

    @Override
    public double getPerimeter()
    {
      return 2*(length+width);
    }

    @Override
    public String toString()
    {
        return "A square with side= "+width+" , which is subclass of "+super.toString();
    }


}
