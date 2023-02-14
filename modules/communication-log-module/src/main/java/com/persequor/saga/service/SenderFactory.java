package com.persequor.saga.service;

import com.persequor.extension.ioc.IModuleExtensionPointFactory;
import com.persequor.saga.RequestResponseContext;
import com.persequor.saga.service.model.IRequestSender;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class SenderFactory {

	Map<String, IRequestSender> requestSendersMap = new HashMap<>();
	@Inject
	public SenderFactory(IModuleExtensionPointFactory factory) {
		for (IRequestSender instance : factory.context(RequestResponseContext.class).getInstances(IRequestSender.class)) {
			requestSendersMap.put(instance.getClass().getCanonicalName(), instance);
		}
	}

	public <Request, T extends IRequestSender<Request>> IRequestSender<Request> get(Class<T> clazz) {
		return requestSendersMap.get(clazz.getCanonicalName());
	}
}
