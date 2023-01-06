public class Task_3 implements Task_3_base {
    @Override
    public int subtask_1_for(int n1, int n2, int a, int b) {
        // подсчитать, сколько чисел, кратных a, но не кратных b,
        // находится между числами n1 и n2 включительно
        int z = 0;
        if (n1<n2){
            for(int i = n1;i<=n2;i++){
                if (i%a==0 && i%b!=0)
                    z++;
            }}
        else {
            for(int i = n2;i<=n1;i++){
                if (i%a==0 && i%b!=0)
                    z++;
            }}
        return z;
    }

    @Override
    public int subtask_2_for(int num) {
        // Последовательность чисел строится следующим образом:
        // сначала идет одна единица,
        // потом две двойки,
        // потом три тройки,
        // ...
        // потом n раз число n
        // ...
        // Найти, какое число будет находиться в этой последовательности
        // на позиции num
        int a = 0;
        int z=num;
        for (int i = 1;i<num;i++){
            a=a+i;
            if (a>=num){
                z = i;
                break;
            }
        }
        return z;
    }

    @Override
    public int subtask_3_for(int num, int d, int cnt) {
        // Дана последовательность
        // a(0) = num
        // a(n) = a(n - 1) * d + 1
        // Найти сумму первых cnt элементов последовательности
        int z = num;
        int x = num;
        for (int i = 1;i<cnt;i++) {
            z = z * d + 1;
            x = x + z;
        }
        return x;
    }

    @Override
    public int subtask_4_for(int n) {
        // Вычислить сумму
        // S(n) = 1 + 1 * 2 + 1 * 2 * 3 + ... + n!
        // для заданного n
        // (n! - это n-факториал. Кто не знает - гуглите)
        int z = 1;
        int x = 1;
        for (int i = 2;i<=n;i++){
            z=z*i;
            x=x+z;
        }
        return x;
    }
}
