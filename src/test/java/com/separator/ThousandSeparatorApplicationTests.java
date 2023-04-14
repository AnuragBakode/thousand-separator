package com.separator;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.separator.service.ThousandFormatterService;

@SpringBootTest
class ThousandSeparatorApplicationTests {
	
	@Autowired
	ThousandFormatterService thousandformatterservice;

	@Test
	void contextLoads() {
	}
	
	@Test
	void thousandSeparatorTests() {
		assertThat(thousandformatterservice.thousandFormatter(new BigDecimal("1234.50")).equals("1,234.50"));
		assertThat(thousandformatterservice.thousandFormatter(new BigDecimal("-1234.50")).equals("-1,234.50"));
		assertThat(thousandformatterservice.thousandFormatter(new BigDecimal("0.345")).equals("0.345"));
		assertThat(thousandformatterservice.thousandFormatter(new BigDecimal("12345678.0923")).equals("12,345,678.0923"));
		assertThat(thousandformatterservice.thousandFormatter(new BigDecimal("234.50")).equals("234.50"));
		assertThat(thousandformatterservice.thousandFormatter(new BigDecimal("-5649385634856394857.3573948573049")).equals("-5,649,385,634,856,394,857.3573948573049"));
		assertThat(thousandformatterservice.thousandFormatter(new BigDecimal("0.0000000000000000000000000000000000000000000001")).equals("0.0000000000000000000000000000000000000000000001"));
		assertThat(thousandformatterservice.thousandFormatter(new BigDecimal("-0.0000000000000000000000000000000000000000000001")).equals("-0.0000000000000000000000000000000000000000000001"));
		assertThat(thousandformatterservice.thousandFormatter(new BigDecimal("10")).equals("10"));
		assertThat(thousandformatterservice.thousandFormatter(new BigDecimal("-5")).equals("-5"));
		assertThat(thousandformatterservice.thousandFormatter(new BigDecimal("0.001")).equals("0.001"));
	}

}
