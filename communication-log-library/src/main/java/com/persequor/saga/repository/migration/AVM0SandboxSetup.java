package com.persequor.saga.repository.migration;

import com.persequor.extension.migration.ISandboxMigration;
import com.persequor.extension.migration.migrator.SandboxMigrator;
import com.persequor.saga.repository.RequestResponseModuleSqlDbConfig;

public class AVM0SandboxSetup implements ISandboxMigration {
	@Override
	public void up(SandboxMigrator migrator) throws Exception {
		migrator.sqlAdmin().createDatabaseAndUser(RequestResponseModuleSqlDbConfig.class);
	}
}
