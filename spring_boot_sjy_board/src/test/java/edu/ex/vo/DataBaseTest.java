package edu.ex.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class DataBaseTest {

	@Autowired
	private DataSource dataSource;

	@Test
	void testDataBase() {
		assertNotNull(dataSource);
		log.info("DataSource = " + dataSource);
	}

	@Test
	void testConnection() {
		try (Connection connection = dataSource.getConnection()) {
			assertThat(connection).isInstanceOf(Connection.class);
			assertEquals(100, getLong(connection, "select 100 from dual"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private long getLong(Connection conn, String sql) {
		long result = 0;
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				result = rs.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}
}
