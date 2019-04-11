package org.Array;

public class OrderedArray {
    private long[] a;               // Ссылка на массив а
    private int nElems;             // Количество элементов данных

    public OrderedArray(int max){  // Конструктор
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
                return curIn;
            else if (lowerBound > upperBound)
                    return nElems;
                 else if (lowerBound < searchKey)
                        lowerBound = curIn + 1;
                      else
                        upperBound = curIn - 1;
        }
    }
}
