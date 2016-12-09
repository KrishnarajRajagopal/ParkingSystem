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
		}
	}

	void releaseVehicle(Vehicle vehicle) {
		if (!isEmpty()) {
			Iterator<ParkingSpace> itr = fullParkingSpaces.iterator();

			while (itr.hasNext()) {
				ParkingSpace parkingSpace = itr.next();

				if (parkingSpace.getVehicle().equals(vehicle)) {
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
		System.out.println("Slot Number\tRegistration No\tColour");
		for (ParkingSpace parkingSpace : fullParkingSpaces) {
			System.out.println(parkingSpace.getSlotNumber() + "\t" + parkingSpace.getVehicle().getNumber() + "\t"
					+ parkingSpace.getVehicle().getColour());
		}
	}
}
