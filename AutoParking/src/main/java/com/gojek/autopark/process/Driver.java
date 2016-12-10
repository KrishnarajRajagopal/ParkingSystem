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

		/*
		 * parkingLot.createParkingSlot(6); String[] attributes = new String[2];
		 * attributes[0] = "KA­01­HH­1234"; attributes[1] = "White";
		 * parkingLot.parkVehicle(attributes);
		 * 
		 * String[] attributes1 = new String[2]; attributes1[0] =
		 * "KA­01­HH­1235"; attributes1[1] = "Blue";
		 * parkingLot.parkVehicle(attributes1);
		 * 
		 * String[] attributes2 = new String[2]; attributes2[0] =
		 * "KA­01­HH­1734"; attributes2[1] = "Black";
		 * parkingLot.parkVehicle(attributes2);
		 */
		// parkingLot.showStatus();

		// parkingLot.releaseVehicle(2);

		// parkingLot.showStatus();

		/*
		 * String[] attributes3 = new String[2]; attributes3[0] =
		 * "KA­01­HH­1235"; attributes3[1] = "White";
		 * parkingLot.parkVehicle(attributes3);
		 */

		// parkingLot.showStatus();

		// TODO Need to convert the getegistrationNosByColour and
		// getSlotNosByColour to Factory Method

		/*
		 * parkingLot.getegistrationNosByColour("White");
		 * 
		 * parkingLot.getegistrationNosByColour("Silver");
		 * 
		 * parkingLot.getSlotNosByColour("White");
		 * 
		 * parkingLot.getSlotNosByColour("Silver");
		 * 
		 * parkingLot.getSlotNosByRegNo("KA­01­HH­1734");
		 * 
		 * parkingLot.getSlotNosByRegNo("TN­01­HH­1734");
		 */

	}
}
