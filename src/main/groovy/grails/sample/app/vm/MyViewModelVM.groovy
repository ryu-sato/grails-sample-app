package grails.sample.app.vm;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class MyViewModelVM {
	private String name = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResponse() {
		return String.format("Hello %s!", name);
	}

	@NotifyChange("response")
	@Command
	public void submit() {
	}
}