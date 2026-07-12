package Selenium.Selenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams_maps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names=new ArrayList<String>();
		names.add("Akhi");
		names.add("gunji");
		names.add("Hi");
		names.add("Hello");
		names.add("Alien");
		
		int count=0;
		for (String name:names) {
			if (name.startsWith("A")) {
				System.out.println(name);
			}
			
		}
		names.stream().filter(n->n.startsWith("A")).forEach(System.out::println);
		long count1=names.stream().filter(n->n.startsWith("A")).count();
		System.out.println(count1);
		names.stream().filter(n->n.length()>3).forEach(System.out::println);
		names.stream().filter(n->n.length()>3).limit(1).forEach(System.out::println);
		
		//maps
		names.stream().filter(n->n.startsWith("g")).map(n->n.toUpperCase()).forEach(System.out::println);
		names.stream().filter(n->n.startsWith("A")).sorted().map(n->n.toUpperCase()).forEach(System.out::println);
		
		ArrayList<String> names1=new ArrayList<String>();
		names.add("Hihihi");
		names.add("Hellohi");
		names.add("byebye");
		 
		Stream<String> newStream=Stream.concat(names.stream(), names1.stream());
		newStream.sorted().forEach(s-> System.out.print(s));
		
		boolean flag = names.stream()
                .anyMatch(s -> s.equalsIgnoreCase("Akhi"));

		System.out.println(flag);
		
		List<String> ls=names.stream().filter(s->s.endsWith("i")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		//print all nos removing duplicates
		
		List<Integer> ls1=Arrays.asList(3,2,2,1,9,4,4,3);
		ls1.stream().distinct().forEach(s->System.out.print(s));
		System.out.println("---------------------");
		List<Integer> ls2=Arrays.asList(3,2,1,9,4,3);
		ls2.stream().sorted().collect(Collectors.toList()).forEach(s->System.out.print(s));

		
		
		
		
	}

}
