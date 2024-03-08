package hoang.dao;

import java.util.List;

import hoang.entity.Category;

public interface CategoryDAO {
	public List<Category> getAllCategory();
	public Category getCategoryById(int id);
	public boolean insertCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(int id);
}
