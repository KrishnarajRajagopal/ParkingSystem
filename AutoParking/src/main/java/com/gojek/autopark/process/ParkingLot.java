package com.gojek.autopark.process;

import java.util.Iterator;
import java.util.Vector;

import com.gojek.autopark.vo.ParkingSpace;
import com.gojek.autopark.vo.ParkingType;
import com.gojek.autopark.vo.Vehicle;

public class ParkingLot {

	// Vector<ParkingSpace> vacantParkingSpaces = null;
	// Vector<ParkingSpace> fullParkingSpaces = null;

	Vector<ParkingSpace> vacantParkingSpaces = new Vector<ParkingSpace>();
	Vector<ParkingSpace> fullParkingSpaces = new Vector<ParkingSpace>();

	int parkingSpaceCount = 0;

	boolean isFull;
	boolean isEmpty;

	ParkingSpace findNearestVacant(ParkingType type) {
		Iterator<ParkingSpace> itr = vacantParkingSpaces.iterator();

		while (itr.hasNext()) {
			ParkingSpace parkingSpace = itr.next();

			if (parkingSpace.getParkingType() == type) {
				return parkingSpace;
			}
		}
		return null;
	}

	void parkVehicle(ParkingType type, Vehicle vehicle) {
		if (!isFull()) {
			ParkingSpace parkingSpace = findNearestVacant(type);

			if (parkingSpace != null) {
				parkingSpace.setVehicle(vehicle);
				parkingSpace.setVacant(false);

				vacantParkingSpaces.remove(parkingSpace);
				fullParkingSpaces.add(parkingSpace);

				if (fullParkingSpaces.size() == parkingSpaceCount)
					isFull = true;

				isEmpty = false;
			}
		} else {
			System.out.println("Sorry, parking lot is full");
		}
	}

	// void releaseVehicle(Vehicle vehicle) {
	void releaseVehicle(int slotNumber) {
		if (!isEmpty()) {
			Iterator<ParkingSpace> itr = fullParkingSpaces.iterator();

			while (itr.hasNext()) {
				ParkingSpace parkingSpace = itr.next();

				// if (parkingSpace.getVehicle().equals(vehicle)) {
				if (parkingSpace.getSlotNumber() == slotNumber) {
					fullParkingSpaces.remove(parkingSpace);
					vacantParkingSpaces.add(parkingSpace);

					parkingSpace.setVacant(true);
					parkingSpace.setVehicle(null);

					if (vacantParkingSpaces.size() == parkingSpaceCount)
						isEmpty = true;

					isFull = false;
				}
			}
		}
	}

	boolean isFull() {
		return isFull;
	}

	boolean isEmpty() {
		return isEmpty;
	}

	public void createParkingSlot(int slotCount) {
		for (int i = 1; i < slotCount + 1; i++) {
			ParkingSpace parkingSpace = new ParkingSpace();
			parkingSpace.setSlotNumber(i);
			parkingSpace.setParkingType(ParkingType.REGULAR);
			vacantParkingSpaces.add(parkingSpace);
			System.out.println("Allocated slot number: " + parkingSpace.getSlotNumber());
		}
	}

	public void parkVehicle(String[] attributes) {
		Vehicle vehicle = new Vehicle();
		vehicle.setNumber(attributes[0]);
		vehicle.setColour(attributes[1]);
		parkVehicle(ParkingType.REGULAR, vehicle);
	}

	public void showStatus() {
		System.out.println("Parked Place details");
		System.out.println("Slot Number\tRegistration No\tColour");
		for (ParkingSpace parkingSpace : fullParkingSpaces) {
			System.out.println(parkingSpace.getSlotNumber() + "\t" + parkingSpace.getVehicle().getNumber() + "\t"
					+ parkingSpace.getVehicle().getColour());
		}
		System.out.println("===================================================");
		System.out.println("Free Space details");
		System.out.println("Slot Number\tRegistration No\tColour");

		for (ParkingSpace parkingSpace : vacantParkingSpaces) {
			System.out.println(parkingSpace.getSlotNumber() + "\t" + parkingSpace.getVehicle());
		}
		System.out.println("===================================================");
	}

	public void getegistrationNosByColour(String colour) {
		System.out.println("Get Registration Number of Cars Using Colour: " + colour);
		boolean foundFlag = false;
		if (!isEmpty()) {
			Iterator<ParkingSpace> itr = fullParkingSpaces.iterator();

			while (itr.hasNext()) {
				ParkingSpace parkingSpace = itr.next();
				if (parkingSpace.getVehicle().getColour().equals(colour)) {
					System.out.println(parkingSpace.getSlotNumber() + "\t" + parkingSpace.getVehicle().getNumber()
							+ "\t" + parkingSpace.getVehicle().getColour());
					foundFlag = true;
				}
			}
			if (!foundFlag) {
				System.out.println("Not found");
			}
		}
		System.out.println("===================================================");
	}

	public void getSlotNosByColour(String colour) {
		System.out.println("Get Slot Number Using Car colour: " + colour);
		boolean foundFlag = false;
		if (!isEmpty()) {
			Iterator<ParkingSpace> itr = fullParkingSpaces.iterator();

			while (itr.hasNext()) {
				ParkingSpace parkingSpace = itr.next();
				if (parkingSpace.getVehicle().getColour().equals(colour)) {
					System.out.println(parkingSpace.getSlotNumber() + "\t" + parkingSpace.getVehicle().getNumber()
							+ "\t" + parkingSpace.getVehicle().getColour());
					foundFlag = true;
				}
			}
			if (!foundFlag) {
				System.out.println("Not found");
			}
		}

		else {

		}
		System.out.println("===================================================");
	}

	public void getSlotNosByRegNo(String registrationNo) {
		System.out.println("Get Slot Number Using Car Registration Number: " + registrationNo);
		boolean foundFlag = false;
		if (!isEmpty()) {
			Iterator<ParkingSpace> itr = fullParkingSpaces.iterator();

			while (itr.hasNext()) {
				ParkingSpace parkingSpace = itr.next();
				if (parkingSpace.getVehicle().getNumber().equals(registrationNo)) {
					System.out.println(parkingSpace.getSlotNumber() + "\t" + parkingSpace.getVehicle().getNumber()
							+ "\t" + parkingSpace.getVehicle().getColour());
					foundFlag = true;
				}
			}

			if (!foundFlag) {
				System.out.println("Not found");
			}
		}
		System.out.println("===================================================");
	}
}
