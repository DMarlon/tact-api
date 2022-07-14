package com.tact.core.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueryParamTest {
	private static final String ORDER = "description";
	private static final String DIRECTION = "ASC";
	private static final String TERM = "bart";

	QueryParam queryParam_null;
	QueryParam queryParam_trim;

	@BeforeEach
	public void init() {
		queryParam_null = new QueryParam();
		queryParam_null.setOrder(null);
		queryParam_null.setDirection(null);
		queryParam_null.setTerm(null);

		queryParam_trim = new QueryParam();
		queryParam_trim.setOrder(" "+ORDER+" ");
		queryParam_trim.setDirection(" "+DIRECTION+" ");
		queryParam_trim.setTerm(" "+TERM+" ");
	}

	@Test
	public void create_initial_values() {
		QueryParam params = new QueryParam();
		assertEquals(params.getPage(), 1);
		assertEquals(params.getLimit(), 20);
		assertEquals(params.getOrder(), "");
		assertEquals(params.getDirection(), "ASC");
		assertEquals(params.getTerm(), "");
	}

	@Test
	public void page_less_or_equals_zero() {
		QueryParam params = new QueryParam();
		params.setPage(0);
		assertEquals(params.getPage(), 1);
		params.setPage(-1);
		assertEquals(params.getPage(), 1);
	}

	@Test
	public void limit_less_or_equals_zero() {
		QueryParam params = new QueryParam();
		params.setLimit(0);
		assertEquals(params.getLimit(), 1);
		params.setLimit(-1);
		assertEquals(params.getLimit(), 1);
	}

	@Test
	public void setOrder_null_value() {
		assertNull(queryParam_null.getOrder());
	}

	@Test
	public void setDirection_null_value() {
		assertNull(queryParam_null.getDirection());
	}

	@Test
	public void setTerm_null_value() {
		assertNull(queryParam_null.getTerm());
	}

	@Test
	public void setOrder_trim_value() {
		assertEquals(queryParam_trim.getOrder(), ORDER);
	}

	@Test
	public void setDirection_trim_and_upper_value() {
		assertEquals(queryParam_trim.getDirection(), DIRECTION);
	}

	@Test
	public void setDirection_invalid_value() {
		QueryParam params = new QueryParam();
		params.setDirection("ABC");
		assertEquals(queryParam_trim.getDirection(), DIRECTION);
	}

	@Test
	public void setTerm_trim_value() {
		assertEquals(queryParam_trim.getTerm(), TERM);
	}
}
