package dev.patika.librarymanagmentsystemwithrestapi.business.concretes;

import dev.patika.librarymanagmentsystemwithrestapi.business.abstracts.ICategoryService;
import dev.patika.librarymanagmentsystemwithrestapi.core.exception.NotFoundException;
import dev.patika.librarymanagmentsystemwithrestapi.core.utilies.Msg;
import dev.patika.librarymanagmentsystemwithrestapi.dao.ICategoryRepo;
import dev.patika.librarymanagmentsystemwithrestapi.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryManager implements ICategoryService {
    private final ICategoryRepo categoryRepo;

    public CategoryManager(ICategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category get(int id) {
        return this.categoryRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Category> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.categoryRepo.findAll(pageable);
    }

    @Override
    public Category update(Category category) {
        this.get(category.getId());
        return this.categoryRepo.save(category);
    }

    @Override
    public boolean delete(int id) {
        Category category = this.get(id);
        this.categoryRepo.delete(category);
        return true;
    }
}
