package com.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KafkaConsumer {

	public static void main(String[] args) {
		System.out.println("Please input file full path:");
		Scanner scn = new Scanner(System.in);
		Path path = Paths.get(scn.nextLine());
		scn.close();

		Map<String, Integer> map = new HashMap<>();
		String consumerName = null;
		try (BufferedReader br = Files.newBufferedReader(path)) {
			while ((consumerName = br.readLine()) != null) {
				if (!(consumerName.equals("CLIENT-ID")) && !(consumerName.equals(""))) {
					if (map.containsKey(consumerName)) {
						map.put(consumerName, map.get(consumerName) + 1);
					} else {
						map.put(consumerName, 1);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("All consumers from 1-10 should have count = 20");
		System.out.println();
		map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + ": count: " + entry.getValue()));
	}

}
