package com.juniorbarros.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.juniorbarros.model.AttrsVals;
import com.juniorbarros.model.Library;

public class LibraryRepository extends AbstractRepository<Library> {

	@Transactional(readOnly = true)
    public List<Library> listLibraryBooks(Long libraryId) {
        return find(
                new AttrsVals()
                        .add("id", libraryId)
        );
    }
}