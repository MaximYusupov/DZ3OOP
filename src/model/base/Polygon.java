package model.base;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class Polygon extends Figure implements Peremetr {
    /**
     * Инициализация многоугольника
     * @param nSides Число сторон
     * @param lSides Длины сторон (Double[])
     */
    public Polygon(Integer nSides, Double[] lSides) throws Exception {
        if(nSides == null || nSides <= 0)
            throw new Exception("Неверное количество граней!");
        this.nSides = nSides;
        for (Double len: lSides) {
            if(len == null || len <= 0.0)
                throw new Exception("Неверное значение размера грани!");
        }
        this.lSides = Arrays.stream(lSides).toList();
    }

    public Double[] getlSides() {
        // преобразуем список в массив, т.к. с массивом проще работать в дальнейшем:
        Double[] dblArray = new Double[lSides.size()];
        dblArray = lSides.toArray(dblArray);
        return dblArray;
    }

    /**
     * Число граней
     */
    private Integer nSides;
    /**
     * Список с длинами сторон
     */
    private List<Double> lSides = new LinkedList<>();

    /**
     * Вычисление периметра многоугольника
     * @return
     */
    @Override
    public Double getPeremetr() {
        Double res = 0.0;
        for (Double side : lSides) {
                res += side;
        }
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        boolean res = true;
        for (int i = 0; i < this.nSides; i++) {
          res &= (((Polygon) obj).getlSides()[i].equals(lSides.get(i)));
        }
        return res;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "Количество сторон=" + nSides +
                ", Длины сторон=" + lSides +
                ", Периметр=" + getPeremetr() +
                ", Площадь=" + getArea() +
                '}';
    }
}
