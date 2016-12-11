package com.gojek.autopark.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
	public static void main(String[] args) throws IOException {
		ParkingLot parkingLot = new ParkingLot();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			{
				System.out.println("Enter Input");
				String userInput = br.readLine();
				String[] attributes = userInput.split(" ");

				if (attributes[0].equals("create_parking_lot")) {
					parkingLot.createParkingSlot(Integer.parseInt(attributes[1]));
				}

				if (attributes[0].equals("park")) {
					parkingLot.parkVehicle(attributes);
				}

				if (attributes[0].equals("leave")) {
					parkingLot.releaseVehicle(Integer.parseInt(attributes[1]));
				}

				if (attributes[0].equals("status")) {
					parkingLot.showStatus();
				}

				if (attributes[0].equals("registration_numbers_for_cars_with_colour")) {
					parkingLot.getegistrationNosByColour(attributes[1]);
				}

				if (attributes[0].equals("slot_numbers_for_cars_with_colour")) {
					parkingLot.getSlotNosByColour(attributes[1]);
				}

				if (attributes[0].equals("slot_number_for_registration_number")) {
					parkingLot.getSlotNosByRegNo(attributes[1]);
				}
			}
		}
	}
}
