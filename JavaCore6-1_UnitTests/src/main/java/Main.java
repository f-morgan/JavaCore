import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] teamFirst = {45, 31, 24, 22, 20, 17, 14, 13, 12, 10};
        int[] teamSecond = {31, 18, 15, 12, 10, 8, 6, 4, 2, 1};
        int[] teamThird = {51, 30, 10, 9, 8, 7, 6, 5, 2, 1};
        int[] teams = new int[30];


        Scanner scanner = new Scanner(System.in);
        Sorts sort = new Sorts();
        int choice;

        while (true) {
            System.out.println("Выберите способ сортировки: \n" +
                    "1. Метод Пузырька (Bubble Sort) \n" +
                    "2. Сортировка слиянием (Merge Sort) \n" +
                    "3. Быстрая сортировка (Quick Sort) \n" +
                    "4. Сортировка подсчетом (Count Sort) \n" +
                    "5. Сортировка при помощи Stream API (тема из JavaCore) \n" +
                    "0. Выход из программы");
            choice = scanner.nextInt();

            if (choice == 0) {
                break;
            } else {
                switch (choice) {
                    case 1:
                        sort.bubbleSort(sort.mergedTeams(teamFirst, teamSecond,teamThird, teams));
                        break;
                    case 2:
                        sort.mergeSort(teamFirst, teamSecond,teamThird);
                        break;
                    case 3:
                        sort.quickSort(sort.mergedTeams(teamFirst, teamSecond,teamThird, teams));
                        break;
                    case 4:
                        sort.countSort(sort.mergedTeams(teamFirst, teamSecond,teamThird, teams));
                        break;
                    case 5:
                        sort.streamAPI(teamFirst, teamSecond, teamThird);
                        break;
                    default:
                        System.out.println("Такая сортировка автором не реализована :)");
                }
            }
        }
    }

}
