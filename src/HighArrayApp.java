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

}


