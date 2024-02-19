package dev.patika.ecommerce.api;

import dev.patika.ecommerce.business.abstracts.ICategoryService;
import dev.patika.ecommerce.business.abstracts.IProductService;
import dev.patika.ecommerce.business.abstracts.ISupplierService;
import dev.patika.ecommerce.core.config.modelMapper.IModelMapperService;
import dev.patika.ecommerce.core.result.Result;
import dev.patika.ecommerce.core.result.ResultData;
import dev.patika.ecommerce.core.utilies.ResultHelper;
import dev.patika.ecommerce.dto.request.product.ProductSaveRequest;
import dev.patika.ecommerce.dto.request.product.ProductUpdateRequest;
import dev.patika.ecommerce.dto.response.CursorResponse;
import dev.patika.ecommerce.dto.response.category.CategoryResponse;
import dev.patika.ecommerce.dto.response.product.ProductResponse;
import dev.patika.ecommerce.dto.response.supplier.SupplierResponse;
import dev.patika.ecommerce.entities.Category;
import dev.patika.ecommerce.entities.Product;
import dev.patika.ecommerce.entities.Supplier;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/v1/products")
    public class ProductController {
        private final IProductService productService;
        private final IModelMapperService modelMapper;
        private final ICategoryService categoryService;
        private final ISupplierService supplierService;

        public ProductController(IProductService productService,
                                 IModelMapperService modelMapper,
                                 ICategoryService categoryService,
                                 ISupplierService supplierService
        ) {
            this.productService = productService;
            this.modelMapper = modelMapper;
            this.categoryService = categoryService;
            this.supplierService = supplierService;
        }


        @PostMapping()
        @ResponseStatus(HttpStatus.CREATED)
        public ResultData<ProductResponse> save(@Valid @RequestBody ProductSaveRequest productSaveRequest) {
            Product saveProduct = this.modelMapper.forRequest().map(productSaveRequest, Product.class);

            Category category = this.categoryService.get(productSaveRequest.getCategoryId());
            saveProduct.setCategory(category);

            Supplier supplier = this.supplierService.get(productSaveRequest.getSupplierId());
            saveProduct.setSupplier(supplier);

            this.productService.save(saveProduct);
            return ResultHelper.created(this.modelMapper.forResponse().map(saveProduct, ProductResponse.class));
        }

        @GetMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public ResultData<ProductResponse> get(@PathVariable("id") int id) {
            return ResultHelper.success(this.modelMapper.forResponse().map(this.productService.get(id), ProductResponse.class));
        }

        //Supplierları çekmek için
        @GetMapping("/{id}/supplier")
        @ResponseStatus(HttpStatus.OK)
        public ResultData<SupplierResponse> getSupplier(@PathVariable("id") int id) {
            Product product = this.productService.get(id);
            return ResultHelper.success(this.modelMapper.forResponse().map(product.getSupplier(), SupplierResponse.class));
        }

        //Category çekmek için
        @GetMapping("/{id}/category")
        @ResponseStatus(HttpStatus.OK)
        public ResultData<CategoryResponse> getCategory(@PathVariable("id") int id) {
            Product product = this.productService.get(id);
            return ResultHelper.success(this.modelMapper.forResponse().map(product.getCategory(), CategoryResponse.class));
        }

        @GetMapping()
        @ResponseStatus(HttpStatus.OK)
        public ResultData<CursorResponse<ProductResponse>> cursor(
                @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize

        ) {
            Page<Product> productPage = this.productService.cursor(page, pageSize);
            Page<ProductResponse> productResponsePage = productPage
                    .map(product -> this.modelMapper.forResponse().map(product, ProductResponse.class));

            return ResultHelper.cursor(productResponsePage);
        }

        @PutMapping()
        @ResponseStatus(HttpStatus.OK)
        public ResultData<ProductResponse> update(@Valid @RequestBody ProductUpdateRequest productUpdateRequest) {

            Product updateProduct = this.modelMapper.forRequest().map(productUpdateRequest, Product.class);
            this.productService.update(updateProduct);
            return ResultHelper.success(this.modelMapper.forResponse().map(updateProduct, ProductResponse.class));
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public Result delete(@PathVariable("id") int id) {
            this.productService.delete(id);
            return ResultHelper.ok();
        }
}
