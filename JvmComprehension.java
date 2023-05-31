//Класс JvmComprehension загружается в область памяти MetaSpace
//через систему загрузчиков классов ClassLoader
public class JvmComprehension {

    //создается фрейм main в Stack Memory
    public static void main(String[] args) {

        int i = 1;                      // 1 создается во фрейме main переменная i и присваивается ей значение 1

        Object o = new Object();        // 2 в heap выделяется память под объект Object,
                                        // далее отработает конструктор под Object,
                                        // далее во фрейме будет присвоена переменная со ссылкой на объект object
        Integer ii = 2;                 // 3 в heap выделяется память под объект Integer со значением 2,
                                        // а в Stack Memory создается перменная ii со ссылкой на объект
        printAll(o, i, ii);             // 4 в Stack Memory создается новый фрейм printAll,
                                        // в нем записываются переменные со ссылками на объекты o, i, ii
        System.out.println("finished"); // 7 в Stack Memory создается фрейм println, в который записывается переменная
                                        // со ссылкой на созданный в heap объект String со значением finished
    }


    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 В heap создается выделяется память под объект Integer со значением 700
                                                    //во фрейме printAll создается переменная uselessVar со ссылкой на значение из heap
        System.out.println(o.toString() + i + ii);  // 6 //в Stack Memory создается фрейм println и фрейм toString. в printLn передаются ссылки на объекты o, i, ii
    }
}

// в момент исполнения кода переодически работает Garbage Collector