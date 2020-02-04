package de.jarm.main.utils;

import de.jarm.main.data.DataController;

public class TestDatenBestand {
	
	public static void main(String[] args) {
		try {
			DataController.getInstance().getUserService().create("Manni0", "Manfred");
			DataController.getInstance().getUserService().create("Manni1", "Manfred");
			DataController.getInstance().getUserService().create("Manni2", "Manfred");
			DataController.getInstance().getUserService().create("Manni3", "Manfred");
			DataController.getInstance().getUserService().create("Manni4", "Manfred");
			DataController.getInstance().getUserService().create("Manni5", "Manfred");
			DataController.getInstance().getUserService().create("Manni6", "Manfred");
		} catch (ValidierungsException e) {
			e.printStackTrace();
		}
	}
}
