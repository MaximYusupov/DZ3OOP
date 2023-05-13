package model.base;

public abstract class Figure implements Comparable<Figure>{
    /**
     * Вычисление площади фигуры
     * @return Площадь
     */
    public abstract Double getArea();

    @Override
    public int compareTo(Figure o) {
        return this.getArea() < o.getArea() ? -1 : this.getArea() > o.getArea() ? 1 : 0;
    }
}
