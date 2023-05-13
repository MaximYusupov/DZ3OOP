package model;

import model.base.*;

public class Triangle extends Polygon // класс треугольник
{
    public Triangle(Double a, Double b, Double c) throws Exception // треугольник(сторона a, сторона b, стоорна c)
    {
        super(3, new Double[]{a, b, c});
        if (!(a + b > c && a + c > b && b + c > a))
            throw new Exception("Невозможно создать треугольник с заданными сторонами");
    }

    @Override
    public Double getArea()
    {
        Double p = super.getPeremetr() / 2; // площадь треугольника
        // Площадь треугольника по формуле Герона есть квадратный корень из произведения полупериметра
        // и его разностей с каждой из длин сторон треугольника.
        // Формула Герона, S = √ (p * (p-a) * (p-b) * (p-c). Где p - полупериметр фигуры, то есть: p = (a+b+c)/2.
        return Math.sqrt(p * (p - getlSides()[0]) * (p - getlSides()[1]) * (p - getlSides()[2]));
    }
}