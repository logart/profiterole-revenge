package com.exigen.common.web;


import com.exigen.common.domain.Categories;
import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Recipe;
import com.exigen.common.service.CategoriesService;
import com.exigen.common.service.CuisineService;
import com.exigen.common.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class  {@code FillDbController} creates for add information in our DB
 *
 * @author Ivan.
 * @DATE September 16, 2012
 */
@Controller
public class FillDbController {
    /**
     * {@code categoriesService} describes the CategoriesService for inject on this
     * class
     */
    @Autowired
    private CategoriesService categoriesService;

    /**
     * {@code cuisineService} describes the CuisineService for inject on this
     * class
     */
    @Autowired
    private CuisineService cuisineService;

    /**
     * {@code recipeService} describes the RecipeService for inject on this
     * class
     */
    @Autowired
    private RecipeService recipeService;

    private List<Categories> categoriesList;
    private List<Cuisine> cuisineList;
    private List<Recipe> recipeList;
    private List<String> bigImgList;
    private List<String> smallImgList;
    private List<String> descriptionList;
    private List<String> titleList;
    private List<Integer> timeList;

    /**
     * {@method getOneRecipeList(Integer recipeId)} using for test
     * our add and get methods in DAO
     *
     * @return list of cuisines on filldb view
     */

    public void addCategories() {
        /**
         * {@code cat1..5} describes categories for our DB
         */

        Categories cat1 = new Categories("Закуски");
        Categories cat2 = new Categories("Первое");
        Categories cat3 = new Categories("Второе");
        Categories cat4 = new Categories("Десерты");
        Categories cat5 = new Categories("Напитки");
        categoriesList = new ArrayList<Categories>(Arrays.asList(cat1, cat2, cat3, cat4, cat5));

    }

    public void addCuisines() {

        /**
         * {@code cuisine1..12} describes cuisines for our DB
         */

        Cuisine cuisine1 = new Cuisine("Украинская", "/img/ukr.jpg");
        Cuisine cuisine2 = new Cuisine("Русская", "/img/rus.jpg");
        Cuisine cuisine3 = new Cuisine("Японская", "/img/jap.jpg");
        Cuisine cuisine4 = new Cuisine("Китайская", "/img/chi.jpg");
        Cuisine cuisine5 = new Cuisine("Тайская", "/img/tha.jpg");
        Cuisine cuisine6 = new Cuisine("Итальянская", "/img/ita.jpg");
        Cuisine cuisine7 = new Cuisine("Мексиканская", "/img/mex.jpg");
        Cuisine cuisine8 = new Cuisine("Французская", "/img/fra.jpg");
        Cuisine cuisine9 = new Cuisine("Армянская", "/img/arm.jpg");
        Cuisine cuisine10 = new Cuisine("Индийская", "/img/ind.jpg");
        Cuisine cuisine11 = new Cuisine("Греческая", "/img/gre.jpg");
        Cuisine cuisine12 = new Cuisine("Грузинская", "/img/gru.jpg");
        cuisineList = new ArrayList<Cuisine>(Arrays.asList(cuisine1, cuisine2, cuisine3, cuisine4, cuisine5, cuisine6, cuisine7, cuisine8, cuisine9, cuisine10, cuisine11, cuisine12));

    }

