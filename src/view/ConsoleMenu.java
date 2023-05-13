package view;

import model.*;
import model.base.Figure;
import model.base.Polygon;
import presenter.Collection;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;

public class ConsoleMenu
{
    public ConsoleMenu() throws Exception
    {
        mainDB.addFigure(new Circle(Math.random()*100.0));
        mainDB.addFigure(new Square(Math.random()*100.0));
        mainDB.addFigure(new Rectangle(Math.random()*100.0,Math.random()*100.0));
        Double rnd = Math.random()*100.0;
        mainDB.addFigure(new Triangle(rnd,rnd,rnd));
    }

    private Collection mainDB = new Collection();
    private PrintWriter pw = new PrintWriter(System.out, true);
    private Scanner scan = new Scanner(System.in);

    public void getMainMenu() throws Exception
    {
        int cmd = 0;
        do
        {
            pw.println("1. Вывод информации о всех периметрах, площадях и длиннах окружности\n" +
                    "2. Добавить фигуру\n" +
                    "3. Удалить фигуру\n" +
                    "4. Изменить фигуру");

            cmd = getIntValue("команды: ");
            switch (cmd)
            {
                case 1:
                    this.calculateAllData();
                    break;
                case 2:
                    this.getMenuAddNewFig();
                    break;
                case 3:
                    this.removeFigure();
                    break;
                case 4:
                    this.editFig();
                    break;
            }
        } while (cmd != 0);
    }

    private void calculateAllData() // Вывод всех площадей и периметров фигур
    {
        int currIndex = 0;
        mainDB.sort();
        for (Figure fig : mainDB)
        {
            pw.println("Фигура " + fig.getClass().getSimpleName() + " с индексом " + currIndex++);
            pw.println("Площадь = " + fig.getArea());
            if (fig instanceof Polygon)
                pw.println("Периметр = " + ((Polygon) fig).getPeremetr());
            if (fig instanceof Circle)
                pw.println("Длина окружности = " + ((Circle) fig).getLen());
            pw.println("");
        }
    }

    private void getMenuAddNewFig() throws Exception // добавление новой фигуры
    {
        int res = 0;
        pw.println("1. Треугольник\n" +
                "2. Квадрат\n" +
                "3. Прямоугольник\n" +
                "4. Круг");
        switch (getIntValue("команды: "))
        {
            case 1:
                res = mainDB.addFigure(new Triangle(getDblValue("сторону a"),
                        getDblValue("сторону b"),
                        getDblValue("сторону c")));
                break;
            case 2:
                res = mainDB.addFigure(new Square(getDblValue("длину стороны")));
                break;
            case 3:
                res = mainDB.addFigure(new Rectangle(getDblValue("длину"), getDblValue("высоту")));
                break;
            case 4:
                res = mainDB.addFigure(new Circle(getDblValue("радиус")));
                break;

        }
        if (res == 0)
            pw.println("Фигура успешно добавлена");
        else
            pw.println("Ошибка добавления");
    }

    private void removeFigure() // удаление фигуры
    {
        int res = mainDB.removeFigure(getIntValue("индекс удаляемой фигуры"));
        if (res == 0)
            pw.println("фигура успешно удалена");
        else
            pw.println("ошибка удаления фигуры");
    }

    private void editFig() throws Exception // редактировать фигуры
    {
        int index = getIntValue("индекс фигуры");
        int res = 0;
        String className = mainDB.getFigure(index).getClass().getSimpleName();
        pw.println(mainDB.getFigure(index));
        switch (className)
        {
            case "Circle":
                res = mainDB.editFigure(new Circle(getDblValue("радиус")),index);
                break;
            case "Rectangle":
                res = mainDB.editFigure(new Rectangle(getDblValue("длину"), getDblValue("высоту")),index);
                break;
            case "Square":
                res = mainDB.editFigure(new Square(getDblValue("длину стороны")),index);
                break;
            case "Triangle":
                res = mainDB.editFigure(new Triangle(getDblValue("сторону a"),
                        getDblValue("сторону b"),
                        getDblValue("сторону c")),index);
                break;
            default:
                res = -1;
        }
        switch (res)
        {
            case -1:
                pw.println("Ошибка изменения");
                break;
            case 0:
                pw.println("Изменения записаны успешно");
                break;
            case 1:
                pw.println("Изменений не внесено");
                break;
        }
    }

    private int getIntValue(String msg) // получение целочисленного значения от пользователя
    {
        pw.println("Введите номер " + msg);
        return scan.nextInt();
    }

    private Double getDblValue(String msg) // получение числа с плавающей точкой от пользователя
    {
        pw.println("Введите " + msg + " (с плавающей точкой. Пример: 2,0):");
        return scan.nextDouble();
    }

    private String getStrValue(String msg) // получение строкового значения от пользователя
    {
        pw.println("Введите " + msg + " (строка):");
        return scan.nextLine();
    }
}
