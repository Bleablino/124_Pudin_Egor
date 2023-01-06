public class Task_2 implements Task_2_base {
    @Override
    public int subtask_1_while(int num) {
        // Найти максимальное число, являющееся полным квадратом,
        // не превосходящее заданное натуральное num
        int x = 0;
        while (x*x<num){
            x++;
            if (x*x>num){
                x--;
                break;
            }
        }
        return x*x;
    }

    @Override
    public int subtask_2_while(int num) {
        // Последовательность целых чисел p(n) определяется следующим образом:
        // p(0) = 1
        // p(k) = 2 * p(k - 1) + 6, k > 0
        //Найти элемент последовательности с номером num
        int x = 1;
        int z = 0;
        while (z<num){
            x=2*x+6;
            z++;
        }
        return x;
    }

    @Override
    public boolean subtask_3_while(int num, int base) {
        // Проверить, является ли число num натуральной степенью числа base
        int z = base;
        while (z<num)
            z=z*base;
        return z==num;
    }

    @Override
    public int subtask_4_while(int start, int end) {
        // Вычислить, за какое минимальное число операций
        // вычесть 1
        // поделить на 2
        // число start можно превратить в end. Гарантируется, что start >= end >= 1
        int x = 0;
        while (start!=end) {
            if (start % 2 == 0 && start / 2 >= end)
                start = start / 2;
            else
                start--;
            x++;
        }return x;
    }
}
