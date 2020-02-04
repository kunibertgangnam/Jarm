package de.jarm.main.utils;

import de.jarm.main.data.DataController;

public class TestDatenBestand {
	
	public static void main(String[] args) {
		try {
			DataController.getInstance().getUserService().create(0, "Manni0", "Manfred");
			DataController.getInstance().getUserService().create(1, "Manni1", "Manfred");
			DataController.getInstance().getUserService().create(2, "Manni2", "Manfred");
			DataController.getInstance().getUserService().create(3, "Manni3", "Manfred");
			DataController.getInstance().getUserService().create(4, "Manni4", "Manfred");
			DataController.getInstance().getUserService().create(5, "Manni5", "Manfred");
			DataController.getInstance().getUserService().create(6, "Manni6", "Manfred");
		} catch (ValidierungsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