    public void addBigImg() {

        /**
         * {@code bigImg1..bigImg20} describes big images for our DB
         */

        String bigImg1 = "http://eda.2k.ua/content/catalog/gribnoy_salat_so_sladkim_pertsem_orig.jpg";
        String bigImg2 = "http://eda.2k.ua/content/catalog/dynya_s_myatoy_i_imbirem_orig.jpg";
        String bigImg3 = "http://eda.2k.ua/content/catalog/ryzhiki_zapechennye_v_smetane_orig.jpg";
        String bigImg4 = "http://eda.2k.ua/content/catalog/item_7534_orig.jpg";
        String bigImg5 = "http://eda.2k.ua/content/catalog/kremsup_iz_brokkoli_malysh_orig.jpg";
        String bigImg6 = "http://eda.2k.ua/content/catalog/item_7436_orig.jpg";
        String bigImg7 = "http://eda.2k.ua/content/catalog/item_7238_orig.jpg";
        String bigImg8 = "http://eda.2k.ua/content/catalog/item_6822_orig.jpg";
        String bigImg9 = "http://eda.2k.ua/content/catalog/item_7570_orig.jpg";
        String bigImg10 = "http://eda.2k.ua/content/catalog/kotlety_iz_indeyki_s_kartofelnym_pyure_orig.jpg";
        String bigImg11 = "http://eda.2k.ua/content/catalog/belye_griby_v_slivochnom_souse_orig.jpg";
        String bigImg12 = "http://eda.2k.ua/content/catalog/steyk_lososya_so_sparzhey_i_brokkoli_orig.jpg";
        String bigImg13 = "http://eda.2k.ua/content/catalog/tryufeli_shokoladnye_orig.jpg";
        String bigImg14 = "http://eda.2k.ua/content/catalog/item_7606_orig.jpg";
        String bigImg15 = "http://eda.2k.ua/content/catalog/tiramisu_1346050002_7154_orig.jpg";
        String bigImg16 = "http://eda.2k.ua/content/catalog/arbuznoe_zhele_s_fistashkovym_praline_orig.jpg";
        String bigImg17 = "http://eda.2k.ua/content/catalog/molochnyy_sheyk_s_chernikoy_orig.jpg";
        String bigImg18 = "http://eda.2k.ua/content/catalog/item_7130_orig.jpg";
        String bigImg19 = "http://eda.2k.ua/content/catalog/limonnyy_punsh_orig.jpg";
        String bigImg20 = "http://eda.2k.ua/content/catalog/kokteyl_mokhito_orig.jpg";
        bigImgList = new ArrayList<String>(Arrays.asList(bigImg1, bigImg2, bigImg3, bigImg4, bigImg5, bigImg6, bigImg7, bigImg8, bigImg9, bigImg10, bigImg11, bigImg12, bigImg13, bigImg14, bigImg15, bigImg16, bigImg17, bigImg18, bigImg19, bigImg20));

    }

    public void addSmallImg() {
        /**
         * {@code smallImg1..smallImg20} describes small images for our DB
         */
        String smallImg1 = "http://eda.2k.ua/content/catalog/gribnoy_salat_so_sladkim_pertsem_orig.jpg";
        String smallImg2 = "http://eda.2k.ua/content/catalog/dynya_s_myatoy_i_imbirem_orig.jpg";
        String smallImg3 = "http://eda.2k.ua/content/catalog/ryzhiki_zapechennye_v_smetane_orig.jpg";
        String smallImg4 = "http://eda.2k.ua/content/catalog/item_7534_orig.jpg";
        String smallImg5 = "http://eda.2k.ua/content/catalog/kremsup_iz_brokkoli_malysh_orig.jpg";
        String smallImg6 = "http://eda.2k.ua/content/catalog/item_7436_orig.jpg";
        String smallImg7 = "http://eda.2k.ua/content/catalog/item_7238_orig.jpg";
        String smallImg8 = "http://eda.2k.ua/content/catalog/item_6822_orig.jpg";
        String smallImg9 = "http://eda.2k.ua/content/catalog/item_7570_orig.jpg";
        String smallImg10 = "http://eda.2k.ua/content/catalog/kotlety_iz_indeyki_s_kartofelnym_pyure_orig.jpg";
        String smallImg11 = "http://eda.2k.ua/content/catalog/belye_griby_v_slivochnom_souse_orig.jpg";
        String smallImg12 = "http://eda.2k.ua/content/catalog/steyk_lososya_so_sparzhey_i_brokkoli_orig.jpg";
        String smallImg13 = "http://eda.2k.ua/content/catalog/tryufeli_shokoladnye_orig.jpg";
        String smallImg14 = "http://eda.2k.ua/content/catalog/item_7606_orig.jpg";
        String smallImg15 = "http://eda.2k.ua/content/catalog/tiramisu_1346050002_7154_orig.jpg";
        String smallImg16 = "http://eda.2k.ua/content/catalog/arbuznoe_zhele_s_fistashkovym_praline_orig.jpg";
        String smallImg17 = "http://eda.2k.ua/content/catalog/molochnyy_sheyk_s_chernikoy_orig.jpg";
        String smallImg18 = "http://eda.2k.ua/content/catalog/item_7130_orig.jpg";
        String smallImg19 = "http://eda.2k.ua/content/catalog/limonnyy_punsh_orig.jpg";
        String smallImg20 = "http://eda.2k.ua/content/catalog/kokteyl_mokhito_orig.jpg";
        smallImgList = new ArrayList<String>(Arrays.asList(smallImg1, smallImg2, smallImg3, smallImg4, smallImg5, smallImg6, smallImg7, smallImg8, smallImg9, smallImg10, smallImg11, smallImg12, smallImg13, smallImg14, smallImg15, smallImg16, smallImg17, smallImg18, smallImg19, smallImg20));

    }

