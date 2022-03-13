package com.example.warehouseapp.controller;

import com.example.warehouseapp.dto.ApiResponse;
import com.example.warehouseapp.dto.CategoryDTO;
import com.example.warehouseapp.entity.Category;
import com.example.warehouseapp.repository.CategoryRepository;
import com.example.warehouseapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String getCategoryPage(Model model){

model.addAttribute("list",categoryRepository.findAll());
return "category/category";

    }

    @GetMapping("/add")
    public String getSaveCategory(){

return "category/category-add";

    }

    @PostMapping("/add")
    public String saveCategory(Model model, @ModelAttribute Category category){

 categoryService.add(category);
 return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Integer id){

categoryRepository.deleteById(id);
return "redirect:/category";

    }

    @GetMapping("/edit/{id}")
    public String getedit(Model model, @PathVariable Integer id) {
        Category category = new Category();
        category.setId(id);
        category.setName(categoryRepository.findById(id).get().getName());
        model.addAttribute("category", category);
        return "category/category-edit";

    }

    @PostMapping("/edit/{id}")
    public String saveEditCategory(@ModelAttribute Category category){
        categoryService.add(category);
        return "redirect:/category";
    }

}
