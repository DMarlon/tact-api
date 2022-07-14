package com.tact.core.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PageableTest {

	@Test
	public void create_with_values_zero_or_less() {
		Pageable pageable = new Pageable(0, 0, 0);
		assertEquals(pageable.getStartPosition(), 0);
		assertEquals(pageable.getLimit(), 1);
		assertEquals(pageable.getTotalPage(), 0);

		pageable = new Pageable(-1, -1, -1);
		assertEquals(pageable.getStartPosition(), 0);
		assertEquals(pageable.getLimit(), 1);
		assertEquals(pageable.getTotalPage(), 0);
	}

	@Test
	public void currentPage_and_limit_greate_them_totalOfRecords() {
		Pageable pageable = new Pageable(3, 10, 5);
		assertEquals(pageable.getStartPosition(), 0);
		assertEquals(pageable.getLimit(), 10);
		assertEquals(pageable.getTotalPage(), 1);
	}

	@Test
	public void totalOfRecords_not_exactly_divisible_by_limit() {
		Pageable pageable = new Pageable(4, 3, 10);
		assertEquals(pageable.getStartPosition(), 9);
		assertEquals(pageable.getLimit(), 3);
		assertEquals(pageable.getTotalPage(), 4);
	}

	@Test
	public void currentPage_nonexistent() {
		Pageable pageable = new Pageable(38, 3, 10);
		assertEquals(pageable.getStartPosition(), 9);
		assertEquals(pageable.getLimit(), 3);
		assertEquals(pageable.getTotalPage(), 4);
	}
}