    public void addDescription() {

        /**
         * {@code description1..description20} describes descriptions for our DB
         */
        String description1 = "Основной ингредиент:  Грибы, Мясо, дичь, Овощи, Сыр, творог";
        String description2 = "По ингредиенту:  Зелень и травы, Фрукты, ягоды, орехи";
        String description3 = "По ингредиенту:  Грибы, Молочные продукты";
        String description4 = "По ингредиенту:  Зелень и травы, Овощи, Сыр, творог, Кабачки и баклажаны";
        String description5 = "Основной ингредиент:   Брокколи, лук, сливки";
        String description6 = "По ингредиенту  Зелень и травы, Молочные продукты, Овощи, Сыр, творог";
        String description7 = "По ингредиенту:  Бобовые и крупы, Зелень и травы, Овощи";
        String description8 = "По ингредиенту: Зелень и травы, Овощи, Рыба и морепродукты, Соусы и маринады";
        String description9 = "По ингредиенту:   Рыба и морепродукты";
        String description10 = "По ингредиенту:Молочные продукты, Мясо, дичь, Картофель";
        String description11 = "По ингредиенту: Молочные продукты, Мясо, дичь, Картофель";
        String description12 = "По ингредиенту:Овощи, Рыба и морепродукты";
        String description13 = "Основной ингредиент:  Шоколад";
        String description14 = "По ингредиенту:Молочные продукты, Овощи";
        String description15 = "По ингредиенту   Молочные продукты, Сыр, творог";
        String description16 = "По ингредиенту:  Зелень и травы, Молочные продукты, Фрукты, ягоды, орехи";
        String description17 = "По ингредиенту:  Молочные продукты, Фрукты, ягоды, орехи";
        String description18 = "По ингредиенту:  Фрукты, ягоды, орехи";
        String description19 = "По ингредиенту: Алкоголь, Фрукты, ягоды, орехи";
        String description20 = "По ингредиенту:  Алкоголь, Зелень и травы, Фрукты, ягоды, орехи";
        descriptionList = new ArrayList<String>(Arrays.asList(description1, description2, description3, description4, description5, description6, description7, description8, description9, description10, description11, description12, description13, description14, description15, description16, description17, description18, description19, description20));

    }

