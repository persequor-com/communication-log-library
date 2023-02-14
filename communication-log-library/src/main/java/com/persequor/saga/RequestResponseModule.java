package com.persequor.saga;

import com.persequor.extension.ExtensionInfo;
import com.persequor.extension.ioc.module.ExtensionModule;
import com.persequor.extension.ioc.module.IModuleSubConfiguration;

@ExtensionInfo(
		name = "Request Response Module",
		description = "Module for providing visualisation of outgoing communication and responses from other systems."
)
public class RequestResponseModule extends ExtensionModule {

	public RequestResponseContext context() {
		return this.getExtensionContext(RequestResponseContext.class);
	}

	public IModuleSubConfiguration defaultConfiguration() {
		return this.getSubConfigurationContext(RequestResponseConfiguration.class);
	}

	@Override
	public void defaultModuleConfiguration() {
		this.defaultConfiguration().require();
	}


}
