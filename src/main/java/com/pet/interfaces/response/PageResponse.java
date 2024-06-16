package com.pet.interfaces.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class PageResponse<T> extends PageImpl<T> {

    public PageResponse(List content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public PageResponse(Page<T> page) {
        super(page.getContent(), page.getPageable(), page.getTotalElements());
    }

    @JsonIgnore
    @Override
    public Pageable getPageable() {
        return super.getPageable();
    }

    @JsonIgnore
    @Override
    public int getNumber() {
        return super.getNumber();
    }

    public PageWrapper getPage() {
        return new PageWrapper(this);
    }
    @JsonIgnore
    @Override
    public int getTotalPages() {
        return super.getTotalPages();
    }
    @JsonIgnore
    @Override
    public long getTotalElements() {
        return super.getTotalElements();
    }
    @JsonIgnore
    @Override
    public boolean hasNext() {
        return super.hasNext();
    }
    @JsonIgnore
    @Override
    public boolean isLast() {
        return super.isLast();
    }
    @JsonIgnore
    @Override
    public int getSize() {
        return super.getSize();
    }
    @JsonIgnore
    @Override
    public int getNumberOfElements() {
        return super.getNumberOfElements();
    }
    @JsonIgnore
    @Override
    public boolean isFirst() {
        return super.isFirst();
    }
    @JsonIgnore
    @Override
    public Sort getSort() {
        return super.getSort();
    }
    @JsonIgnore
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Getter
    public static class PageWrapper {
        private Boolean isEndPage;
        private Boolean isFirstPage;
        private Integer number;
        private Integer size;
        private Sort sort;
        private Long totalElements;
        private Integer totalPages;
        private Boolean isEmpty;

        public PageWrapper(Page page) {
            this.isEndPage = page.isLast();
            this.number = page.getNumber() + 1;
            this.size = page.getSize();
            this.sort = page.getSort();
            this.totalElements = page.getTotalElements();
            this.totalPages = page.getTotalPages();
            this.isFirstPage = page.isFirst();
            this.isEmpty = page.isEmpty();
        }
    }
}
