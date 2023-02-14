package com.persequor.saga.repository;

import com.persequor.extension.db.SqlDbPropertiesConfig;

public class RequestResponseModuleSqlDbConfig extends SqlDbPropertiesConfig {

	protected RequestResponseModuleSqlDbConfig() {
		super("psqr.request_response.mariadb");
	}

	@Override
	public String getDefaultDatabaseName() {
		return "psqr_request_response_module";
	}


}
