package com.exigen.common.web;


import com.exigen.common.domain.*;
import com.exigen.common.service.*;
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

    @Autowired
    private IngridientService ingridientService;


    @Autowired
    private StepService stepService;
    /**
     * {@code Lsts} add lists for categories, suisines, recipes and ext
     */

    private List<Categories> categoriesList;
    private List<Cuisine> cuisineList;
    private List<Recipe> recipeList;
    private List<String> bigImgList;
    private List<String> smallImgList;
    private List<String> descriptionList;
    private List<String> titleList;
    private List<Integer> timeList;
    List<List<Ingridient>> listOfIngridientsLists;
    List<List<Step>> listOfStepsLists;

    /**
     * {@method addCategories()}
     * creates for adding categories for creation in recipe entity. This
     * method inicialize variables for recipes and add it in smallImgList
     *
     * @throws Exception.Data(where ArrayList is empty)
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

        /**
         * {@code categoriesList} add  categories in the list
         */

        categoriesList = new ArrayList<Categories>(Arrays.asList(cat1, cat2, cat3, cat4, cat5));

    }

    /**
     * {@method addCuisines()}
     * creates for adding cuisines for creation in recipe entity. This
     * method inicialize variables for recipes and add it in smallImgList
     *
     * @throws Exception.Data(where ArrayList is empty)
     */

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

        /**
         * {@code cuisineList} add  cuisines in the list
         */

        cuisineList = new ArrayList<Cuisine>(Arrays.asList(cuisine1, cuisine2, cuisine3, cuisine4, cuisine5, cuisine6, cuisine7, cuisine8, cuisine9, cuisine10, cuisine11, cuisine12));

    }

    /**
     * {@method addBigImg()}
     * creates for adding big image field for creation in recipe entity. This
     * method inicialize variables for recipes and add it in smallImgList
     *
     * @throws Exception.Data(where ArrayList is empty), ResourceNotFoundException(where
     *                              link is empty)
     */

    public void addBigImg() {

        /**
         * {@code bigImg1..bigImg20} describes big images for our DB. This images adding into our cuisines
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

        /**
         * {@code bigImgList} add big images in the list
         */
        bigImgList = new ArrayList<String>(Arrays.asList(bigImg1, bigImg2, bigImg3, bigImg4, bigImg5, bigImg6, bigImg7, bigImg8, bigImg9, bigImg10, bigImg11, bigImg12, bigImg13, bigImg14, bigImg15, bigImg16, bigImg17, bigImg18, bigImg19, bigImg20));

    }


    /**
     * {@method addSmallImg()}
     * creates for adding small image field for creation in recipe entity. This
     * method inicialize variables for recipes and add it in smallImgList
     *
     * @throws Exception.Data(where ArrayList is empty), ResourceNotFoundException(where
     *                              link is empty)
     */

    public void addSmallImg() {
        /**
         * {@code smallImg1..smallImg20} describes small images for our DB. This images adding into our cuisines
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

        /**
         * {@code smallImgList} add  small images for recipes in the list
         */

        smallImgList = new ArrayList<String>(Arrays.asList(smallImg1, smallImg2, smallImg3, smallImg4, smallImg5, smallImg6, smallImg7, smallImg8, smallImg9, smallImg10, smallImg11, smallImg12, smallImg13, smallImg14, smallImg15, smallImg16, smallImg17, smallImg18, smallImg19, smallImg20));

    }

    /**
     * {@method addDescription()}
     * creates for describe description of creation in recipe entity. This
     * method inicialize variables for recipes and add it in descriptionList
     *
     * @throws javax.xml.crypto.Data(where ArrayList is empty)
     */

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

        /**
         * {@code descriptionList} add  descriptions of recipes in the list
         */

        descriptionList = new ArrayList<String>(Arrays.asList(description1, description2, description3, description4, description5, description6, description7, description8, description9, description10, description11, description12, description13, description14, description15, description16, description17, description18, description19, description20));

    }

    /**
     * {@method addTitle()}
     * creates for describe title of creation in recipe entity. This
     * method inicialize variables for recipes and add it in titleList
     *
     * @throws javax.xml.crypto.Data(where ArrayList is empty)
     */
    public void addTitle() {

        /**
         * {@code title1..title20} describes titles for our DB
         */
        String title1 = "Грибной салат с болгарским перцем";
        String title2 = "Дыня с мятой и имбирем";
        String title3 = "Рыжики запеченные в сметане";
        String title4 = "Салат из баклажанов и феты";
        String title5 = "Крем-суп из брокколи \"Малыш\"";
        String title6 = "Сырный суп с кольраби";
        String title7 = " Острый томатный суп с фасолью";
        String title8 = "Рыбный суп с морепродуктами";
        String title9 = "Шницели из горбуши";
        String title10 = " Котлеты из индейки с картофелем";
        String title11 = " Белые грибы в сливочном соусе";
        String title12 = "Стейк лосося со спаржей и брокколи";
        String title13 = "Трюфели шоколадные";
        String title14 = " Гаджарка-халва. Халва из моркови";
        String title15 = "Тирамису";
        String title16 = " Арбузное желе с фисташковой карамелью";
        String title17 = " Молочный шейк с черникой";
        String title18 = "Коктейль \"Ягодный смэш\"";
        String title19 = "Лимонный пунш";
        String title20 = "Коктейль \"Мохито\"";

        /**
         * {@code titleList} add titles of recipes in the list
         */

        titleList = new ArrayList<String>(Arrays.asList(title1, title2, title3, title4, title5, title6, title7, title8, title9, title10, title11, title12, title13, title14, title15, title16, title17, title18, title19, title20));

    }

    /**
     * {@method addTime()}
     * creates for describe time of creation in recipe entity. This
     * method inicialize variables for recipes and add it in timeList
     *
     * @throws Exception.Data(where ArrayList is empty)
     */

    public void addTime() {

        /**
         * {@code time1..time20} describes times for our DB
         */
        Integer time1 = 2 * 2 * 2 + 2;
        Integer time2 = (2 * 2 * 2 + 2) * 2;
        Integer time3 = (2 * 2 * 2 + 2) * (2 + 1);
        Integer time4 = (2 * 2 * 2 + 2) * 2 * 2;
        Integer time5 = 2 * 2 * 2 + 2;
        Integer time6 = (2 * 2 * 2 + 2) * 2;
        Integer time7 = (2 * 2 * 2 + 2) * (2 + 1);
        Integer time8 = (2 * 2 * 2 + 2) * 2 * 2;
        Integer time9 = 2 * 2 * 2 + 2;
        Integer time10 = (2 * 2 * 2 + 2) * 2;
        Integer time11 = (2 * 2 * 2 + 2) * (2 + 1);
        Integer time12 = (2 * 2 * 2 + 2) * 2 * 2;
        Integer time13 = 2 * 2 * 2 + 2;
        Integer time14 = (2 * 2 * 2 + 2) * 2;
        Integer time15 = (2 * 2 * 2 + 2) * (2 + 1);
        Integer time16 = (2 * 2 * 2 + 2) * 2 * 2;
        Integer time17 = 2 * 2 * 2 + 2;
        Integer time18 = (2 * 2 * 2 + 2) * 2;
        Integer time19 = (2 * 2 * 2 + 2) * (2 + 1);
        Integer time20 = (2 * 2 * 2 + 2) * 2 * 2;

        /**
         * {@code timeList} add values of time in the list
         */

        timeList = new ArrayList<Integer>(Arrays.asList(time1, time2, time3, time4, time5, time6, time7, time8, time9, time10, time11, time12, time13, time14, time15, time16, time17, time18, time19, time20));

    }

    /**
     * {@method addRecipes()}
     * creates for adding information into our DB. It works for adding RecipeTitle, RecipeDescription,
     * Categories, Cuisines, Time for recipe, Big and Small Image for recipe
     *
     * @throws org.springframework.dao.DataAccessException(resource
     *          on cloudfoundry is unavalible, DB is changed)
     */

    public void addRecipes() {
        addTitle();
        addDescription();
        addCuisines();
        addCategories();
        addBigImg();
        addSmallImg();
        addTime();

        /**
         * {@code rec1..rec20} adding information in collection
         */
        int i = 0;
        recipeList = new ArrayList<Recipe>();
        for (; i < (2 + 2); i++) {
            recipeList.add(new Recipe(titleList.get(i), descriptionList.get(i), cuisineList.get(1), categoriesList.get(0), bigImgList.get(i), smallImgList.get(i), timeList.get(i)));
        }

        for (; i < (2 * 2 * 2); i++) {
            recipeList.add(new Recipe(titleList.get(i), descriptionList.get(i), cuisineList.get(1), categoriesList.get(1), bigImgList.get(i), smallImgList.get(i), timeList.get(i)));
        }

        for (; i < (2 * 2 * 2 + 2 * 2); i++) {
            recipeList.add(new Recipe(titleList.get(i), descriptionList.get(i), cuisineList.get(1), categoriesList.get(2), bigImgList.get(i), smallImgList.get(i), timeList.get(i)));
        }

        for (; i < (2 * 2 * 2 * 2); i++) {
            recipeList.add(new Recipe(titleList.get(i), descriptionList.get(i), cuisineList.get(1), categoriesList.get(2 + 1), bigImgList.get(i), smallImgList.get(i), timeList.get(i)));
        }
        for (; i < (2 * 2 * 2 * 2 + 2 * 2); i++) {
            recipeList.add(new Recipe(titleList.get(i), descriptionList.get(i), cuisineList.get(1), categoriesList.get(2 + 2), bigImgList.get(i), smallImgList.get(i), timeList.get(i)));
        }
    }

    /**
     * {@method addIngridients()}
     * creates Ingridient entities and links they to the Recipes.
     * This method inicialize Ingridient entity, link it to the recipe and add Ingridient entities,
     * that belong to one recipe, in separate List.
     *
     * @throws Exception.Data(where ArrayList is empty)
     */

    public void addIngridients() {

        /**
         * {@code k} uses as a array index of current recipe.
         */

        int k = 0;

        /**
         * {@code ingr_a1..ingr_a4} describes ingridients and their properties.
         * This ingridients are adding to the first recipe.
         */
        Ingridient ingr_a1 = new Ingridient("Грибы маринованные", 150, 150, "г", recipeList.get(k));
        Ingridient ingr_a2 = new Ingridient("Cладкий перец", 50, 2, "шт.", recipeList.get(k));
        Ingridient ingr_a3 = new Ingridient("Ветчина", 35, 100, "г", recipeList.get(k));
        Ingridient ingr_a4 = new Ingridient("Сыр", 30, 100, "г", recipeList.get(k));

        /**
         * {@code list0} unities ingridients that belong to one recipe.
         */

        List<Ingridient> list0 = new ArrayList<Ingridient>(Arrays.asList(ingr_a1, ingr_a2, ingr_a3, ingr_a4));

        /**
         * {@code ingr_b1..ingr_b6} describes ingridients and their properties.
         * This ingridients are adding to the second recipe.
         */

        k++;
        Ingridient ingr_b1 = new Ingridient("Дыня", 15, 1000, "г", recipeList.get(k));
        Ingridient ingr_b2 = new Ingridient("Лайм", 5, 1, "шт.", recipeList.get(k));
        Ingridient ingr_b3 = new Ingridient("Мята (мелко нарубленная)", 7, 75, "г", recipeList.get(k));
        Ingridient ingr_b4 = new Ingridient("Сахар", 25, 25, "г", recipeList.get(k));
        Ingridient ingr_b5 = new Ingridient("Имбирь (тертый)", 18, 25, "г", recipeList.get(k));
        Ingridient ingr_b6 = new Ingridient("Мед", 22, 25, "г", recipeList.get(k));

        /**
         * {@code list1} unities ingridients that belong to one recipe.
         */

        List<Ingridient> list1 = new ArrayList<Ingridient>(Arrays.asList(ingr_b1, ingr_b2, ingr_b3, ingr_b4, ingr_b5, ingr_b6));

        /**
         * {@code ingr_c1..ingr_c4} describes ingridients and their properties.
         * This ingridients are adding to the third recipe.
         */

        k++;
        Ingridient ingr_c1 = new Ingridient("Грибы рыжики", 25, 200, "г", recipeList.get(k));
        Ingridient ingr_c2 = new Ingridient("Сметана", 23, 100, "г", recipeList.get(k));
        Ingridient ingr_c3 = new Ingridient("Лук", 7, 1, "шт.", recipeList.get(k));
        Ingridient ingr_c4 = new Ingridient("Черный молотый перец", 2, 3, "г", recipeList.get(k));

        /**
         * {@code list2} unities ingridients that belong to one recipe.
         */

        List<Ingridient> list2 = new ArrayList<Ingridient>(Arrays.asList(ingr_c1, ingr_c2, ingr_c3, ingr_c4));

        /**
         * {@code ingr_d1..ingr_d6} describes ingridients and their properties.
         * This ingridients are adding to the fourth recipe.
         */

        k++;
        Ingridient ingr_d1 = new Ingridient("Баклажаны", 12, 2, "шт.", recipeList.get(k));
        Ingridient ingr_d2 = new Ingridient("Оливковое масло", 23, 30, "г", recipeList.get(k));
        Ingridient ingr_d3 = new Ingridient("Тыква", 7, 250, "г", recipeList.get(k));
        Ingridient ingr_d4 = new Ingridient("Сыр фета", 20, 100, "г", recipeList.get(k));
        Ingridient ingr_d5 = new Ingridient("Мята (свежая)", 2, 50, "г", recipeList.get(k));
        Ingridient ingr_d6 = new Ingridient("Лимонный сок", 20, 25, "мл.", recipeList.get(k));

        /**
         * {@code list3} unities ingridients that belong to one recipe.
         */

        List<Ingridient> list3 = new ArrayList<Ingridient>(Arrays.asList(ingr_d1, ingr_d2, ingr_d3, ingr_d4, ingr_d5, ingr_d6));

        /**
         * {@code ingr_e1..ingr_e5} describes ingridients and their properties.
         * This ingridients are adding to the fifth recipe.
         */

        k++;
        Ingridient ingr_e1 = new Ingridient("Брокколи", 12, 500, "г", recipeList.get(k));
        Ingridient ingr_e2 = new Ingridient("Сливочное масло", 65, 50, "г", recipeList.get(k));
        Ingridient ingr_e3 = new Ingridient("Репчатый лук или лук порей", 7, 1, "шт.", recipeList.get(k));
        Ingridient ingr_e4 = new Ingridient("Бульон говяжий или куриный", 20, 200, "мл.", recipeList.get(k));
        Ingridient ingr_e5 = new Ingridient("Сливки", 70, 125, "г", recipeList.get(k));

        /**
         * {@code list4} unities ingridients that belong to one recipe.
         */

        List<Ingridient> list4 = new ArrayList<Ingridient>(Arrays.asList(ingr_e1, ingr_e2, ingr_e3, ingr_e4, ingr_e5));

        /**
         * {@code ingr_f1..ingr_f10} describes ingridients and their properties.
         * This ingridients are adding to the sixth recipe.
         */

        k++;
        Ingridient ingr_f1 = new Ingridient("Кольраби", 40, 120, "шт.", recipeList.get(k));
        Ingridient ingr_f2 = new Ingridient("Сыр Рокфор", 43, 50, "г", recipeList.get(k));
        Ingridient ingr_f3 = new Ingridient("Мука пшеничная", 7, 30, "г", recipeList.get(k));
        Ingridient ingr_f4 = new Ingridient("Соль", 2, 25, "г", recipeList.get(k));
        Ingridient ingr_f5 = new Ingridient("Мускатный орех тертый", 2, 12, "г", recipeList.get(k));
        Ingridient ingr_f6 = new Ingridient("Сыр твердых сортов", 20, 50, "г", recipeList.get(k));
        Ingridient ingr_f7 = new Ingridient("Сливочное масло", 80, 40, "г", recipeList.get(k));
        Ingridient ingr_f8 = new Ingridient("Молоко", 26, 300, "мл.", recipeList.get(k));
        Ingridient ingr_f9 = new Ingridient("Виноградный сок", 20, 90, "мл.", recipeList.get(k));
        Ingridient ingr_f10 = new Ingridient("Перец черный молотый", 2, 12, "г", recipeList.get(k));

        /**
         * {@code list5} unities ingridients that belong to one recipe.
         */

        List<Ingridient> list5 = new ArrayList<Ingridient>(Arrays.asList(ingr_f1, ingr_f2, ingr_f3, ingr_f4, ingr_f5, ingr_f6, ingr_f7, ingr_f8, ingr_f9, ingr_f10));

        /**
         * {@code ingr_g1..ingr_g6} describes ingridients and their properties.
         * This ingridients are adding to the seventh recipe.
         */

        k++;
        Ingridient ingr_g1 = new Ingridient("Растительное масло", 32, 40, "мл.", recipeList.get(k));
        Ingridient ingr_g2 = new Ingridient("Томатное пюре", 23, 5000, "г", recipeList.get(k));
        Ingridient ingr_g3 = new Ingridient("Соль морская", 2, 30, "г", recipeList.get(k));
        Ingridient ingr_g4 = new Ingridient("Бульон говяжий", 20, 500, "мл.", recipeList.get(k));
        Ingridient ingr_g5 = new Ingridient("Лук репчатый", 2, 2, "шт", recipeList.get(k));
        Ingridient ingr_g6 = new Ingridient("Фасоль красная в собственном соку", 20, 500, "мл.", recipeList.get(k));

        /**
         * {@code list6} unities ingridients that belong to one recipe.
         */

        List<Ingridient> list6 = new ArrayList<Ingridient>(Arrays.asList(ingr_g1, ingr_g2, ingr_g3, ingr_g4, ingr_g5, ingr_g6));

        /**
         * {@code ingr_h1..ingr_h6} describes ingridients and their properties.
         * This ingridients are adding to the eighth recipe.
         */

        k++;
        Ingridient ingr_h1 = new Ingridient("Лук репчатый", 12, 1, "шт.", recipeList.get(k));
        Ingridient ingr_h2 = new Ingridient("Фенхель", 23, 1, "шт.", recipeList.get(k));
        Ingridient ingr_h3 = new Ingridient("Чеснок", 7, 5, "зуб.", recipeList.get(k));
        Ingridient ingr_h4 = new Ingridient("Анисовая водка", 20, 50, "мл.", recipeList.get(k));
        Ingridient ingr_h5 = new Ingridient("Картофель", 2, 1000, "г", recipeList.get(k));
        Ingridient ingr_h6 = new Ingridient("Яичный желток", 20, 3, "шт.", recipeList.get(k));

        /**
         * {@code list7} unities ingridients that belong to one recipe.
         */

        List<Ingridient> list7 = new ArrayList<Ingridient>(Arrays.asList(ingr_h1, ingr_h2, ingr_h3, ingr_h4, ingr_h5, ingr_h6));

        /**
         * {@code ingr_i1..ingr_i6} describes ingridients and their properties.
         * This ingridients are adding to the nineth recipe.
         */

        k++;
        Ingridient ingr_i1 = new Ingridient("Филе горбуши", 120, 500, "г", recipeList.get(k));
        Ingridient ingr_i2 = new Ingridient("Лук", 23, 1, "шт.", recipeList.get(k));
        Ingridient ingr_i3 = new Ingridient("Яйца", 7, 2, "шт.", recipeList.get(k));
        Ingridient ingr_i4 = new Ingridient("Майонез", 200, 50, "г", recipeList.get(k));
        Ingridient ingr_i5 = new Ingridient("Растительное масло", 2, 150, "г", recipeList.get(k));
        Ingridient ingr_i6 = new Ingridient("Панировочные сухари", 20, 125, "г", recipeList.get(k));

        /**
         * {@code list8} unities ingridients that belong to one recipe.
         */

        List<Ingridient> list8 = new ArrayList<Ingridient>(Arrays.asList(ingr_i1, ingr_i2, ingr_i3, ingr_i4, ingr_i5, ingr_i6));

        /**
         * {@code ingr_j1..ingr_j7} describes ingridients and their properties.
         * This ingridients are adding to the tenth recipe.
         */

        k++;
        Ingridient ingr_j1 = new Ingridient("Филе индейки", 1200, 2000, "г", recipeList.get(k));
        Ingridient ingr_j2 = new Ingridient("Сливочное масло", 2350, 350, "г", recipeList.get(k));
        Ingridient ingr_j3 = new Ingridient("Сливки 33%", 1750, 450, "мл.", recipeList.get(k));
        Ingridient ingr_j4 = new Ingridient("Яйца", 200, 2, "шт.", recipeList.get(k));
        Ingridient ingr_j5 = new Ingridient("Растительное масло", 2000, 200, "мл.", recipeList.get(k));
        Ingridient ingr_j6 = new Ingridient("Картофель", 200, 2000, "г", recipeList.get(k));
        Ingridient ingr_j7 = new Ingridient("Руккола", 20, 75, "г", recipeList.get(k));

        /**
         * {@code list9} unities ingridients that belong to one recipe.
         */

        List<Ingridient> list9 = new ArrayList<Ingridient>(Arrays.asList(ingr_j1, ingr_j2, ingr_j3, ingr_j4, ingr_j5, ingr_j6, ingr_j7));

        /**
         * {@code ingr_k1..ingr_k5} describes ingridients and their properties.
         * This ingridients are adding to the eleventh recipe.
         */

        k++;
        Ingridient ingr_k1 = new Ingridient("Белые грибы", 120, 300, "г", recipeList.get(k));
        Ingridient ingr_k2 = new Ingridient("Лук", 23, 2, "шт.", recipeList.get(k));
        Ingridient ingr_k3 = new Ingridient("Растительное масло", 70, 50, "г", recipeList.get(k));
        Ingridient ingr_k4 = new Ingridient("Сливки", 200, 50, "г", recipeList.get(k));
        Ingridient ingr_k5 = new Ingridient("Мускатный орех", 2, 2, "г", recipeList.get(k));

        /**
         * {@code list10} unities ingridients that belong to one recipe.
         */

        List<Ingridient> list10 = new ArrayList<Ingridient>(Arrays.asList(ingr_k1, ingr_k2, ingr_k3, ingr_k4, ingr_k5));

        /**
         * {@code ingr_l1..ingr_l5} describes ingridients and their properties.
         * This ingridients are adding to the twelfth recipe.
         */

        k++;
        Ingridient ingr_l1 = new Ingridient("Лосось", 1200, 500, "г", recipeList.get(k));
        Ingridient ingr_l2 = new Ingridient("Спаржа", 230, 250, "г", recipeList.get(k));
        Ingridient ingr_l3 = new Ingridient("Брокколи", 70, 250, "г", recipeList.get(k));
        Ingridient ingr_l4 = new Ingridient("Оливковое масло", 200, 50, "г", recipeList.get(k));
        Ingridient ingr_l5 = new Ingridient("Лимон", 2, 1, "шт.", recipeList.get(k));

        /**
         * {@code list11} unities ingridients that belong to one recipe.
         */

        List<Ingridient> list11 = new ArrayList<Ingridient>(Arrays.asList(ingr_l1, ingr_l2, ingr_l3, ingr_l4, ingr_l5));

        /**
         * {@code ingr_m1..ingr_m5} describes ingridients and their properties.
         * This ingridients are adding to the thirteenth recipe.
         */

        k++;
        Ingridient ingr_m1 = new Ingridient("Горький шоколад", 1200, 100, "г", recipeList.get(k));
        Ingridient ingr_m2 = new Ingridient("Густые сливки", 1230, 100, "мл.", recipeList.get(k));
        Ingridient ingr_m3 = new Ingridient("Сливочное масло", 70, 10, "г", recipeList.get(k));
        Ingridient ingr_m4 = new Ingridient("Ликер по вкусу", 20, 25, "г", recipeList.get(k));
        Ingridient ingr_m5 = new Ingridient("Какао", 20, 50, "г", recipeList.get(k));

        /**
         * {@code list12} unities ingridients that belong to one recipe.
         */

        List<Ingridient> list12 = new ArrayList<Ingridient>(Arrays.asList(ingr_m1, ingr_m2, ingr_m3, ingr_m4, ingr_m5));

        /**
         * {@code ingr_n1..ingr_n7} describes ingridients and their properties.
         * This ingridients are adding to the fourteenth recipe.
         */

        k++;
        Ingridient ingr_n1 = new Ingridient("Тертая морковь", 120, 350, "г", recipeList.get(k));
        Ingridient ingr_n2 = new Ingridient("Сливочное масло", 2300, 200, "г", recipeList.get(k));
        Ingridient ingr_n3 = new Ingridient("Кардамон", 7, 10, "г", recipeList.get(k));
        Ingridient ingr_n4 = new Ingridient("Сливки", 2000, 250, "мл.", recipeList.get(k));
        Ingridient ingr_n5 = new Ingridient("Молоко", 500, 250, "мл.", recipeList.get(k));
        Ingridient ingr_n6 = new Ingridient("Сахар", 20, 100, "г", recipeList.get(k));
        Ingridient ingr_n7 = new Ingridient("Манная крупа", 20, 30, "г", recipeList.get(k));

        /**
         * {@code list13} unities ingridients that belong to one recipe.
         */

        List<Ingridient> list13 = new ArrayList<Ingridient>(Arrays.asList(ingr_n1, ingr_n2, ingr_n3, ingr_n4, ingr_n5, ingr_n6, ingr_n7));

        /**
         * {@code ingr_o1..ingr_o6} describes ingridients and their properties.
         * This ingridients are adding to the fifteenth recipe.
         */

        k++;
        Ingridient ingr_o1 = new Ingridient("Сливки (30%)", 1200, 400, "г", recipeList.get(k));
        Ingridient ingr_o2 = new Ingridient("Сыр Маскарпоне", 2300, 500, "г", recipeList.get(k));
        Ingridient ingr_o3 = new Ingridient("Палочки Савоярди", 70, 200, "г", recipeList.get(k));
        Ingridient ingr_o4 = new Ingridient("Кофе эспрессо", 20, 100, "мл.", recipeList.get(k));
        Ingridient ingr_o5 = new Ingridient("яичные желтки", 200, 12, "шт.", recipeList.get(k));
        Ingridient ingr_o6 = new Ingridient("Ром", 20, 25, "мл.", recipeList.get(k));

        /**
         * {@code list14} unities ingridients that belong to one recipe.
         */

        List<Ingridient> list14 = new ArrayList<Ingridient>(Arrays.asList(ingr_o1, ingr_o2, ingr_o3, ingr_o4, ingr_o5, ingr_o6));

        /**
         * {@code ingr_p1..ingr_p6} describes ingridients and their properties.
         * This ingridients are adding to the sixteenth recipe.
         */

        k++;
        Ingridient ingr_p1 = new Ingridient("Арбуз", 12, 4000, "г", recipeList.get(k));
        Ingridient ingr_p2 = new Ingridient("Сахарная пудра", 230, 300, "г", recipeList.get(k));
        Ingridient ingr_p3 = new Ingridient("Сливки", 1500, 250, "г", recipeList.get(k));
        Ingridient ingr_p4 = new Ingridient("Фисташки (очищенные)", 200, 100, "г", recipeList.get(k));
        Ingridient ingr_p5 = new Ingridient("Желатин", 2, 50, "г", recipeList.get(k));
        Ingridient ingr_p6 = new Ingridient("Ром", 20, 50, "мл.", recipeList.get(k));

        /**
         * {@code list15} unities ingridients that belong to one recipe.
         */

        List<Ingridient> list15 = new ArrayList<Ingridient>(Arrays.asList(ingr_p1, ingr_p2, ingr_p3, ingr_p4, ingr_p5, ingr_p6));

        /**
         * {@code ingr_q1..ingr_q4} describes ingridients and their properties.
         * This ingridients are adding to the seventeenth recipe.
         */

        k++;
        Ingridient ingr_q1 = new Ingridient("Черника (свежая или замороженная)", 12, 400, "г", recipeList.get(k));
        Ingridient ingr_q2 = new Ingridient("Лед", 23, 300, "г", recipeList.get(k));
        Ingridient ingr_q3 = new Ingridient("Молоко", 200, 400, "мл.", recipeList.get(k));
        Ingridient ingr_q4 = new Ingridient("Сахар", 250, 50, "г", recipeList.get(k));

        /**
         * {@code list16} unities ingridients that belong to one recipe.
         */

        List<Ingridient> list16 = new ArrayList<Ingridient>(Arrays.asList(ingr_q1, ingr_q2, ingr_q3, ingr_q4));

        /**
         * {@code ingr_r1..ingr_r6} describes ingridients and their properties.
         * This ingridients are adding to the eighteenth recipe.
         */

        k++;
        Ingridient ingr_r1 = new Ingridient("Клюквенный морс", 12, 50, "мл.", recipeList.get(k));
        Ingridient ingr_r2 = new Ingridient("Черника", 23, 100, "г", recipeList.get(k));
        Ingridient ingr_r3 = new Ingridient("Малина", 7, 100, "г", recipeList.get(k));
        Ingridient ingr_r4 = new Ingridient("Клубника", 20, 100, "г", recipeList.get(k));
        Ingridient ingr_r5 = new Ingridient("Лимонный сок", 2, 10, "мл.", recipeList.get(k));
        Ingridient ingr_r6 = new Ingridient("Гранатовый сок", 20, 50, "мл.", recipeList.get(k));

        /**
         * {@code list17} unities ingridients that belong to one recipe.
         */

        List<Ingridient> list17 = new ArrayList<Ingridient>(Arrays.asList(ingr_r1, ingr_r2, ingr_r3, ingr_r4, ingr_r5, ingr_r6));

        /**
         * {@code ingr_s1..ingrs47} describes ingridients and their properties.
         * This ingridients are adding to the nineteenth recipe.
         */

        k++;
        Ingridient ingr_s1 = new Ingridient("Чай черный", 12, 500, "мл.", recipeList.get(k));
        Ingridient ingr_s2 = new Ingridient("Лимоны", 23, 6, "шт.", recipeList.get(k));
        Ingridient ingr_s3 = new Ingridient("Ром темный", 7, 300, "мл.", recipeList.get(k));
        Ingridient ingr_s4 = new Ingridient("Сахар", 20, 200, "г", recipeList.get(k));

        /**
         * {@code list18} unities ingridients that belong to one recipe.
         */

        List<Ingridient> list18 = new ArrayList<Ingridient>(Arrays.asList(ingr_s1, ingr_s2, ingr_s3, ingr_s4));

        /**
         * {@code ingr_t1..ingr_t5} describes ingridients and their properties.
         * This ingridients are adding to the twentyth recipe.
         */

        k++;
        Ingridient ingr_t1 = new Ingridient("Белый ром", 120, 30, "мл.", recipeList.get(k));
        Ingridient ingr_t2 = new Ingridient("Мята", 23, 20, "г", recipeList.get(k));
        Ingridient ingr_t3 = new Ingridient("Лайм", 7, 50, "г", recipeList.get(k));
        Ingridient ingr_t4 = new Ingridient("Тросниковый сахар", 200, 25, "г", recipeList.get(k));
        Ingridient ingr_t5 = new Ingridient("Содовая", 250, 150, "мл.", recipeList.get(k));

        /**
         * {@code list19} unities ingridients that belong to one recipe.
         */

        List<Ingridient> list19 = new ArrayList<Ingridient>(Arrays.asList(ingr_t1, ingr_t2, ingr_t3, ingr_t4, ingr_t5));


        /**
         * {@code listOfIngridientsLists} unities all the lists of ingridients {@code list0...list19}
         * with using add() method.
         */

        listOfIngridientsLists = new ArrayList<List<Ingridient>>();
        listOfIngridientsLists.add(list0);
        listOfIngridientsLists.add(list1);
        listOfIngridientsLists.add(list2);
        listOfIngridientsLists.add(list3);
        listOfIngridientsLists.add(list4);
        listOfIngridientsLists.add(list5);
        listOfIngridientsLists.add(list6);
        listOfIngridientsLists.add(list7);
        listOfIngridientsLists.add(list8);
        listOfIngridientsLists.add(list9);
        listOfIngridientsLists.add(list10);
        listOfIngridientsLists.add(list11);
        listOfIngridientsLists.add(list12);
        listOfIngridientsLists.add(list13);
        listOfIngridientsLists.add(list14);
        listOfIngridientsLists.add(list15);
        listOfIngridientsLists.add(list16);
        listOfIngridientsLists.add(list17);
        listOfIngridientsLists.add(list18);
        listOfIngridientsLists.add(list19);

    }


    /**
     * {@method addSteps()}
     * creates Step entities and links they to the Recipes.
     * This method inicialize tep entity, link it to the recipe and add Step entities,
     * that belong to one recipe, in separate List.
     *
     * @throws Exception.Data(where ArrayList is empty)
     */

    public void addSteps() {

        /**
         * {@code k} uses as a array index of current recipe.
         */

        int k = 0;

        /**
         * {@code step_a1..step_a5} describes steps and their properties.
         * This steps are adding to the first recipe.
         */

        Step step_a1 = new Step(1, "Крупные грибы разрежьте на четвертинки, мелкие используйте целиком.", recipeList.get(k));
        Step step_a2 = new Step(2, "Перец очистите, удалите плодоножку, нарежьте соломкой.", recipeList.get(k));
        Step step_a3 = new Step(3, "Сыр и ветчину нарежьте тонкими ломтиками, соедините с грибами и сладким перцем.", recipeList.get(k));
        Step step_a4 = new Step(4, "Для заправки майонез смешайте с сахаром, соком, солью и горчицей.", recipeList.get(k));
        Step step_a5 = new Step(5, "При подаче салат смешайте с заправкой, выложите в салатницу и посыпьте зеленью.", recipeList.get(k));

        /**
         * {@code list0} unities steps that belong to one recipe.
         */

        List<Step> list0 = new ArrayList<Step>(Arrays.asList(step_a1, step_a2, step_a3, step_a4, step_a5));

        /**
         * {@code step_b1..step_b3} describes steps and their properties.
         * This steps are adding to the second recipe.
         */

        k++;
        Step step_b1 = new Step(1, "Дыню (лучше твердую) разрезать, очистить от семечек. Мякоть дыни извлечь из кожуры с помощью чайной ложки.", recipeList.get(k));
        Step step_b2 = new Step(2, "Дынную мякоть положите в глубокую тарелку, настрогайте цедры лайма, а затем выжмите из лайма сок.", recipeList.get(k));
        Step step_b3 = new Step(3, "Потрите имбирь, порубите мяту, смешайте с мякотью дыни. Добавьте сахар и мед. Перемешайте. Поставьте салат на полчаса в холодильник и подавайте.", recipeList.get(k));

        /**
         * {@code list1} unities steps that belong to one recipe.
         */

        List<Step> list1 = new ArrayList<Step>(Arrays.asList(step_b1, step_b2, step_b3));

        /**
         * {@code step_c1..step_c4} describes steps and their properties.
         * This steps are adding to the third recipe.
         */

        k++;
        Step step_с1 = new Step(1, "Рыжики отобрать, ошпарить крутым кипятком, выдержать в нем 1-2 минуты.", recipeList.get(k));
        Step step_с2 = new Step(2, "Лук почистить, порезать кубиками, обжарить на растительном масле.", recipeList.get(k));
        Step step_с3 = new Step(3, "Грибы отжать, добавить поджаренный лук, посолить, перемешать, заправить сметаной и перцем.", recipeList.get(k));
        Step step_с4 = new Step(4, "Тушить в разогретой до 180 градусов духовке 5-10 минут.", recipeList.get(k));

        /**
         * {@code list2} unities steps that belong to one recipe.
         */

        List<Step> list2 = new ArrayList<Step>(Arrays.asList(step_с1, step_с2, step_с3, step_с4));

        /**
         * {@code step_d1..step_d3} describes steps and their properties.
         * This steps are adding to the fourtht recipe.
         */

        k++;
        Step step_d1 = new Step(1, "Баклажан разрежьте пополам, тыкву нарежьте кубиками. Запеките овощи в духовке, сбрызнув оливковым маслом в течение 15-20 минут.", recipeList.get(k));
        Step step_d2 = new Step(2, "Тыкву смешайте в миске с фетой, свежей мятой и соком лимона.", recipeList.get(k));
        Step step_d3 = new Step(3, "Добавьте соль и черный перец. Начините смесью половинки баклажана.", recipeList.get(k));

        /**
         * {@code list3} unities steps that belong to one recipe.
         */

        List<Step> list3 = new ArrayList<Step>(Arrays.asList(step_d1, step_d2, step_d3));

        /**
         * {@code step_e1..step_e3} describes steps and their properties.
         * This steps are adding to the fifth recipe.
         */

        k++;
        Step step_e1 = new Step(1, "Отделить стебли брокколи от соцветий. Стебли нарезать небольшими кусочками и пасеровать вместе с колечками лука, на сковороде с антипригарным покрытием.", recipeList.get(k));
        Step step_e2 = new Step(2, "Хорошенько промыть соцветия и варить их в кипящей подсоленой воде примерно 15 минут. Добавить в кипящие соцветия обжаренный лук и стебли и кипятить суп еще 5-7 минут, добавить специи.", recipeList.get(k));
        Step step_e3 = new Step(3, "В отдельной кастрюле растопить сливочное масло, добавитить немного муки и сливки. Когда смесь загустеет, влить в нее суп. Затем взбить всю массу блендером до однородной консистенции. Украсить зеленью, брокколи и посыпать сухариками, обычно детям это нравится ).", recipeList.get(k));

        /**
         * {@code list4} unities steps that belong to one recipe.
         */

        List<Step> list4 = new ArrayList<Step>(Arrays.asList(step_e1, step_e2, step_e3));

        /**
         * {@code step_f1..step_f5} describes steps and their properties.
         * This steps are adding to the sixth recipe.
         */

        k++;
        Step step_f1 = new Step(1, "Кольраби очистить и нарезать тонкой соломкой. Сварить в течение 5 минут в 400 мл воды, отвар слить в отдельную посуду.", recipeList.get(k));
        Step step_f2 = new Step(2, "Твердый сыр натереть на мелкой терке. Рокфор или другой сыр с голубой плесенью нарезать небольшими кубиками.", recipeList.get(k));
        Step step_f3 = new Step(3, "В кастрюле на маленьком огне растопить сливочное масло и добавить в него муку, тщательно перемешать. В муку постепенно добавить молоко и капустный отвар, постоянно помешивая, чтобы не было комочков. Довести до кипения.", recipeList.get(k));
        Step step_f4 = new Step(4, "Далее добавить оба сыра, постоянно помешивая. Готовить на небольшом огне, пока сыр не расплавится. Затем добавить виноградный сок, соль, перец и мускатный орех по вкусу и довести до кипения.", recipeList.get(k));
        Step step_f5 = new Step(5, "Нарезанную кольраби положить в суп, поварить еще 5 минут и выключить.", recipeList.get(k));

        /**
         * {@code list5} unities steps that belong to one recipe.
         */

        List<Step> list5 = new ArrayList<Step>(Arrays.asList(step_f1, step_f2, step_f3, step_f4, step_f5));

        /**
         * {@code step_g1..step_g4} describes steps and their properties.
         * This steps are adding to the seventh recipe.
         */

        k++;
        Step step_g1 = new Step(1, "Нарезанный репчатый лук обжарить в растительном масле до золотистого цвета. Добавить томатное пюре и красный перец. Тушить на небольшом огне несколько минут.", recipeList.get(k));
        Step step_g2 = new Step(2, "Добавить красную фасоль и тушить еще 20 минут без крышки.", recipeList.get(k));
        Step step_g3 = new Step(3, "Добавить томатную смесь в бульон. Суп должен быть достаточно густой консистенции. При необходимости можно загустить суп мукой.", recipeList.get(k));
        Step step_g4 = new Step(4, "Перед окончанием приготовления добавить большое количество рубленой зелени.", recipeList.get(k));

        /**
         * {@code list6} unities steps that belong to one recipe.
         */

        List<Step> list6 = new ArrayList<Step>(Arrays.asList(step_g1, step_g2, step_g3, step_g4));

        /**
         * {@code step_h1..step_h5} describes steps and their properties.
         * This steps are adding to the eighth recipe.
         */

        k++;
        Step step_h1 = new Step(1, "Рыбу почистить, отделить филе от костей, удалить жабры. Можно удалить глаза.", recipeList.get(k));
        Step step_h2 = new Step(2, "Овощи почистить и порезать кубиками. Обжарить их в тяжелой чугунной кастрюле на оливковом масле. Положил туда же рыбьи головы и кости. Сверху положить апельсиновую корочку (лучше сушеную). Залить холодной водой и варить на очень слабом огне примерно 2 часа. \n" +
                "Апельсиновую корку надо удалить через двадцать минут после того, как закипит. Варить лучше под крышкой.", recipeList.get(k));
        Step step_h3 = new Step(3, "Бульон процедить сквозь сито. Все, что осталось в чугунной кастрюле выбросить. Добавить в процеженный бульон бокал белого вина и рюмку анисовой водки. Вместо анисовой водки можно положить 1 звездочку бадьяна.", recipeList.get(k));
        Step step_h4 = new Step(4, "Поставить бульон на огонь, довести до кипения, добавить лавровый лист и положить раков. Варить примерно десять минут. Добавить рыбное филе, варить до готовности. Отдельно сварить картофель.", recipeList.get(k));
        Step step_h5 = new Step(5, "Приготовить соус. Примерно 50 г вареного картофеля размять и добавить к нему толченый чеснок (1-1,5 зубка), молотого черного перца, соль и яичные желтки. Все перемешать и протереть через сито. Этим соусом можно заправлять суп, но лучше намазать им кусок обжаренного хлеба, а хлеб положить прямо в бульон. Туда же положить раков, рыбное филе и отварной картофель.", recipeList.get(k));

        /**
         * {@code list7} unities steps that belong to one recipe.
         */

        List<Step> list7 = new ArrayList<Step>(Arrays.asList(step_h1, step_h2, step_h3, step_h4, step_h5));

        /**
         * {@code step_i1..step_i3} describes steps and their properties.
         * This steps are adding to the nineth recipe.
         */

        k++;
        Step step_i1 = new Step(1, "Нарежьте филе горбуши мелкими кубиками. Репчатый лук мелко нарубите. Филе смешайте с рубленым луком и охлаждайте 2 часа.", recipeList.get(k));
        Step step_i2 = new Step(2, "Рыбный фарш смешайте с яйцами, майонезом, крахмалом, мускатным орехом, посолите, поперчите и еще раз перемешайте. Из массы сформуйте шницели, запанируйте их в сухарях.", recipeList.get(k));
        Step step_i3 = new Step(3, "Жарьте на хорошо разогретом масле до образования золотистой корочки.", recipeList.get(k));

        /**
         * {@code list8} unities steps that belong to one recipe.
         */

        List<Step> list8 = new ArrayList<Step>(Arrays.asList(step_i1, step_i2, step_i3));

        /**
         * {@code step_j1..step_j4} describes steps and their properties.
         * This steps are adding to the tenth recipe.
         */

        k++;
        Step step_j1 = new Step(1, "Филе индейки пропустить через мясорубку 2 раза вместе с 200 г сливочного масла. Добавить 1 яйцо, соль, перец, сливки (300 мл) и перемешать массу до однородности.", recipeList.get(k));
        Step step_j2 = new Step(2, "Сформовать котлеты, обвалять их в муке и обжарить на растительном масле.", recipeList.get(k));
        Step step_j3 = new Step(3, "Картофель очистить, сварить, добавить в него 150 г масла, оставшиеся сливки и протереть через сито или мельницу до состояния жидкого пюре. В горячее пюре добавить горсть листьев свежей рукколы.", recipeList.get(k));
        Step step_j4 = new Step(4, "Котлеты подавать с пюре.", recipeList.get(k));

        /**
         * {@code list9} unities steps that belong to one recipe.
         */

        List<Step> list9 = new ArrayList<Step>(Arrays.asList(step_j1, step_j2, step_j3, step_j4));


        /**
         * {@code step_k1..step_k4} describes steps and their properties.
         * This steps are adding to the eleventh recipe.
         */

        k++;
        Step step_k1 = new Step(1, "Вначале почистите лук, порежьте тонкими кольцами и обжарьте в масле.", recipeList.get(k));
        Step step_k2 = new Step(2, "Грибы помойте, высушите, порежьте кусочками и добавьте к луку. Обжарьте 10 минут на среднем огне.", recipeList.get(k));
        Step step_k3 = new Step(3, "Добавьте сливки, тертый мускатный орех и готовьте еще 5 минут на медленном огне, постоянно помешивая.", recipeList.get(k));
        Step step_k4 = new Step(4, "Поставьте сковороду с грибами в разогретую духовку на 2 минуты. Посыпьте зеленью. Можно добавить шнитт-лук или петрушку.", recipeList.get(k));

        /**
         * {@code list10} unities steps that belong to one recipe.
         */

        List<Step> list10 = new ArrayList<Step>(Arrays.asList(step_k1, step_k2, step_k3, step_k4));

        /**
         * {@code step_l1..step_l5} describes steps and their properties.
         * This steps are adding to the twelfth recipe.
         */

        k++;
        Step step_l1 = new Step(1, "Лосось нарезать на 2 стейка. Сбрызнуть лимонным соком, приправить белым перцем, специями к рыбе и солью.", recipeList.get(k));
        Step step_l2 = new Step(2, "Оливковое масло хорошо разогреть на сковороде и обжарить стейки по 3 минуты с каждой стороны.", recipeList.get(k));
        Step step_l3 = new Step(3, "Спаржу очистить, срезать концы, сварить в кипящей подсоленной воде 10 минут.", recipeList.get(k));
        Step step_l4 = new Step(4, "Брокколи помыть, разделить на соцветия. Сварить в подсоленной воде 5-7 минут.", recipeList.get(k));
        Step step_l5 = new Step(5, "Подавать стейки лосося с вареными овощами и дольками лимона.", recipeList.get(k));

        /**
         * {@code list11} unities steps that belong to one recipe.
         */

        List<Step> list11 = new ArrayList<Step>(Arrays.asList(step_l1, step_l2, step_l3, step_l4, step_l5));

        /**
         * {@code step_m1..step_m5} describes steps and their properties.
         * This steps are adding to the thirteenth recipe.
         */

        k++;
        Step step_m1 = new Step(1, "Сливки довести до кипения, добавить шоколад, поломанный на маленькие кусочки, мешать до однородности.", recipeList.get(k));
        Step step_m2 = new Step(2, "К шоколадной массе добавить масло и ликер, перемешать и убрать в холодильник на 8 часов минимум.", recipeList.get(k));
        Step step_m3 = new Step(3, "Через 8 часов достать шоколадную массу и с помощью ложки слепить конфеты.", recipeList.get(k));
        Step step_m4 = new Step(4, "Выложить их на тарелку и убрать в морозильник на 10 минут.", recipeList.get(k));
        Step step_m5 = new Step(5, "Через 10 минут трюфели обвалять в какао и снова охладить. Есть с удовольствием!", recipeList.get(k));

        /**
         * {@code list12} unities steps that belong to one recipe.
         */

        List<Step> list12 = new ArrayList<Step>(Arrays.asList(step_m1, step_m2, step_m3, step_m4, step_m5));

        /**
         * {@code step_n1..step_n4} describes steps and their properties.
         * This steps are adding to the fourteenth recipe.
         */

        k++;
        Step step_n1 = new Step(1, "На хорошо разогретой сковородке со сливочным маслом обжарьте кардамон и мелко натертую морковь. Добавьте сахар. Постоянно помешивая, подержите сковородку на огне 15 минут.", recipeList.get(k));
        Step step_n2 = new Step(2, "Добавьте кешью, изюм (лучше брать светлый). Для вязкости будущей халвы добавьте манную крупу. Залейте все смесью молока и сливок и варите в течение часа-полтора на небольшом огне, помешивая. ", recipeList.get(k));
        Step step_n3 = new Step(3, "Однородную готовую морковную массу поместите в форму, дайте остыть и отправьте в холодильник на несколько часов.", recipeList.get(k));
        Step step_n4 = new Step(4, "Морковную халву можно подавать с любым сладким соусом, к примеру, с шоколадным.", recipeList.get(k));

        /**
         * {@code list13} unities steps that belong to one recipe.
         */

        List<Step> list13 = new ArrayList<Step>(Arrays.asList(step_n1, step_n2, step_n3, step_n4));

        /**
         * {@code step_o1..step_o3} describes steps and their properties.
         * This steps are adding to the fifteenth recipe.
         */

        k++;
        Step step_o1 = new Step(1, "Желтки взбить с сахарной пудрой и ванилином. Перемешать аккуратно с маскарпоне и взбитыми сливками.", recipeList.get(k));
        Step step_o2 = new Step(2, "Савоярди смачиваем в кофе с ромом.", recipeList.get(k));
        Step step_o3 = new Step(3, "Выкладываем савоярди в форму. Ложим сверху крем. Снова слой савоярди. Сверху крем. Посыпаем шоколадом и ставим в холодильник.", recipeList.get(k));

        /**
         * {@code list14} unities steps that belong to one recipe.
         */

        List<Step> list14 = new ArrayList<Step>(Arrays.asList(step_o1, step_o2, step_o3));

        /**
         * {@code step_p1..step_p5} describes steps and their properties.
         * This steps are adding to the sixteenth recipe.
         */

        k++;
        Step step_p1 = new Step(1, "Положите фисташки и 200 г сахарной пудры в кастрюлю и поставьте на медленный огонь, пока пудра не растает и превратится в карамель. Вылейте массу в форму, застеленную бумагой для выпечки и остудите.", recipeList.get(k));
        Step step_p2 = new Step(2, "Очистите арбуз от корки и семян, нарежьте на куски, а затем поместите в блендер и смешайте до однородной консистенции.", recipeList.get(k));
        Step step_p3 = new Step(3, "Вылейте в кастрюлю примерно 150 мл арбузного сока. Добавьте ром и 100 г сахарной пудры. Подогревайте на медленном огне, пока сахар не растворится. Добавьте желатин и размешайте до полного растворения.", recipeList.get(k));
        Step step_p4 = new Step(4, "Процедите оставшийся арбузный сок в желатин, перемешайте, разлейте в стаканы для десерта и охлаждайте в холодильнике в течение не менее 3 часов (лучше на всю ночь).", recipeList.get(k));
        Step step_p5 = new Step(5, "Положите ложку сливок на застывшее арбузное желе. Раскрошите карамель с фисташками крупными кусочками и посыпьте сливки. Украсьте желе веточкой мяты.", recipeList.get(k));

        /**
         * {@code list15} unities steps that belong to one recipe.
         */

        List<Step> list15 = new ArrayList<Step>(Arrays.asList(step_p1, step_p2, step_p3, step_p4, step_p5));

        /**
         * {@code step_q1..step_q4} describes steps and their properties.
         * This steps are adding to the seventeenth recipe.
         */

        k++;
        Step step_q1 = new Step(1, "В чашу блендера засыпьте весь лед.", recipeList.get(k));
        Step step_q2 = new Step(2, "Долейте молоко, добавьте сахар и ягоды.", recipeList.get(k));
        Step step_q3 = new Step(3, "Все ингредиенты взбейте на высокой скорости.", recipeList.get(k));
        Step step_q4 = new Step(4, "Разлейте шейк по высоким стаканам, украсьте ягодами. Самый вкусный и питательный коктейль готов, угощайтесь!", recipeList.get(k));

        /**
         * {@code list16} unities steps that belong to one recipe.
         */

        List<Step> list16 = new ArrayList<Step>(Arrays.asList(step_q1, step_q2, step_q3, step_q4));

        /**
         * {@code step_r1..step_r4} describes steps and their properties.
         * This steps are adding to the eighteenth recipe.
         */

        k++;
        Step step_r1 = new Step(1, "Все ягоды клубники нарежьте на 4 части. Ягоды с сахаром и свежевыжатым лимонным соком поместите в высокий объемный стакан. Придавите все ингредиенты деревянной ложкой. Делайте это аккуратно, слегка растирая ягоды с сахаром.", recipeList.get(k));
        Step step_r2 = new Step(2, "В стакан с ягодами долейте клюквенный морс и гранатовый сок.", recipeList.get(k));
        Step step_r3 = new Step(3, "Накройте стакан другим стаканом и хорошо взболтайте коктейль.", recipeList.get(k));
        Step step_r4 = new Step(4, "Процедите ягодный напиток в охлажденный высокий бокал так, чтобы все ягоды не попали в него. Добавьте ледовую крошку и украсьте веточкой мяты (по желанию). Самый освежающий летний коктейль готов!", recipeList.get(k));

        /**
         * {@code list17} unities steps that belong to one recipe.
         */

        List<Step> list17 = new ArrayList<Step>(Arrays.asList(step_r1, step_r2, step_r3, step_r4));

        /**
         * {@code step_s1..step_s3} describes steps and their properties.
         * This steps are adding to the nineteenth recipe.
         */

        k++;
        Step step_s1 = new Step(1, "Положить цедру и лимонный сок из 6 лимонов в кастрюлю с процеженным черным чаем и сахаром.", recipeList.get(k));
        Step step_s2 = new Step(2, "Мешать сахар, пока не растворится. Оставить на 1 час.", recipeList.get(k));
        Step step_s3 = new Step(3, "Добавить темный ром. Подавать с большим количеством льда, украсив апельсином и мятой.", recipeList.get(k));

        /**
         * {@code list18} unities steps that belong to one recipe.
         */

        List<Step> list18 = new ArrayList<Step>(Arrays.asList(step_s1, step_s2, step_s3));

        /**
         * {@code step_t1..step_t2} describes steps and their properties.
         * This steps are adding to the twentyth recipe.
         */

        k++;
        Step step_t1 = new Step(1, "В высокий стакан кладем листики мяты и дольки лайма, предварительно выжав из них сок в стакан. Засыпаем сахаром и разминаем содержимое стакана деревянной ступкой (за неимением ступки можно размять ложкой).", recipeList.get(k));
        Step step_t2 = new Step(2, "Затем добавляем белый ром и перемешиваем, насыпаем практически доверху колотый лед и заливаем содовой или тоником. Украшаем бокал долькой лайма и мятой.", recipeList.get(k));

        /**
         * {@code list19} unities steps that belong to one recipe.
         */

        List<Step> list19 = new ArrayList<Step>(Arrays.asList(step_t1, step_t2));


        /**
         * {@code listOfStepsLists} unities all the lists of steps {@code list0...list19}
         * with using add() method.
         */

        listOfStepsLists = new ArrayList<List<Step>>();
        listOfStepsLists.add(list0);
        listOfStepsLists.add(list1);
        listOfStepsLists.add(list2);
        listOfStepsLists.add(list3);
        listOfStepsLists.add(list4);
        listOfStepsLists.add(list5);
        listOfStepsLists.add(list6);
        listOfStepsLists.add(list7);
        listOfStepsLists.add(list8);
        listOfStepsLists.add(list9);
        listOfStepsLists.add(list10);
        listOfStepsLists.add(list11);
        listOfStepsLists.add(list12);
        listOfStepsLists.add(list13);
        listOfStepsLists.add(list14);
        listOfStepsLists.add(list15);
        listOfStepsLists.add(list16);
        listOfStepsLists.add(list17);
        listOfStepsLists.add(list18);
        listOfStepsLists.add(list19);

    }

    @RequestMapping(value = {"/filldb"})
    public ModelAndView fillDb() {

        addRecipes();

        /**
         * adding information in DB with a help of the categoriesService
         */

        for (Categories categories : categoriesList) {
            categoriesService.addCategories(categories);
        }

        /**
         * adding information in DB with a help of the cuisineService
         */

        for (Cuisine cuisine : cuisineList) {
            cuisineService.addCuisine(cuisine);
        }

        /**
         * adding information in DB with a help of the recipeService
         */

        for (Recipe recipe : recipeList) {
            recipeService.addRecipe(recipe);
        }


        addIngridients();

        /**
         * adding information in DB with a help of the ingridientService
         */

        for (List<Ingridient> listOfIngridient : listOfIngridientsLists) {
            for (Ingridient ingridient : listOfIngridient) {
                ingridientService.addIngridient(ingridient);
            }
        }

        addSteps();

        /**
         * adding information in DB with a help of the stepService
         */

        for (List<Step> listOfSteps : listOfStepsLists) {
            for (Step step : listOfSteps) {
                stepService.addStep(step);
            }
        }


        /**
         * return information from DB on view for example
         */
        return new ModelAndView("filldb", "model", this.cuisineService.getCuisine());
    }
}