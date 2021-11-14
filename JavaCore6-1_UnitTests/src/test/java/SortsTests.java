import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortsTests {
    Sorts sut;

    @BeforeEach
    public void init() {
        System.out.println("Test started");
        sut = new Sorts();
    }

    @BeforeAll
    public static void started() {
        System.out.println("Tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("Test finished");
    }

    @AfterAll
    public static void finshedAll() {
        System.out.println("Tests completed");
    }

    @Test
    public void testSwap() {
        //arrange
        int[] test = {1, 15}, expected = {15, 1};

        //act
        int[] result = sut.swap(test, 0, 1);

        //assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void testBubbleSort() {
        //arrange
        int[] test = {10, 8, 9, 14}, expected = {14, 10, 9, 8};

        //act
        int[] result = sut.bubbleSort(test);

        //assert
        assertArrayEquals(expected,result);
    }

    @Test
    public void testStreamAPI() {
        //arrange
        int[] arr1 = {8, 3, 9}, arr2 = {2, 17, 10, 11}, arr3 = {1, 98, 4, 5};
        Integer[] expected = {98, 17, 11, 10, 9, 8, 5, 4, 3, 2};

        //act
        Integer[] result = sut.streamAPI(arr1, arr2, arr3);

        //assert
        assertArrayEquals(expected, result);
    }
}
