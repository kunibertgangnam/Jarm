package de.jarm.main.utils;

import de.jarm.main.data.DataController;

public class TestDatenBestand {
	
	public static void main(String[] args) {
		try {
			DataController.getInstance().getUserService().create(0, "Manni", "Manfred");
		} catch (ValidierungsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
