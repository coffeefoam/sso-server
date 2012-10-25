package net.yoomai.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import net.yoomai.service.TemplateService;
import org.apache.velocity.app.VelocityEngine;

public class TemplateModule extends AbstractModule {
	protected void configure() {
		bind(TemplateService.class).asEagerSingleton();
	}

	@Provides
	public VelocityEngine getEngine() {
		VelocityEngine engine = new VelocityEngine();
		return engine;
	}
}
