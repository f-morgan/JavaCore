import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class Sorts {
    private int[] dreamTeam = new int[10];

    public int[] bubbleSort(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = (array.length - 1); i > 0; i--) {
                if (array[i] > array[i - 1]) {
                    array = swap(array, i, (i -1));
                    isSorted = false;
                }
            }
        }
        printDreamTeam(array);
        return array;
    }

    public int[] mergeSort(int[] teamFirst, int[] teamSecond,int[] teamThird) {
        int[] array = merge(merge(teamFirst, teamSecond), teamThird);
        System.arraycopy(array, 0, dreamTeam, 0, 10);
        System.out.println(Arrays.toString(dreamTeam));
        return dreamTeam;
    }

    public int[] quickSort(int[] teams) {
        qSort(teams, 0, teams.length - 1);
        printDreamTeam(teams);
        return teams;
    }

    public int[] countSort(int[] teams) {
        int[] counts = new int[51];
        for (int i = 0; i < teams.length; i++) {
            counts[teams[i] - 1] += 1;
        }

        int count = 50;
        for (int i = 0; i < dreamTeam.length; i++) {
            while (counts[count] == 0) {
                count -= 1;
            }
            dreamTeam[i] = count + 1;
            counts[count] -= 1;

        }
        System.out.println(Arrays.toString(dreamTeam));
        return dreamTeam;
    }

    public Integer[] streamAPI(int[] teamFirst, int[] teamSecond, int[] teamThird) {
        Integer[] arr = Stream.of(teamFirst, teamSecond, teamThird) // объединяем массивы
                .flatMapToInt(Arrays::stream) // в один стрим
                .boxed() // преобразуем примитвы int в Integer, иначе дальше ничего не будет работать
                //.sorted((a, b) -> Integer.compare(b, a))
                // сортируем, т.к. нужно обратный порядок используем
                //compare, но берем числа в порядке a и b, но сравниваем b и а и получится по убыванию сортировка
                .sorted(Comparator.reverseOrder())
                .limit(10) // берем первые 10 остальные не нужны
                .toArray(Integer[]::new); // результат преобразовываем в массив
        System.out.println(Arrays.toString(arr));
        return arr;

    }

    public int[] mergedTeams(int[] teamFirst, int[] teamSecond,int[] teamThird, int[] teams) {
        System.arraycopy(teamFirst, 0, teams, 0, teamFirst.length);
        System.arraycopy(teamSecond, 0, teams, 10, teamSecond.length);
        System.arraycopy(teamThird, 0, teams, 20, teamThird.length);
        return teams;
    }

    private int[] merge(int[] arrayFirst, int[] arraySecond) {
        int[] array = new int[arrayFirst.length + arraySecond.length];
        int iFirst = 0;
        int iSecond = 0;
        int iArray = 0;

        while (iFirst < arrayFirst.length || iSecond < arraySecond.length) {
            if (iFirst == arrayFirst.length) {
                array[iArray] = arraySecond[iSecond];
                iSecond++;
            } else if (iSecond == arraySecond.length) {
                array[iArray] = arrayFirst[iFirst];
                iFirst++;
            } else {
                if (arrayFirst[iFirst] >= arraySecond[iSecond]) {
                    array[iArray] = arrayFirst[iFirst];
                    iFirst++;
                } else {
                    array[iArray] = arraySecond[iSecond];
                    iSecond++;
                }
            }
            iArray++;
        }
        return array;
    }

    private void qSort(int[] array, int from, int to) {
        if (from < to) {
            int devideIndex = pivoting(array, from, to);
            qSort(array, from, devideIndex - 1);
            qSort(array, devideIndex, to);
        }
    }

    private int pivoting(int[] array, int from, int to) {
        int right = to;
        int left = from;

        int pivot = array[from + (to - from) / 2];

        while (left <= right) {
            while (array[left] > pivot) {
                left++;
            }
            while (array[right] < pivot) {
                right--;
            }
            if(left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public int[] swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        return array;
    }

    private void printDreamTeam(int[] teams) {
        System.arraycopy(teams, 0, dreamTeam, 0, 10);
        System.out.println(Arrays.toString(dreamTeam));
    }
}
