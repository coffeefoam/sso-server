/*
 * Created by IntelliJ IDEA.
 * User: ray
 * Date: 12-9-18
 * Time: 下午12:18
 */
package net.yoomai.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import net.yoomai.config.GlobalConfig;
import net.yoomai.service.TemplateService;
import org.apache.velocity.app.VelocityEngine;

public class TemplateModule extends AbstractModule {
	protected void configure() {
		bind(String.class).annotatedWith(Names.named("encode")).toInstance(GlobalConfig.get("encode"));
		bind(String.class).annotatedWith(Names.named("path")).toInstance(GlobalConfig.get("template.path"));
		bind(TemplateService.class).asEagerSingleton();
	}

	@Provides
	VelocityEngine getEngine() {
		return new VelocityEngine();
	}
}
