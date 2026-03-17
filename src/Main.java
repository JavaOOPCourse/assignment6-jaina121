import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();

        // ====================== TASK 1 ======================
        // TODO: Добавь минимум 5 студентов (ключ = ID)
        students.put("S1", new Student("Ali", 3.5, 20));
        students.put("S2", new Student("Bek", 3.8, 21));
        students.put("S3", new Student("John", 3.5, 22));
        students.put("S4", new Student("Anna", 3.9, 19));
        students.put("S5", new Student("Mike", 3.2, 23));

        // TODO: Напечатай всех студентов (ID + объект)
        // Print all
        System.out.println("All students:");
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        // TODO: Найди студента по ID и выведи его
        System.out.println("\nFind S3:");
        System.out.println(students.get("S3"));

        // TODO: Удали одного студента по ID
        students.remove("S5");

        // TODO: Обнови GPA у одного студента
        students.get("S1").setGpa(3.9);

        // ====================== SORTING (IMPORTANT) ======================
        // TODO: Создай ArrayList из всех студентов (students.values())
        List<Student> list = new ArrayList<>(students.values());

        // TODO 6a: Отсортируй по GPA (natural ordering) и выведи
        Collections.sort(list);
        System.out.println("\nSorted by GPA:");
        list.forEach(System.out::println);

        // TODO 6b: Отсортируй по имени (Comparator) и выведи
        list.sort(Comparator.comparing(Student::getName));
        System.out.println("\nSorted by Name:");
        list.forEach(System.out::println);

        // ====================== TASK 2 ======================
        System.out.println("\n=== Task 2: Top 3 by GPA ===");
        // TODO: Создай новый список, отсортируй по GPA по убыванию, выведи первые 3
        List<Student> topList = new ArrayList<>(students.values());
        topList.sort((a, b) -> Double.compare(b.getGpa(), a.getGpa()));

        for (int i = 0; i < Math.min(3, topList.size()); i++) {
            System.out.println(topList.get(i));
        }
        // ====================== TASK 3 ======================
        System.out.println("\n=== Task 3: Students with same GPA ===");
        // TODO: Сгруппируй студентов по GPA и выведи только те, где больше 1 студента
        HashMap<Double, List<String>> gpaMap = new HashMap<>();

        for (Student s : students.values()) {
            gpaMap.putIfAbsent(s.getGpa(), new ArrayList<>());
            gpaMap.get(s.getGpa()).add(s.getName());
        }

        for (Map.Entry<Double, List<String>> entry : gpaMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println("GPA " + entry.getKey() + " -> " + entry.getValue());
            }
        }
        // ====================== TASK 4 ======================
        System.out.println("\n=== Task 4: Courses ===");
        HashMap<Course, List<Student>> courseMap = new HashMap<>();
        // TODO: Создай 2–3 курса, добавь студентов, выведи всё

        Course math = new Course("Math");
        Course java = new Course("Java");

        courseMap.put(math, new ArrayList<>());
        courseMap.put(java, new ArrayList<>());

        courseMap.get(math).add(students.get("S1"));
        courseMap.get(math).add(students.get("S2"));

        courseMap.get(java).add(students.get("S3"));
        courseMap.get(java).add(students.get("S4"));

        for (Map.Entry<Course, List<Student>> entry : courseMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // ====================== TASK 5 ======================
        System.out.println("\n=== Task 5: GPA desc + Name ===");
        // TODO: Создай Comparator (GPA убывание → если равно, то имя возрастание) и отсортируй
        List<Student> customSort = new ArrayList<>(students.values());

        customSort.sort((a, b) -> {
            int gpaCompare = Double.compare(b.getGpa(), a.getGpa());
            if (gpaCompare != 0) return gpaCompare;
            return a.getName().compareTo(b.getName());
        });

        customSort.forEach(System.out::println);
    }
}




