package com.gojek.autopark.process;

public class Driver {
	public static void main(String[] args) {
		ParkingLot parkingLot = new ParkingLot();

		parkingLot.createParkingSlot(6);
		String[] attributes = new String[2];
		attributes[0] = "KA­01­HH­1234";
		attributes[1] = "White";
		parkingLot.parkVehicle(attributes);

		String[] attributes1 = new String[2];
		attributes1[0] = "KA­01­HH­1235";
		attributes1[1] = "Blue";
		parkingLot.parkVehicle(attributes1);

		String[] attributes2 = new String[2];
		attributes2[0] = "KA­01­HH­1734";
		attributes2[1] = "Black";
		parkingLot.parkVehicle(attributes2);

		parkingLot.showStatus();

		parkingLot.releaseVehicle(2);

		parkingLot.showStatus();

		String[] attributes3 = new String[2];
		attributes3[0] = "KA­01­HH­1235";
		attributes3[1] = "White";
		parkingLot.parkVehicle(attributes3);

		parkingLot.showStatus();

		// TODO Need to convert the getegistrationNosByColour and
		// getSlotNosByColour to Factory Method

		parkingLot.getegistrationNosByColour("White");

		parkingLot.getegistrationNosByColour("Silver");

		parkingLot.getSlotNosByColour("White");

		parkingLot.getSlotNosByColour("Silver");

		parkingLot.getSlotNosByRegNo("KA­01­HH­1734");

		parkingLot.getSlotNosByRegNo("TN­01­HH­1734");

	}
}
