package com.day6assign.inheritance2;

public abstract class Shape {

    String color="blue";
    boolean filled=true;

    public Shape()
    {

    }

    public Shape(String color,boolean filled)
    {
        this.color=color;
        this.filled=filled;
    }

    public String getColor()
    {
        return this.color;
    }

    public void setColor(String color)
    {
        this.color=color;
    }

    public boolean isFilled()
    {
        return this.filled;
    }

    public void setFilled(boolean filled)
    {
        this.filled=filled;
    }

    public  String toString()
    {
        return "A shape with color of "+ color+" and "+( filled? "filled" : "not filled");
    }

    public abstract double getArea();
    public abstract double getPerimeter();
}
