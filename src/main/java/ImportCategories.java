import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ImportCategories {
    public static void importCategoriesFromData2(){
        List<Category> categoryList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ClassLoader
                .getSystemResourceAsStream("categories.csv")));
        try {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] split = line.split(";");
                Category category = new Category();
                category.setNumber(Integer.parseInt(split[0]));
                category.setName(split[1]);
                category.setPriority(Integer.parseInt(split[2]));
                categoryList.add(category);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        CategoriesData catInstance = CategoriesData.getInstance();
        catInstance.setCategories(categoryList);
    }
}
