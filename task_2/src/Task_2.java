public class Task_2 implements Task_2_base {
    @Override
    public int subtask_1_while(int num) {
        // Найти максимальное число, являющееся полным квадратом,
        // не превосходящее заданное натуральное num
        int x = 0;
        int k = 1;
        int max = 1;
        while (x!=1){
            if (k*k<=num){
                max = k * k;
                k = k + 1;}
            else
                x=x+1;
        }
        return max;
    }

    @Override
    public int subtask_2_while(int num) {
        // Последовательность целых чисел p(n) определяется следующим образом:
        // p(0) = 1
        // p(k) = 2 * p(k - 1) + 6, k > 0
        //Найти элемент последовательности с номером num
        int k = 0;
        int p = 1;
        if (num>=0) while (k != num) {
            p = 2 * p + 6;
            k = k + 1;
        }
        return p;


        }

    @Override
    public boolean subtask_3_while(int num, int base) {
        // Проверить, является ли число num натуральной степенью числа base
    int x=1;
    while (base>0){
        x=x*base;
        base=base-1;
    }
        return x == num;
    }

    @Override
    public int subtask_4_while(int start, int end) {
        // Вычислить, за какое минимальное число операций
        // вычесть 1
        // поделить на 2
        // число start можно превратить в end. Гарантируется, что start >= end >= 1
        int x = 0;
        while (start!=end) {
            if (end*2<start)
                start = start - 1;
            else
                start = start / 2;
            x = x + 1;
        }
        return x;
    }
}
