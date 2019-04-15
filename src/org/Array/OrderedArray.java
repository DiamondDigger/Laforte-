package org.Array;

public class OrderedArray {
    private long[] a;               // Ссылка на массив а
    private int nElems;             // Количество элементов данных

    public OrderedArray(int max){   // Конструктор
        a = new long[max];          // Создание массива
        nElems = 0;
    }

    public int size(){
        return nElems;
    }

    public int find(long searchKey){
        int lowerBound = 0;
        int upperBound = nElems-1;
        int curIn;

        while (true){
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn]==searchKey)
                return curIn;                           // Элемент найден
            else if (lowerBound > upperBound)
                    return nElems;                      // Элемент не найден
            else {                                      // Деление диапозона
                 if (a[curIn] < searchKey)
                     lowerBound = curIn + 1;            // В верхней половине
                 else
                     upperBound = curIn - 1;            // В нижней половине
                 }
        }
    }

    public void insert(long value){                     // Вставка элемента в массив
        int j;
        for (j = 0; j < nElems; j++){                   // Определение позиции вставки
            if (a[j] > value)                           // Линейный поиск
                break;
        int i = find(value);                            // Добавляемый элемент
        if (i!= nElems)
            for ( j = nElems; j > i ; j --){
                    a[j] = a[j-1];
                }
                a[i] = value;                           // Добавляем элемент в массив
                nElems ++;
        }

        for (int k = nElems; k > j; k--)                // Перемещение последующих элементов
            a[k] = a[k-1];
        a[j] = value;                                   // Вставка
        nElems++;                                       // Увеличение размера
    }

    public boolean delete(long value){
        int j = find(value);
        if (j == nElems)
            return false;                               // Найти не удалось
        else {                                          // Элемент найден
            for (int k = j; k < nElems; k++)            // Перемещение следующих элементов
                a[k] = a[k+1];
            nElems--;                                   // Уменьшение размера
            return true;
        }
    }

    public void display(){                              // Вывод содержимого массива
        for (int j = 0; j < nElems; j++)                // Перебор всех элементов
            System.out.print(a[j] + " ");               // Вывод текущего элемента
        System.out.println();
    }
}
class OrderedArrayApp{
    public static void main(String [] args){
        int maxSize = 100;                              // Размер массива
        OrderedArray arr;                               // Ссылка на массив
        arr = new OrderedArray(maxSize);                // Создание массива

        arr.insert(44);                           // Вставка элементов
        arr.insert(99);
        arr.insert(14);
        arr.insert(32);
        arr.insert(45);
        arr.insert(67);
        arr.insert(88);
        arr.insert(12);

        arr.display();                                  // Вывод массива

        long searchKey = 44;
        if (arr.find(searchKey) != arr.size())          // Поиск элемента
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.display();

        arr.delete(32);                           // Удаление элементов массива
        arr.delete(14);
        arr.delete(44);

        arr.display();
    }
}