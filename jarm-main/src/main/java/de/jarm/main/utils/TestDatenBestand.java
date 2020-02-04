package de.jarm.main.utils;

import java.util.ArrayList;
import java.util.List;

import de.jarm.main.data.DataController;
import de.jarm.main.data.Message;

public class TestDatenBestand {
	private static DataController data = DataController.getInstance();
	
	public static void test() {
		try {
			data.getUserService().create("Manni0", "Manfred");
			data.getUserService().create("Manni1", "Manfred");
			data.getUserService().create("Manni2", "Manfred");
			data.getUserService().create("Manni3", "Manfred");
			data.getUserService().create("Manni4", "Manfred");
			data.getUserService().create("Manni5", "Manfred");
			data.getUserService().create("Manni6", "Manfred");
			data.getProjectService().create("Kreatives Projekt 0", data.getUserService().getUser("Manni2"));
			data.getProjectService().create("Kreatives Projekt 1", data.getUserService().getUser("Manni0"));
			data.getProjectService().create("Kreatives Projekt 2", data.getUserService().getUser("Manni4"));
			data.getProjectService().create("Kreatives Projekt 3", data.getUserService().getUser("Manni5"));
			data.getProjectService().create("Kreatives Projekt 4", data.getUserService().getUser("Manni4"));
			data.getProjectService().create("Kreatives Projekt 5", data.getUserService().getUser("Manni3"));
			data.getProjectService().create("Kreatives Projekt 6", data.getUserService().getUser("Manni0"));
			List<Message> messages1 = new ArrayList<>();
			messages1.add(new Message("hi", data.getUserService().getUser("Manni1")));
			messages1.add(new Message("hi Manni 1", data.getUserService().getUser("Manni4")));
			messages1.add(new Message("hi guys", data.getUserService().getUser("Manni3")));
			messages1.add(new Message("hi, how are you??", data.getUserService().getUser("Manni0")));
			data.getProjectService().getProjectList().get(0).setMessages(messages1);
			data.getProjectService().getProjectList().get(1).setMessages(messages1);
			data.getProjectService().getProjectList().get(2).setMessages(messages1);
			data.getProjectService().getProjectList().get(3).setMessages(messages1);
			data.getProjectService().getProjectList().get(4).setMessages(messages1);
			
		} catch (ValidierungsException e) {
			e.printStackTrace();
		}
	}
}
