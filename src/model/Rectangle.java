package model;
import model.base.*;

public class Rectangle extends Polygon // Класс прямоугольник
{
    public Rectangle(Double width, Double height) throws Exception // Прямоугольник(ширина, высота)
    {
        super(4, new Double[]{width, height, width, height});
        if (width.equals(height))
            throw new Exception("Для квадрата отдельный класс Square");
    }

    // Перегрузка для инициализации квадрата
    public Rectangle(Double width) throws Exception
    {
        super(4, new Double[]{width, width, width, width});
    }

    @Override
    public Double getArea()
    {
        return getlSides()[0] * getlSides()[1]; // площиадь квадрата
    }
}
