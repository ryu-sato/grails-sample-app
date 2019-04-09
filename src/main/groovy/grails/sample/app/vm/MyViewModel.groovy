package grails.sample.app.vm;

import grails.transaction.Transactional

import org.springframework.stereotype.Component

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver
import org.zkoss.zkplus.spring.DelegatingVariableResolver

@Component
@Transactional
@VariableResolver(DelegatingVariableResolver.class)
public class MyViewModel {
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