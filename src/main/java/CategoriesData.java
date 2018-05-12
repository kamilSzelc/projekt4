import java.util.List;

class CategoriesData {

    private static CategoriesData instance = new CategoriesData();

    private List<Category> categories;

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public static CategoriesData getInstance() {
        return instance;
    }

    public List<Category> getAllCategories(){
        return categories;
    }
}
