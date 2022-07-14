package com.tact.contact.domain.repository;

import java.util.Arrays;
import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tact.contact.domain.model.Contact;
import com.tact.core.domain.model.PageList;
import com.tact.core.domain.model.QueryParam;
import com.tact.core.domain.utilitary.DataBaseUtils;
import com.tact.core.domain.utilitary.ValidatorUtils;

public interface ContactRepository extends JpaRepository<Contact, Long>, JpaSpecificationExecutor<Contact>{

	default PageList<Contact> findAllPaged(QueryParam params) {
		Specification<Contact> filters = getFilters(params);

		Page<Contact> page = findAll(filters, getPageable(params));
		if (params.getPage() > page.getTotalPages()) {
			params.setPage(page.getTotalPages());
			page = findAll(filters, getPageable(params));
		}

		return new PageList<Contact>()
				.inPage(page.getNumber() + 1)
				.withContent(page.getContent())
				.withTotalPages(page.getTotalPages())
				.withTotalRecords(page.getTotalElements());
	}

	default Pageable getPageable(QueryParam params) {
		if (params == null)
			return PageRequest.of(0, 20);

		return PageRequest.of(params.getPage() - 1, params.getLimit(), Sort.by(Sort.Direction.fromString(params.getDirection()), getOrder(params.getOrder())));
	}

	default String getOrder(String order) {
		return Arrays.asList("id", "name").contains(order) ? order : "id";
	}

	default Specification<Contact> getFilters(QueryParam params) {
		if (Objects.isNull(params) || ValidatorUtils.isNullOrEmpty(params.getTerm()))
			return null;

		return Specification.where(nameContains(params.getTerm()));
	}

	static Specification<Contact> nameContains(String term) {
	    return (contact, cq, cb) -> DataBaseUtils.Ilike(cb, contact.get("name"), term);
	}
}
