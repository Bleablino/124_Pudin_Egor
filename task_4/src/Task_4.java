import java.util.Arrays;
public class Task_4 implements Task_4_base {
    @Override
    public int[] subtask_1_arrays(int size, int a0, int d) {
        // сгенерировать и вернуть массив размера size, содержащий элементы
        // арифметической прогрессии с первым членом a0 и разностью d
        int[] mass = new int[size];
        mass[0] = a0;
        for (int i = 1; i < size; i++) {
            mass[i] = mass[i-1] + d;
        }
        return mass;
    }

    @Override
    public int[] subtask_2_arrays(int size) {
        // сгенерировать и вернуть массив размера size, первые два элемента
        // которого равны единице, а каждый следующий - сумме всех предыдущих
        int[] mass = new int[size];
        int x = 2;
        for (int i = 0;i<size;i++){
            if (i<2)
                mass[i]=1;
            else{
                mass[i]=x;
                x=x+x;}}
        return mass;
    }

    @Override
    public int[] subtask_3_arrays(int size) {
        // сгенерировать и вернуть массив размера size, содержащий первые
        // size чисел последовательности фибоначчи.
        // https://ru.wikipedia.org/wiki/Числа_Фибоначчи
        int[] mass = new int[size];
        for (int i = 0;i<size;i++){
            if (i<1)
                mass[i]=0;
            else if (i<2)
                mass[i]=1;
            else
                mass[i]=mass[i-1]+mass[i-2];
        }
        return mass;
    }

    @Override
    public int subtask_4_arrays(int[] data) {
        // Для данного массива вычислить максимальный элемент
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max)
                max = data[i];
        }
        return max;
    }

    @Override
    public int subtask_5_arrays(int[] data, int k) {
        // Для данного массива вычислить максимальный элемент
        // кратный k. Гарантируется, что как минумум один такой элемент
        // в массиве есть
        int max = Integer.MIN_VALUE;
        for (int datum : data) {
            if (datum > max && datum % k == 0)
                max = datum;
        }
        return max;
    }

    @Override
    public int[] subtask_6_arrays(int[] arr1, int[] arr2) {
        // Даны два массива arr1, arr2.
        // Произвести слияние данных массивов в один отсортированный
        // по возрастанию массив.
        int[] mass = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, mass, 0, arr1.length);
        System.arraycopy(arr2, 0, mass, arr1.length, arr2.length);
        Arrays.sort(mass);
        return mass;
    }

    @Override
    public int[] subtask_7_arrays(int[] arr1, int[] arr2) {
        // Даны два отсортированных по возрастанию массива arr1, arr2.
        // Произвести слияние данных массивов в один также отсортированный
        // по возрастанию массив.
        // Используйте алгоритм, время работы которого будет пропорционально сумме
        // размеров arr1 и arr2, а не их произведению
        int[] mass = new int[arr1.length + arr2.length];
        int a = 0;
        int b = 0;
        for (int i = 0; i < mass.length; i++) {
            if (a == arr1.length) {
                mass[i] = arr2[b];
                b++;
            } else if (b == arr2.length) {
                mass[i] = arr1[a];
                a++;
            } else if (arr1[a] < arr2[b]) {
                mass[i] = arr1[a];
                a++;
            } else {
                mass[i] = arr2[b];
                b++;
            }
        }
        return mass;
    }
}
