package com.persequor.saga.repository.migration;

import com.persequor.extension.migration.IMigration;
import com.persequor.extension.migration.migrator.Migrator;
import com.persequor.saga.repository.RequestResponseModuleSqlDbConfig;
import com.valqueries.IOrm;
import com.valqueries.automapper.SqlGenerator;

import javax.inject.Inject;

public class HospitalModuleMariaDb2022122000RequestResponseLog implements IMigration {

	private final SqlGenerator generator;

	@Inject
	public HospitalModuleMariaDb2022122000RequestResponseLog(SqlGenerator generator) {

		this.generator = generator;
	}

	@Override
	public void up(Migrator migrator) {

		try (IOrm orm = migrator.sql(RequestResponseModuleSqlDbConfig.class).getOrm()) {
			//SQLGenerator-class can be used to easily get "create table"-string if changes to structure occur

			orm.update(
					"CREATE TABLE IF NOT EXISTS request_response_log_entry (" +
					"`id` VARCHAR(255) CHARACTER SET latin1, " +
					"`context` VARCHAR(255), " +
					"`log_id` CHAR(36) CHARACTER SET latin1, " +
					"`request` TEXT, " +
					"`request_time` DATETIME, " +
					"`response` TEXT, " +
					"`response_time` DATETIME, " +
					"`message_type` VARCHAR(255), " +
					"`request_accepted` BOOLEAN, " +
					"PRIMARY KEY(`id`, `context`, `log_id`), " +
					"INDEX `request_time_idx` (`request_time`)" +
					");");
			/*orm.update("CREATE TABLE IF NOT EXISTS day_matrix_db_model (" +
					"`id` CHAR(36) CHARACTER SET latin1, " +
					"`edited` DATETIME(6), " +
					"`name` VARCHAR(255), " +
					"`created` DATETIME, " +
					"`active` TINYINT(1), " +
					"`date` DATE, " +
					"`type` VARCHAR(255) CHARACTER SET latin1, " +
					"`priorities` MEDIUMTEXT, " +
					"`locked_by` CHAR(50) CHARACTER SET latin1, " +
					"`locked_time` DATETIME, " +
					"PRIMARY KEY(`id`));");*/
		}
	}
}
