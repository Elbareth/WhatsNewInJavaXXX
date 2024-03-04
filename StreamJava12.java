/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.util.stream.*;
import java.math.BigInteger;

public class Main
{
	public static void main(String[] args) {
		List<Integer> listka = new ArrayList<>();
		for(int i = 0; i < 100; i++)
		{
		    listka.add((int) (Math.random() * 100));
		}
		//couting how many elements is bigger than 50
	    long counter = listka.stream().filter(it -> it > 50).count();
	    System.out.println(counter);
	    //async version of prev. operation
	    long counter2 = listka.parallelStream().filter(it -> it > 50).count();
	    System.out.println(counter2);
	    
	    /*Stream creation*/
	    //create stream based on anything
	    Stream<String> random = Stream.of("a", "b", "c", "d", "e");
	    //create stream based on sub-array
	    int from = 5;
	    int to = 15;
	    int[] arr = {1,2,3,4,5,6};
	    IntStream subArray = Arrays.stream(arr, from, to);
	    //create empty Stream
	    Stream<String> empty = Stream.empty();
	    //create infinity stream based on given pattern
	    Stream<Double> randomInfinityDouble = Stream.generate(Math::random);
	    //create infinity stream of integers
	    Stream<BigInteger> infinityInt = Stream.iterate(BigInteger.ZERO, it -> it.add(BigInteger.ONE));
	    //stream with null only - size 0
	    Stream<Integer> nullElement = Stream.ofNullable(null);
	}
}
