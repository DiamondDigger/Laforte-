//HighArray.java
//класс массива с высокоуровневым интерфейсом
/////////////////////////////////////////////

class HighArray {
            private long[] a;                   // ссылка на массив а
            private int nElems;                 // кол-во элементов массива

            public HighArray (int max){         // Конструктор
                a = new long[max];              // создание массива
                nElems = 0;                     // количество элементов
            }

            public boolean find(long searchkey){
                int j;
                for (j = 0; j < nElems; j ++)   // для каждого элемента
                    if (a[j] == searchkey)      // значение найдено?
                        break;                  // Да - выход из цикла
                    if (j == nElems)            // Последний элемент достигнут?
                        return false;           // Да
                    else
                        return true;            // Нет
            }

            public void insert (long value){
                a[nElems] = value;              // вставка
                nElems++;                       // увеличение размера
            }

            public boolean delete (long value){
                int j;
                for (j = 0; j < nElems; j ++)    // поиск значения
                    if (a[j] == nElems)
                        break;
                    if ( j == nElems)             //  найти не удалось
                        return false;
                    else {                                      // значение найдено
                        for (int k = j; k < nElems; k ++)       // сдвиг элементов
                            a[k] = a[k+1];
                        nElems --;                              // уменьшение размера
                        return true;
                    }
            }

            public void display(){                   // вывод содержимого массива
                for (int j = 0; j < nElems; j ++)    // для каждого элемента
                    System.out.print(a[j] + "");     // вывод
                System.out.println();
            }
        }

public class HighArrayApp {
    public static void main(String[] args) {
        HighArray arr;                              // создаем ссылку на массив
        int maxSize = 20;
        arr = new HighArray(maxSize);

        arr.insert(34);                      // вставка элементов
        arr.insert(75);
        arr.insert(21);
        arr.insert(43);
        arr.insert(100);
        arr.insert(67);
        arr.insert(98);
        arr.insert(31);
        arr.insert(21);
        arr.insert(1);

        arr.display();                              // вывод элементов

        int searchKey = 75;                         // поиск элемента
        if (arr.find(searchKey))
            System.out.println("Found" + searchKey);
        else
            System.out.println("Can't find" + searchKey);

        arr.delete(43);                       // удаление трех элементов
        arr.delete(21);
        arr.delete(98);

        arr.display();                              // удаление трех элементов
    }
}


