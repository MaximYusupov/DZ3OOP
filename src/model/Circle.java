package model;
import model.base.*;

public class Circle extends Figure implements CurvedLen // класс окружность
{
    public Circle(Double radius) throws Exception // окружность(радиус)
    {
        if (radius > 0.0)
            this.radius = radius;
        else
            throw new Exception("Неверное значение радуиса");
    }

    public Double getRadius()
    {
        return radius;
    }

    private Double radius; // радиус окружности

    @Override
    public Double getLen()
    {
        return 2.0 * Math.PI * radius;
    }

    @Override
    public Double getArea()
    {
        return Math.PI * Math.pow(radius, 2.0);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        return this.radius == ((Circle) obj).getRadius();
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + "{" +
                "Радиус=" + radius +
                ", Длина окружности=" + getLen() +
                ", Площадь=" + getArea() +
                '}';
    }
}
