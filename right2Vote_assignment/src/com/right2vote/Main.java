package com.right2vote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Instrument[] instruments = {
		        new Instrument(3, 2 ^ 3, 10),
		        new Instrument(4, 3 ^ 3, 15),
		        new Instrument(2, 1 ^ 3, 8),
		        new Instrument(5, 4 ^ 3, 20)
		};
		
		

		int maxWeight = 10;
		int maxVolume = 7 ^ 3;
		
		Arrays.sort(instruments, new Comparator<Instrument>() {
		    @Override
		    public int compare(Instrument o1, Instrument o2) {
		        double ratio1 = (double) o1.value / o1.weight;
		        double ratio2 = (double) o2.value / o2.weight;
		        return Double.compare(ratio2, ratio1); // Sort in descending order
		    }
		});

		List<Instrument> s = check(instruments, maxWeight, maxVolume);

		System.out.println("Selected Instruments:");
		int totalWeight = 0;
		int totalVolume = 0;
		int totalValue = 0;
		for (Instrument i : s) {
			System.out.println(
					"Instrument with Weight: " + i.weight + " kg, Volume: " + i.volume + " m^3, Value: " + i.value);
			totalWeight += i.weight;
			totalVolume += i.volume;
			totalValue += i.value;
		}
		System.out.println("Total Weight: " + totalWeight + " kg");
		System.out.println("Total Volume: " + totalVolume + " m^3");
		System.out.println("Total Scientific Value: " + totalValue);
	}

	public static List<Instrument> check(Instrument[] instruments, int maxWeight, int maxVolume) {

		List<Instrument> ans = new ArrayList<>();
		int currentWeight = 0;
		int currentVolume = 0;

		for (Instrument inst : instruments) {
			if (currentWeight + inst.weight <= maxWeight && currentVolume + inst.volume <= maxVolume) {
				ans.add(inst);
				currentWeight += inst.weight;
				currentVolume += inst.volume;
			}
		}

		return ans;
	}
}