    public void addTitle() {

        /**
         * {@code title1..title20} describes titles for our DB
         */
        String title1 = "Грибной салат с болгарским перцем";
        String title2 = "Дыня с мятой и имбирем ";
        String title3 = "Рыжики запеченные в сметане ";
        String title4 = "Салат из баклажанов и феты ";
        String title5 = "Крем-суп из брокколи \"Малыш\" ";
        String title6 = "Сырный суп с кольраби ";
        String title7 = " Острый томатный суп с фасолью";
        String title8 = "Рыбный суп с морепродуктами ";
        String title9 = "Шницели из горбуши ";
        String title10 = " Котлеты из индейки с картофельным пюре";
        String title11 = " Белые грибы в сливочном соусе ";
        String title12 = "Стейк лосося со спаржей и брокколи ";
        String title13 = "Трюфели шоколадные ";
        String title14 = " Гаджарка-халва. Халва из моркови";
        String title15 = "Тирамису ";
        String title16 = " Арбузное желе с фисташковой карамелью";
        String title17 = " Молочный шейк с черникой";
        String title18 = "Коктейль \"Ягодный смэш\" ";
        String title19 = "Лимонный пунш ";
        String title20 = "Коктейль \"Мохито\" ";
        titleList = new ArrayList<String>(Arrays.asList(title1, title2, title3, title4, title5, title6, title7, title8, title9, title10, title11, title12, title13, title14, title15, title16, title17, title18, title19, title20));

    }

    public void addTime() {

        /**
         * {@code time1..time20} describes times for our DB
         */
        Integer time1 = 10;
        Integer time2 = 20;
        Integer time3 = 30;
        Integer time4 = 40;
        Integer time5 = 10;
        Integer time6 = 20;
        Integer time7 = 30;
        Integer time8 = 40;
        Integer time9 = 10;
        Integer time10 = 20;
        Integer time11 = 30;
        Integer time12 = 40;
        Integer time13 = 10;
        Integer time14 = 20;
        Integer time15 = 30;
        Integer time16 = 40;
        Integer time17 = 10;
        Integer time18 = 20;
        Integer time19 = 30;
        Integer time20 = 40;
        timeList = new ArrayList<Integer>(Arrays.asList(time1, time2, time3, time4, time5, time6, time7, time8, time9, time10, time11, time12, time13, time14, time15, time16, time17, time18, time19, time20));

    }

    public void addRecipes() {
        addTitle();
        addDescription();
        addCuisines();
        addCategories();
        addBigImg();
        addSmallImg();
        addTime();
        /**
         * {@code rec1..rec20} describes recipes for our DB
         */

        recipeList = new ArrayList<Recipe>();
        for (int i = 0; i < 4; i++) {
            recipeList.add(new Recipe(titleList.get(i), descriptionList.get(i), cuisineList.get(1), categoriesList.get(0), bigImgList.get(i), smallImgList.get(i), timeList.get(i)));
        }

        for (int i = 4; i < 8; i++) {
            recipeList.add(new Recipe(titleList.get(i), descriptionList.get(i), cuisineList.get(1), categoriesList.get(1), bigImgList.get(i), smallImgList.get(i), timeList.get(i)));
        }

        for (int i = 8; i < 12; i++) {
            recipeList.add(new Recipe(titleList.get(i), descriptionList.get(i), cuisineList.get(1), categoriesList.get(2), bigImgList.get(i), smallImgList.get(i), timeList.get(i)));
        }

        for (int i = 12; i < 16; i++) {
            recipeList.add(new Recipe(titleList.get(i), descriptionList.get(i), cuisineList.get(1), categoriesList.get(3), bigImgList.get(i), smallImgList.get(i), timeList.get(i)));
        }
        for (int i = 16; i < 20; i++) {
            recipeList.add(new Recipe(titleList.get(i), descriptionList.get(i), cuisineList.get(1), categoriesList.get(4), bigImgList.get(i), smallImgList.get(i), timeList.get(i)));
        }
    }

    @RequestMapping(value = {"/filldb"})
    public ModelAndView fillDb() {
        addRecipes();
        /**
         * adding information in DB with helps cuisineService
         */
        for (Cuisine cuisine : cuisineList) {
            cuisineService.addCuisine(cuisine);
        }

        /**
         * adding information in DB with helps categoriesService
         */
        for (Categories categories : categoriesList) {
            categoriesService.addCategories(categories);
        }
        /**
         * adding information in DB with helps recipeService
         */
        for (Recipe recipe : recipeList) {
            recipeService.addRecipe(recipe);
        }

        /**
         * return information from DB on view for example
         */
        return new ModelAndView("filldb", "model", this.cuisineService.getCuisine());
    }
}