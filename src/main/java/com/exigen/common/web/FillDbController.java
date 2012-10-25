package com.exigen.common.web;


import com.exigen.common.domain.Categories;
import com.exigen.common.domain.Cuisine;
import com.exigen.common.domain.Meal;
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
 * @DATE September 16, 2012
 * @author Ivan.
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

    /**
     * {@method getOneRecipeList(Integer recipeId)} using for test
     * our add and get methods in DAO
     * @return list of cuisines on filldb view
     *
     */
    public void addItems(){
        /**
         * {@code cat1..5} describes categories for our DB
         */

        Categories cat1 = new Categories("Закуски");
        Categories cat2 = new Categories("Первое");
        Categories cat3 = new Categories("Второе");
        Categories cat4 = new Categories("Десерты");
        Categories cat5 = new Categories("Напитки");
        categoriesList =  new ArrayList<Categories>(Arrays.asList(cat1,cat2,cat3,cat4,cat5));

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
        cuisineList=new ArrayList<Cuisine>(Arrays.asList(cuisine1,cuisine2,cuisine3,cuisine4,cuisine5,cuisine6,cuisine7,cuisine8,cuisine9,cuisine10,cuisine11,cuisine12));

        /**
         * {@code bigImg1..bigImg20} describes big images for our DB
         */

        String bigImg1=   "http://eda.2k.ua/content/catalog/gribnoy_salat_so_sladkim_pertsem_orig.jpg";
        String bigImg2=   "http://eda.2k.ua/content/catalog/dynya_s_myatoy_i_imbirem_orig.jpg";
        String bigImg3=   "http://eda.2k.ua/content/catalog/ryzhiki_zapechennye_v_smetane_orig.jpg";
        String bigImg4=   "http://eda.2k.ua/content/catalog/item_7534_orig.jpg";
        String bigImg5=   "http://eda.2k.ua/content/catalog/kremsup_iz_brokkoli_malysh_orig.jpg";
        String bigImg6=   "http://eda.2k.ua/content/catalog/item_7436_orig.jpg";
        String bigImg7=   "http://eda.2k.ua/content/catalog/item_7238_orig.jpg";
        String bigImg8=   "http://eda.2k.ua/content/catalog/item_6822_orig.jpg";
        String bigImg9=   "http://eda.2k.ua/content/catalog/item_7570_orig.jpg";
        String bigImg10=   "http://eda.2k.ua/content/catalog/kotlety_iz_indeyki_s_kartofelnym_pyure_orig.jpg";
        String bigImg11=   "http://eda.2k.ua/content/catalog/belye_griby_v_slivochnom_souse_orig.jpg";
        String bigImg12=   "http://eda.2k.ua/content/catalog/steyk_lososya_so_sparzhey_i_brokkoli_orig.jpg";
        String bigImg13=   "http://eda.2k.ua/content/catalog/tryufeli_shokoladnye_orig.jpg";
        String bigImg14=   "http://eda.2k.ua/content/catalog/item_7606_orig.jpg";
        String bigImg15=   "http://eda.2k.ua/content/catalog/tiramisu_1346050002_7154_orig.jpg";
        String bigImg16=   "http://eda.2k.ua/content/catalog/arbuznoe_zhele_s_fistashkovym_praline_orig.jpg";
        String bigImg17=   "http://eda.2k.ua/content/catalog/molochnyy_sheyk_s_chernikoy_orig.jpg";
        String bigImg18=   "http://eda.2k.ua/content/catalog/item_7130_orig.jpg";
        String bigImg19=   "http://eda.2k.ua/content/catalog/limonnyy_punsh_orig.jpg";
        String bigImg20=   "http://eda.2k.ua/content/catalog/kokteyl_mokhito_orig.jpg";

        /**
         * {@code smallImg1..smallImg20} describes small images for our DB
         */
        String smallImg1= "http://eda.2k.ua/content/catalog/gribnoy_salat_so_sladkim_pertsem_orig.jpg";
        String smallImg2= "http://eda.2k.ua/content/catalog/dynya_s_myatoy_i_imbirem_orig.jpg";
        String smallImg3= "http://eda.2k.ua/content/catalog/ryzhiki_zapechennye_v_smetane_orig.jpg";
        String smallImg4= "http://eda.2k.ua/content/catalog/item_7534_orig.jpg";
        String smallImg5= "http://eda.2k.ua/content/catalog/kremsup_iz_brokkoli_malysh_orig.jpg";
        String smallImg6= "http://eda.2k.ua/content/catalog/item_7436_orig.jpg";
        String smallImg7= "http://eda.2k.ua/content/catalog/item_7238_orig.jpg";
        String smallImg8= "http://eda.2k.ua/content/catalog/item_6822_orig.jpg";
        String smallImg9= "http://eda.2k.ua/content/catalog/item_7570_orig.jpg";
        String smallImg10= "http://eda.2k.ua/content/catalog/kotlety_iz_indeyki_s_kartofelnym_pyure_orig.jpg";
        String smallImg11= "http://eda.2k.ua/content/catalog/belye_griby_v_slivochnom_souse_orig.jpg";
        String smallImg12= "http://eda.2k.ua/content/catalog/steyk_lososya_so_sparzhey_i_brokkoli_orig.jpg";
        String smallImg13= "http://eda.2k.ua/content/catalog/tryufeli_shokoladnye_orig.jpg";
        String smallImg14= "http://eda.2k.ua/content/catalog/item_7606_orig.jpg";
        String smallImg15= "http://eda.2k.ua/content/catalog/tiramisu_1346050002_7154_orig.jpg";
        String smallImg16= "http://eda.2k.ua/content/catalog/arbuznoe_zhele_s_fistashkovym_praline_orig.jpg";
        String smallImg17= "http://eda.2k.ua/content/catalog/molochnyy_sheyk_s_chernikoy_orig.jpg";
        String smallImg18= "http://eda.2k.ua/content/catalog/item_7130_orig.jpg";
        String smallImg19= "http://eda.2k.ua/content/catalog/limonnyy_punsh_orig.jpg";
        String smallImg20= "http://eda.2k.ua/content/catalog/kokteyl_mokhito_orig.jpg";

        /**
         * {@code description1..description20} describes descriptions for our DB
         */
        String description1= "Основной ингредиент:  Грибы, Мясо, дичь, Овощи, Сыр, творог";
        String description2= "По ингредиенту:  Зелень и травы, Фрукты, ягоды, орехи";
        String description3= "По ингредиенту:  Грибы, Молочные продукты";
        String description4= "По ингредиенту:  Зелень и травы, Овощи, Сыр, творог, Кабачки и баклажаны";
        String description5= "Основной ингредиент:   Брокколи, лук, сливки";
        String description6= "По ингредиенту  Зелень и травы, Молочные продукты, Овощи, Сыр, творог";
        String description7= "По ингредиенту:  Бобовые и крупы, Зелень и травы, Овощи";
        String description8= "По ингредиенту: Зелень и травы, Овощи, Рыба и морепродукты, Соусы и маринады";
        String description9= "По ингредиенту:   Рыба и морепродукты";
        String description10= "По ингредиенту:Молочные продукты, Мясо, дичь, Картофель";
        String description11= "По ингредиенту: Молочные продукты, Мясо, дичь, Картофель";
        String description12= "По ингредиенту:Овощи, Рыба и морепродукты";
        String description13= "Основной ингредиент:  Шоколад";
        String description14= "По ингредиенту:Молочные продукты, Овощи";
        String description15= "По ингредиенту   Молочные продукты, Сыр, творог";
        String description16= "По ингредиенту:  Зелень и травы, Молочные продукты, Фрукты, ягоды, орехи";
        String description17= "По ингредиенту:  Молочные продукты, Фрукты, ягоды, орехи";
        String description18= "По ингредиенту:  Фрукты, ягоды, орехи";
        String description19= "По ингредиенту: Алкоголь, Фрукты, ягоды, орехи";
        String description20= "По ингредиенту:  Алкоголь, Зелень и травы, Фрукты, ягоды, орехи";

        /**
         * {@code rec1..rec20} describes recipes for our DB
         */
        Recipe rec1 = new Recipe("Грибной салат с болгарским перцем", Meal.DINNER,
                description1	,  cuisine2  , cat1, bigImg1, smallImg1, 1 );

        Recipe rec2 = new Recipe(  "Дыня с мятой и имбирем ", Meal.DINNER,
                description2	,  cuisine2  , cat1, bigImg2, smallImg2, 1 );

        Recipe rec3 = new Recipe("Рыжики запеченные в сметане ", Meal.DINNER,
                description3	,  cuisine2  , cat1, bigImg3, smallImg3, 1 );

        Recipe rec4 = new Recipe("Салат из баклажанов и феты ", Meal.DINNER,
                description4	,  cuisine2  , cat1, bigImg4, smallImg4, 1 );

        Recipe rec5 = new Recipe("Крем-суп из брокколи \"Малыш\" ", Meal.BREAKFAST,
                description5	,  cuisine2  , cat2, bigImg5, smallImg5, 1 );

        Recipe rec6 = new Recipe("Сырный суп с кольраби ", Meal.BREAKFAST,
                description6	,  cuisine2  , cat2, bigImg6, smallImg6, 1 );

        Recipe rec7 = new Recipe(" Острый томатный суп с фасолью", Meal.BREAKFAST,
                description7	,  cuisine2  , cat2, bigImg7, smallImg7, 1 );

        Recipe rec8 = new Recipe("Рыбный суп с морепродуктами ", Meal.BREAKFAST,
                description8	,  cuisine2  , cat2, bigImg8, smallImg8, 1 );

        Recipe rec9 = new Recipe("Шницели из горбуши ", Meal.DINNER,
                description9	,  cuisine2  , cat3, bigImg9, smallImg9, 1 );

        Recipe rec10 = new Recipe(" Котлеты из индейки с картофельным пюре", Meal.DINNER,
                description10	,  cuisine2  , cat3, bigImg10, smallImg10, 1 );

        Recipe rec11 = new Recipe(" Белые грибы в сливочном соусе ", Meal.DINNER,
                description11	,  cuisine2  , cat3, bigImg11, smallImg11, 1 );

        Recipe rec12 = new Recipe("Стейк лосося со спаржей и брокколи ", Meal.DINNER,
                description12	,  cuisine2  , cat3, bigImg12, smallImg12, 1 );

        Recipe rec13 = new Recipe("Трюфели шоколадные ", Meal.SUPPER,
                description13	,  cuisine2  , cat4, bigImg13, smallImg13, 1 );

        Recipe rec14 = new Recipe(" Гаджарка-халва. Халва из моркови", Meal.SUPPER,
                description14	,  cuisine2  , cat4, bigImg14, smallImg14, 1 );

        Recipe rec15 = new Recipe("Тирамису ", Meal.SUPPER,
                description15	,  cuisine2  , cat4, bigImg15, smallImg15, 1 );

        Recipe rec16 = new Recipe(" Арбузное желе с фисташковой карамелью", Meal.DINNER,
                description16	,  cuisine2  , cat4, bigImg16, smallImg16, 1 );

        Recipe rec17 = new Recipe(" Молочный шейк с черникой", Meal.DINNER,
                description17	,  cuisine2  , cat5, bigImg17, smallImg17, 1 );

        Recipe rec18 = new Recipe("Коктейль \"Ягодный смэш\" ", Meal.DINNER,
                description18	,  cuisine2  , cat5, bigImg18, smallImg18, 1 );

        Recipe rec19 = new Recipe("Лимонный пунш ", Meal.DINNER,
                description19	,  cuisine2  , cat5, bigImg19, smallImg19, 1 );

        Recipe rec20 = new Recipe("Коктейль \"Мохито\" ", Meal.DINNER,
                description20	,  cuisine2  , cat5, bigImg20, smallImg20, 1 );

        recipeList=new ArrayList<Recipe>(Arrays.asList(rec1,rec2,rec3,rec4,rec5,rec6,rec7,rec8,rec9,rec10,rec11,rec12,rec13,rec14,rec15,rec16,rec17,rec18,rec19,rec20));
    }


    @RequestMapping(value = {"/filldb"})
    public ModelAndView fillDb() {
        addItems();
        /**
         * adding information in DB with helps cuisineService
         */
        for(Cuisine cuisine: cuisineList){
            cuisineService.addCuisine(cuisine);
        }

        /**
         * adding information in DB with helps categoriesService
         */
        for(Categories categories: categoriesList){
            categoriesService.addCategories(categories);
        }
        /**
         * adding information in DB with helps recipeService
         */
        for(Recipe recipe:recipeList){
            recipeService.addRecipe(recipe);
        }

        /**
         * return information from DB on view for example
         */
        return new ModelAndView("filldb", "model", this.cuisineService.getCuisine());
    }
}