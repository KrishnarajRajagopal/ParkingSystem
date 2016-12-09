package com.gojek.autopark.process;

import java.util.Vector;

import com.gojek.autopark.vo.ParkingSpace;

public class Driver {
	public static void main(String[] args) {
		ParkingLot parkingLot = new ParkingLot();
		Vector<ParkingSpace> vacantParkingSpaces = new Vector<ParkingSpace>();
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
	}
}
