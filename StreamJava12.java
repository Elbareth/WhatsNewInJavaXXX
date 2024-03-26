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
	    //map - it allows you to convert stream in specific way
	    random.map(String::toUpperCase).forEach(System.out::print);
	    //create stream based on sub-array
	    int from = 2;
	    int to = 5;
	    int[] arr = {1,2,3,4,5,6};
	    IntStream subArray = Arrays.stream(arr, from, to);
	    //create empty Stream
	    Stream<String> empty = Stream.empty();
	    //create infinity stream based on given pattern
	    Stream<Double> randomInfinityDouble = Stream.generate(Math::random);
	    //Using method limit we can limit our stream to n elements
	    Stream.generate(Math::random).limit(10).forEach(System.out::println);
	    //You can skip x first elements of the stream
	    Stream.generate(Math::random).skip(10).limit(10).forEach(System.out::println);
	    //we take elements until the condition is fullfilled
	    Stream.generate(Math::random).limit(10).takeWhile(it -> it >= 0.5).forEach(System.out::println);
	    //we skip element when the condition is fullfilled
	    Stream.generate(Math::random).limit(10).dropWhile(it -> it >= 0.5).forEach(System.out::println);
	    //create infinity stream of integers
	    Stream<BigInteger> infinityInt = Stream.iterate(BigInteger.ZERO, it -> it.add(BigInteger.ONE));
	    //stream with null only - size 0
	    Stream<Integer> nullElement = Stream.ofNullable(null);
	    //We concatenate few stream in one
	    Stream<String> first = Stream.of("a", "b", "c", "d");
	    Stream<String> second = Stream.of("z", "x", "y");
	    Stream.concat(first, second).forEach(System.out::print);
	    System.out.println("");
	    //We remove duplicates
	    Stream.of("a","a","b","b","b","c").distinct().forEach(System.out::print);
	    System.out.println("");
	    //We sort our stream. We can enter here also Comparator
	    Stream.of(1,9,7,-10,22,5288444,20223,-55454844).sorted().forEach(System.out::println);
	    //We can call following method for every object in the stream
	    Stream.generate(Math::random).limit(10).peek(it -> System.out.print("Pojawił się nowy element "+it+" "));
	    System.out.println("First element that fullfill the condition = " + Stream.generate(Math::random).filter(it -> it > 0.5).findFirst());
	    System.out.println("Any element that fullfill the condition - async = " + Stream.generate(Math::random).filter(it -> it > 0.5).findAny());
	    System.out.println("Is there element that fullfill the condtion = "+Stream.generate(Math::random).anyMatch(it -> it > 0.5));
	    
	}
}