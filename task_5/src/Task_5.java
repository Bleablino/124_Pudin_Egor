import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Task_5 implements Task_5_base {
    @Override
    public ArrayList<Integer> subtask_1_ArrayList(ArrayList<Integer> data, int k, int n) {
        // Выбрать из данного списка элементы, кратные k, но не кратные n
        // и сформировать из них новый список.
        // Вернуть новый список в качестве результата
        ArrayList<Integer> mass = new ArrayList<>();
        for(Integer i : data){
            if((i%k == 0) && (i%n != 0))
                mass.add(i);
        }
        return mass;
    }

    @Override
    public ArrayList<Integer> subtask_2_ArrayList(int size) {
        // сгенерировать и вернуть список размера size,
        // содержащий первые size элементов последовательности, описанной в
        // задаче subtask_2_for задания task_3
        ArrayList<Integer> mass = new ArrayList<>();
        for(int i = 1; i <= size; i++){
            int n = 0;
            if(mass.size() < size)
                while(n < i && mass.size() < size){
                    mass.add(i);
                    n++;
                }
            else
                break;
        }
        return mass;
    }

    @Override
    public HashSet<Integer> subtask_3_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите пересечение множеств s1 и s2
        HashSet<Integer> mass = new HashSet<>(s1);
        mass.retainAll(s2);
        return mass;
    }

    @Override
    public HashSet<Integer> subtask_4_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите объединение множеств s1 и s2
        HashSet<Integer> mass = new HashSet<>();
        mass.addAll(s1);
        mass.addAll(s2);
        return mass;

    }

    @Override
    public HashSet<Integer> subtask_5_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите дополнение множества s1 до множества s2
        HashSet<Integer> mass = new HashSet<>();
        mass.addAll(s1);
        mass.addAll(s2);
        mass.removeAll(s1);
        return mass;

    }

    @Override
    public HashSet<Integer> subtask_6_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // постройте множество, содержащее элементы, содержащиеся либо только в s1,
        // либо только в s2, но не в обоих множествах одновременно
        HashSet<Integer> mass = new HashSet<>();
        for(Integer i : s1)
            if(s2.contains(i))
                continue;
            else
                mass.add(i);
        for(Integer i : s2)
            if(s1.contains(i))
                continue;
            else
                mass.add(i);
        return mass;
    }

    @Override
    public HashMap<String, Double> subtask_7_HashMap(ArrayList<String> data) {
        // Дан список строк. Построить словарь, содержащий частоты слов
        // для данного списка в процентах
        HashMap<String, Double> mass = new HashMap<>();
        int count = 0;
        for(String i : data){
            String[] words = i.split(" ");
            for(String j : words){
                if(mass.containsKey(j))
                    mass.put(j, mass.get(j) + 1);
                else
                    mass.put(j, 1.0);
                count++;
            }}
        for(HashMap.Entry <String, Double> entry : mass.entrySet()){
            double pr = (entry.getValue()*100)/count;
            entry.setValue(pr);
        }
        return mass;
    }

    @Override
    public HashMap<String, Double> subtask_8_HashMap(ArrayList<Double> data) {
        // Дан список чисел. Сформировать словарь, содержащий среднее,
        // максимальное и минимальное значения из данного списка. Ключи
        // словаря "mean", "max", "min" соответственно
        double max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, sum = 0;
        for(Double i : data){
            sum += i;
            if(i > max)
                max = i;
            if(i < min)
                min = i;}
        HashMap<String, Double> mass = new HashMap<>();
        mass.put("mean", sum/data.size());
        mass.put("max", max);
        mass.put("min", min);
        return mass;
    }
}
