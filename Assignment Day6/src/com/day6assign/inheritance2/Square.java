package com.day6assign.inheritance2;

public class Square extends Rectangle {



    public Square()
    {

    }



    public Square(double side,String color,boolean filled)
    {

        super(side,side,color,filled);
    }

    @Override
    public String toString()
    {
        return " A square with side= "+width+" , which is subclass of "+super.toString();
    }


}
