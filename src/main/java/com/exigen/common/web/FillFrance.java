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
 * Created by IntelliJ IDEA.
 * User: TonySoprano
 * Date: 14.02.13
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 */
@Controller                     //TODO
public class FillFrance {
    /**
     * {@code categoriesService} describes the CategoriesService for inject on this
     * class
     */
    private static final int CUISINE_NUMBER = 7;    //TODO
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
    private IngredientService ingredientService;


    @Autowired
    private StepService stepService;

    @Autowired
    private MeasureService measureService;
    
    @Autowired
    private MeasureBucketService measureBucketService;
    
    @Autowired
    private IngredientBucketService ingredientBucketService;
    /**
     * {@code Lsts} add lists for Category, suisines, recipes and ext
     */


    private List<Category> categoriesList;
    private List<Cuisine> cuisineList;
    private List<Recipe> recipeList;
    private List<String> bigImgList;
    private List<String> smallImgList;
    private List<String> descriptionList;
    private List<String> titleList;
    private List<Integer> timeList;
    private List<List<Ingredient>> listOfIngridientsLists;
    private List<List<Step>> listOfStepsLists;
    private List<Measure> listMeasure;
    private List<List<MeasuresBucket>> listOfMeasureBucketLists;
    private List<List<IngredientBucket>> listOfIngredientBucketLists;



    /**
     * {@method addCategories()}
     * creates for adding Category for creation in recipe entity. This
     * method inicialize variables for recipes and add it in smallImgList
     */
 public void addCategories() {
        Category cat1 = new Category("Закуски");
        Category cat2 = new Category("Первое");
        Category cat3 = new Category("Второе");
        Category cat4 = new Category("Десерты");
        Category cat5 = new Category("Напитки");


        /**
         * {@code categoriesList} add  Category in the list
         */


        categoriesList = new ArrayList<Category>(Arrays.asList(cat1, cat2, cat3, cat4, cat5));


        for(Category Categories:categoriesList){
            categoriesService.addCategories(Categories);
        }
    }


    /**
     * {@method addCuisines()}
     * creates for adding cuisines for creation in recipe entity. This
     * method inicialize variables for recipes and add it in smallImgList
     */


    public void addCuisines() {
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

         for(Cuisine cuisine:cuisineList){
             cuisineService.addCuisine(cuisine);
         }

    }
   /**
     * {@method addBigImg()}
     * creates for adding big image field for creation in recipe entity. This
     * method inicialize variables for recipes and add it in smallImgList
     */

    //TODO
    public void addBigImg() {


        /**
         * {@code bigImg1..bigImg20} describes big images for our DB. This images adding into our cuisines
         */


        String bigImg1 = "/img/recipes/France_snacks/France_snacks_1.jpg";
        String bigImg2 = "/img/recipes/France_snacks/France_snacks_2.jpg";
        String bigImg3 = "/img/recipes/France_snacks/France_snacks_3.jpg";
        String bigImg4 = "/img/recipes/France_snacks/France_snacks_4.jpg";
        String bigImg5 = "/img/recipes/France_first/France_first_1.jpg";
        String bigImg6 = "/img/recipes/France_first/France_first_2.jpg";
        String bigImg7 = "/img/recipes/France_first/France_first_3.jpg";
        String bigImg8 = "/img/recipes/France_first/France_first_4.jpg";
        String bigImg9 = "/img/recipes/France_second/France_second_1.jpg";
        String bigImg10 = "/img/recipes/France_second/France_second_2.jpg";
        String bigImg11 = "/img/recipes/France_second/France_second_3.jpg";
        String bigImg12 = "/img/recipes/France_second/France_second_4.jpg";
        String bigImg13 = "/img/recipes/France_dessert/France_dessert_1.jpg";
        String bigImg14 = "/img/recipes/France_dessert/France_dessert_2.jpg";
        String bigImg15 = "/img/recipes/France_dessert/France_dessert_3.jpg";
        String bigImg16 = "/img/recipes/France_dessert/France_dessert_4.jpg";
        String bigImg17 = "/img/recipes/France_drink/France_drink_1.jpg";
        String bigImg18 = "/img/recipes/France_drink/France_drink_2.jpg";
        String bigImg19 = "/img/recipes/France_drink/France_drink_3.jpg";
        String bigImg20 = "/img/recipes/France_drink/France_drink_4.jpg";


        /**
         * {@code bigImgList} add big images in the list
         */
        bigImgList = new ArrayList<String>(Arrays.asList(bigImg1, bigImg2, bigImg3, bigImg4, bigImg5, bigImg6, bigImg7, bigImg8, bigImg9, bigImg10, bigImg11, bigImg12, bigImg13, bigImg14, bigImg15, bigImg16, bigImg17, bigImg18, bigImg19, bigImg20));


    }


    /**
     * {@method addSmallImg()}
     * creates for adding small image field for creation in recipe entity. This
     * method inicialize variables for recipes and add it in smallImgList
     */

    //TODO
    public void addSmallImg() {
        /**
         * {@code smallImg1..smallImg20} describes small images for our DB. This images adding into our cuisines
         */
        String smallImg1 = "/img/recipes/France_snacks/France_snacks_1.jpg";
        String smallImg2 = "/img/recipes/France_snacks/France_snacks_2.jpg";
        String smallImg3 = "/img/recipes/France_snacks/France_snacks_3.jpg";
        String smallImg4 = "/img/recipes/France_snacks/France_snacks_4.jpg";
        String smallImg5 = "/img/recipes/France_first/France_first_1.jpg";
        String smallImg6 = "/img/recipes/France_first/France_first_2.jpg";
        String smallImg7 = "/img/recipes/France_first/France_first_3.jpg";
        String smallImg8 = "/img/recipes/France_first/France_first_4.jpg";
        String smallImg9 = "/img/recipes/France_second/France_second_1.jpg";
        String smallImg10 = "/img/recipes/France_second/France_second_2.jpg";
        String smallImg11 = "/img/recipes/France_second/France_second_3.jpg";
        String smallImg12 = "/img/recipes/France_second/France_second_4.jpg";
        String smallImg13 = "/img/recipes/France_dessert/France_dessert_1.jpg";
        String smallImg14 = "/img/recipes/France_dessert/France_dessert_2.jpg";
        String smallImg15 = "/img/recipes/France_dessert/France_dessert_3.jpg";
        String smallImg16 = "/img/recipes/France_dessert/France_dessert_4.jpg";
        String smallImg17 = "/img/recipes/France_drink/France_drink_1.jpg";
        String smallImg18 = "/img/recipes/France_drink/France_drink_2.jpg";
        String smallImg19 = "/img/recipes/France_drink/France_drink_3.jpg";
        String smallImg20 = "/img/recipes/France_drink/France_drink_4.jpg";


        /**
         * {@code smallImgList} add  small images for recipes in the list
         */


        smallImgList = new ArrayList<String>(Arrays.asList(smallImg1, smallImg2, smallImg3, smallImg4, smallImg5, smallImg6, smallImg7, smallImg8, smallImg9, smallImg10, smallImg11, smallImg12, smallImg13, smallImg14, smallImg15, smallImg16, smallImg17, smallImg18, smallImg19, smallImg20));


    }


    /**
     * {@method addDescription()}
     * creates for describe description of creation in recipe entity. This
     * method inicialize variables for recipes and add it in descriptionList
     */

    //TODO
    public void addDescription() {


        /**
         * {@code description1..description20} describes descriptions for our DB
         */
        String description1 = "Вкусные сырный палочки, идеально подходят как закуска к пиву, так же они хороши сами по себе и могут быть приготовлены всего за 20 минут.";
        String description2 = "Одно из самых распространённых блюд французской кухни.";
        String description3 = "Бульон, который используют в этом блюде,  во Франции называется  court bouillon.";
        String description4 = "Очень необычное, но вкусное блюдо!";
        String description5 = "Очень вкусное и интересное блюдо!";
        String description6 = "Вишисуаз — это традиционный парижский суп из порея, картошки и сливок, превращенный в пюре и поданный холодным с гарниром из рубленого зеленого лука и прочим, что нашлось в доме. Вишисуаз был придуман совсем не во французском городе Виши, а в Нью-Йорке, поваром «Ритц-Карлтона» в начале прошлого века. Повар взял классический парижский суп из порея, который едят горячим, превратил его в пюре и подал ледяным, снабдив названием, отсылающим к известному французскому курорту.";
        String description7 = "Квинтэссенция французского подхода к приготовлению еды. Если около часа со знанием пытать огнем, вином и сливочным маслом самый банальный продукт, из него обязательно получится в финале нечто удивительное.";
        String description8 = "Очень вкусное и полезное блюдо!";
        String description9 = "Откройте банку фасоли или бобов и приготовьте творческое, быстрое и простое блюдо по этому рецепту — Рагу Тулуз.";
        String description10 = "Подавайте с вареным картофелем.";
        String description11 = "Это блюдо будет украшением любого стола!";
        String description12 = "Для этого рецепта надо использовать очень хорошую говяжью вырезку. Подавайте мясо с овощами.";
        String description13 = "Обязательно попробуйте этот несложный рецепт творожного десерта, который не требует выпекания. Он хорош для романтического ужина и похож на чизкейк. Количество ингредиентов рассчитано на две порции.";
        String description14 = "Охлажденный клубничный мусс, политый клубничным пюре и украшенный ягодами с мятой — отличный десерт, который безумно нравится детям. Клубнику в этом рецепте вы можете заменить на другие ягоды.";
        String description15 = "Крем-карамель — самый популярный в мире десерт, состоящий из яиц, молока и сахара. Десерт покрывается карамелью. Еще одним достоинством этого рецепта является то, что он очень быстр в приготовлении.";
        String description16 = "Мороженое с персиками и малиновым соусом — необычное и очень вкусное сочетание. Красиво оформленный десерт по этому рецепту с использованием консервированных персиков и мороженого готовится очень быстро, малиновый соус придает ему пикантности. Персики по желанию можно порезать более мелко, так их удобнее будет есть, но гораздо эффектнее они смотрятся в виде долек или половинок.";
        String description17 = "Этот напиток можно приготовить в 2-х вариантах. Алкогольном и безалкогольном.";
        String description18 = "Своим рождением томатно-водочный коктейль обязан Фернанду Петио, бармену, работавшему в парижском баре «Нью-Йорк» в начале прошлого века. В 1920-х годах в «репертуаре» Петио и появился этот странный, по парижским меркам, напиток — смесь равных частей водки и томатного сока. Нужно сказать, изобретение не было оценено французами по достоинству. Звездный час для коктейля Петио настал уже в Америке, в нью-йоркском баре «Кинг Кол», куда в 1934 году перебрался сам Фернанд… Здесь, впрочем, и заканчиваются более-менее точные факты в истории «Кровавой Мэри», а дальше начинаются вариации, в которых сложно уловить, каковы же были истинные детали всей этой истории.";
        String description19 = "Для приготовления крюшона с шампанским использовать стеклянные, фарфоровые и неокисляющиеся металлические емкости. Разливать небольшим неокисляющимся половником или ложкой. Подавать охлажденным (не более +15 градусов). Можно добавить лед.";
        String description20 = "Традиционный согревающий напиток холодными вечерами!";


        /**
         * {@code descriptionList} add  descriptions of recipes in the list
         */


        descriptionList = new ArrayList<String>(Arrays.asList(description1, description2, description3, description4, description5, description6, description7, description8, description9, description10, description11, description12, description13, description14, description15, description16, description17, description18, description19, description20));


    }


    /**
     * {@method addTitle()}
     * creates for describe title of creation in recipe entity. This
     * method inicialize variables for recipes and add it in titleList
     */
    //TODO
    public void addTitle() {


        /**
         * {@code title1..title20} describes titles for our DB
         */
        String title1 = "Сырные палочки из пармезана";
        String title2 = "Классический грибной жульен";
        String title3 = "Шампиньоны по-гречески";
        String title4 = "Шампиньоны по-гречески";
        String title5 = "Чесночный суп из Арля";
        String title6 = "Суп вишисуаз";
        String title7 = "Луковый суп";
        String title8 = "Овощной бульон";
        String title9 = "Рагу Тулуз";
        String title10 = "Рыба с овощами по-провански";
        String title11 = "Тушеная говядина с красным вином и цедрой апельсина";
        String title12 = "Шатобриан в соусе из красного вина";
        String title13 = "Творожный десерт";
        String title14 = "Клубничный мусс";
        String title15 = "Крем-карамель";
        String title16 = "Мороженое с персиками";
        String title17 = "Арбузное шорле с лимоном и медом";
        String title18 = "Кровавая Мэри";
        String title19 = "Апельсиновый крюшон с шампанским";
        String title20 = "Апельсиновый глинтвейн";


        /**
         * {@code titleList} add titles of recipes in the list
         */


        titleList = new ArrayList<String>(Arrays.asList(title1, title2, title3, title4, title5, title6, title7, title8, title9, title10, title11, title12, title13, title14, title15, title16, title17, title18, title19, title20));


    }


    /**
     * {@method addTime()}
     * creates for describe time of creation in recipe entity. This
     * method inicialize variables for recipes and add it in timeList
     */

    //TODO
    public void addTime() {


        /**
         * {@code time1..time20} describes times for our DB
         */
        Integer time1 = 25;
        Integer time2 = 40;
        Integer time3 = 70;
        Integer time4 = 150;
        Integer time5 = 110;
        Integer time6 = 40;
        Integer time7 = 45;
        Integer time8 = 20;
        Integer time9 = 35;
        Integer time10 = 60;
        Integer time11 = 210;
        Integer time12 = 30;
        Integer time13 = 15;
        Integer time14 = 30;
        Integer time15 = 70;
        Integer time16 = 15;
        Integer time17 = 10;
        Integer time18 = 6;
        Integer time19 = 90;
        Integer time20 = 20;


        /**
         * {@code timeList} add values of time in the list
         */


        timeList = new ArrayList<Integer>(Arrays.asList(time1, time2, time3, time4, time5, time6, time7, time8, time9, time10, time11, time12, time13, time14, time15, time16, time17, time18, time19, time20));


    }


    /**
     * {@method addRecipes()}
     * creates for adding information into our DB. It works for adding RecipeTitle, RecipeDescription,
     * Category, Cuisines, Time for recipe, Big and Small Image for recipe
     */

    //TODO
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
            recipeList.add(new Recipe(titleList.get(i), descriptionList.get(i), cuisineList.get(CUISINE_NUMBER), categoriesList.get(0), bigImgList.get(i), smallImgList.get(i), timeList.get(i)));
        }


        for (; i < (2 * 2 * 2); i++) {
            recipeList.add(new Recipe(titleList.get(i), descriptionList.get(i), cuisineList.get(CUISINE_NUMBER), categoriesList.get(1), bigImgList.get(i), smallImgList.get(i), timeList.get(i)));
        }


        for (; i < (2 * 2 * 2 + 2 * 2); i++) {
            recipeList.add(new Recipe(titleList.get(i), descriptionList.get(i), cuisineList.get(CUISINE_NUMBER), categoriesList.get(2), bigImgList.get(i), smallImgList.get(i), timeList.get(i)));
        }


        for (; i < (2 * 2 * 2 * 2); i++) {
            recipeList.add(new Recipe(titleList.get(i), descriptionList.get(i), cuisineList.get(CUISINE_NUMBER), categoriesList.get(2 + 1), bigImgList.get(i), smallImgList.get(i), timeList.get(i)));
        }
        for (; i < (2 * 2 * 2 * 2 + 2 * 2); i++) {
            recipeList.add(new Recipe(titleList.get(i), descriptionList.get(i), cuisineList.get(CUISINE_NUMBER), categoriesList.get(2 + 2), bigImgList.get(i), smallImgList.get(i), timeList.get(i)));
        }
    }


    /**
     * {@method addIngridients()}
     * creates Ingredient entities and links they to the Recipes.
     * This method inicialize Ingredient entity, link it to the recipe and add Ingredient entities,
     * that belong to one recipe, in separate List.
     */

    //TODO
    public void addMeasure() {
        Measure m1 = new Measure("г");
        Measure m2 = new Measure("мл");
        Measure m3 = new Measure("шт");
         listMeasure = new ArrayList<Measure>(Arrays.asList(m1,m2,m3));
        for (Measure measure:listMeasure){
             measureService.addMeasure(measure);  }

    }
    public void addMeasureBucket() {
        MeasuresBucket mb_a1 =new MeasuresBucket(listMeasure.get(0),listOfIngridientsLists.get(0).get(0),1);
        MeasuresBucket mb_a2 =new MeasuresBucket(listMeasure.get(0),listOfIngridientsLists.get(0).get(1),1);
        
        List<MeasuresBucket> list0 = new ArrayList<MeasuresBucket>(Arrays.asList(mb_a1, mb_a2));
        
        
        MeasuresBucket mb_b1 =new MeasuresBucket(listMeasure.get(0),listOfIngridientsLists.get(1).get(0),1);
        MeasuresBucket mb_b2 =new MeasuresBucket(listMeasure.get(2),listOfIngridientsLists.get(1).get(1),50);
        MeasuresBucket mb_b3 =new MeasuresBucket(listMeasure.get(0),listOfIngridientsLists.get(1).get(2),1);
        MeasuresBucket mb_b4 =new MeasuresBucket(listMeasure.get(0),listOfIngridientsLists.get(1).get(3),1);
        MeasuresBucket mb_b5 =new MeasuresBucket(listMeasure.get(1),listOfIngridientsLists.get(1).get(4),1);
        MeasuresBucket mb_b6 =new MeasuresBucket(listMeasure.get(0),listOfIngridientsLists.get(1).get(5),1);
        MeasuresBucket mb_b7 =new MeasuresBucket(listMeasure.get(0),listOfIngridientsLists.get(1).get(6),1);
        MeasuresBucket mb_b8 =new MeasuresBucket(listMeasure.get(0),listOfIngridientsLists.get(1).get(7),1);

        List<MeasuresBucket> list1 = new ArrayList<MeasuresBucket>(Arrays.asList(mb_b1, mb_b2,mb_b3, mb_b4,mb_b5, mb_b6,mb_b7, mb_b8));
        
        listOfMeasureBucketLists = new ArrayList<List<MeasuresBucket>>();
        listOfMeasureBucketLists.add(list0);
        listOfMeasureBucketLists.add(list1);
        
    }
    public void addIngredientBucket() {
        int k = 0;

        /**
         * {@code ingr_a1..ingr_a3} describes ingridients and their properties.
         * This ingridients are adding to the first recipe.
         */
        IngredientBucket ingr_a1 = new IngredientBucket(listOfIngridientsLists.get(k).get(0), 350,listOfMeasureBucketLists.get(k).get(0), recipeList.get(k));
        IngredientBucket ingr_a2 = new IngredientBucket(listOfIngridientsLists.get(k).get(1), 150,listOfMeasureBucketLists.get(k).get(1), recipeList.get(k));
        IngredientBucket ingr_a3 = new IngredientBucket(listOfIngridientsLists.get(1).get(2), 40,listOfMeasureBucketLists.get(1).get(2), recipeList.get(k));
        
        /**
         * {@code list0} unities ingridients that belong to one recipe.
         */

        List<IngredientBucket> list0 = new ArrayList<IngredientBucket>(Arrays.asList(ingr_a1, ingr_a2, ingr_a3));

        /**
         * {@code ingr_b1..ingr_b8} describes ingridients and their properties.
         * This ingridients are adding to the second recipe.
         */


        k++;
        IngredientBucket ingr_b1 = new IngredientBucket(listOfIngridientsLists.get(k).get(0), 100,listOfMeasureBucketLists.get(k).get(0) , recipeList.get(k));
        IngredientBucket ingr_b2 = new IngredientBucket(listOfIngridientsLists.get(k).get(1), 2,listOfMeasureBucketLists.get(k).get(1), recipeList.get(k));
        IngredientBucket ingr_b3 = new IngredientBucket(listOfIngridientsLists.get(k).get(2),  5,listOfMeasureBucketLists.get(k).get(2) , recipeList.get(k));
        IngredientBucket ingr_b4 = new IngredientBucket(listOfIngridientsLists.get(k).get(3), 40,listOfMeasureBucketLists.get(k).get(3), recipeList.get(k));
        IngredientBucket ingr_b5 = new IngredientBucket(listOfIngridientsLists.get(k).get(4), 50,listOfMeasureBucketLists.get(k).get(4) , recipeList.get(k));
        IngredientBucket ingr_b6 = new IngredientBucket(listOfIngridientsLists.get(k).get(5), 50,listOfMeasureBucketLists.get(k).get(5) , recipeList.get(k));
        IngredientBucket ingr_b7 = new IngredientBucket(listOfIngridientsLists.get(k).get(6), 5, listOfMeasureBucketLists.get(k).get(6), recipeList.get(k));
        IngredientBucket ingr_b8 = new IngredientBucket(listOfIngridientsLists.get(k).get(7),  5,listOfMeasureBucketLists.get(k).get(7) , recipeList.get(k));


        /**
         * {@code list1} unities ingridients that belong to one recipe.
         */


        List<IngredientBucket> list1 = new ArrayList<IngredientBucket>(Arrays.asList(ingr_b1, ingr_b2, ingr_b3, ingr_b4, ingr_b5, ingr_b6, ingr_b7, ingr_b8));

        listOfIngredientBucketLists = new ArrayList<List<IngredientBucket>>();
        listOfIngredientBucketLists.add(list0);
        listOfIngredientBucketLists.add(list1);

    }
    public void addIngredients() {


        /**
         * {@code k} uses as a array index of current recipe.
         */


        int k = 0;


        /**
         * {@code ingr_a1..ingr_a3} describes ingridients and their properties.
         * This ingridients are adding to the first recipe.
         */
        Ingredient ingr_a1 = new Ingredient("тесто",230*3);
        Ingredient ingr_a2 = new Ingredient("сыр пармезан", 330);

        /**
         * {@code list0} unities ingridients that belong to one recipe.
         */


        List<Ingredient> list0 = new ArrayList<Ingredient>(Arrays.asList(ingr_a1, ingr_a2));


        /**
         * {@code ingr_b1..ingr_b8} describes ingridients and their properties.
         * This ingridients are adding to the second recipe.
         */


        k++;
        Ingredient ingr_b1 = new Ingredient("шампиньоны", 25*1);
        Ingredient ingr_b2 = new Ingredient("лук репчатый",37*2);
        Ingredient ingr_b3 = new Ingredient("мука пшеничная", 342);
        Ingredient ingr_b4 = new Ingredient("масло сливочное", 784);
        Ingredient ingr_b5 = new Ingredient("сливки",120);
        Ingredient ingr_b6 = new Ingredient("сыр твердый", 230);
		Ingredient ingr_b7 = new Ingredient("соль",0);
		Ingredient ingr_b8 = new Ingredient("перец черный", 251);


        /**
         * {@code list1} unities ingridients that belong to one recipe.
         */


        List<Ingredient> list1 = new ArrayList<Ingredient>(Arrays.asList(ingr_b1, ingr_b2, ingr_b3, ingr_b4, ingr_b5, ingr_b6, ingr_b7, ingr_b8));


        /**
         * {@code listOfIngridientsLists} unities all the lists of ingridients {@code list0...list19}
         * with using add() method.
         */


        listOfIngridientsLists = new ArrayList<List<Ingredient>>();
        listOfIngridientsLists.add(list0);
        listOfIngridientsLists.add(list1);


    }


    /**
     * {@method addSteps()}
     * creates Step entities and links they to the Recipes.
     * This method inicialize tep entity, link it to the recipe and add Step entities,
     * that belong to one recipe, in separate List.
     */

    //TODO
    public void addSteps() {


        /**
         * {@code k} uses as a array index of current recipe.
         */


        int k = 0;


        /**
         * {@code step_a1..step_a4} describes steps and their properties.
         * This steps are adding to the first recipe.
         */


        Step step_a1 = new Step(1, "Разогрейте духовку до 200−220 градусов. Раскатать слоеное тесто на поверхности, посыпанной мукой, посыпьте сверху на тесто три горсти тертого пармезана, затем сверните пополам пласт теста.", recipeList.get(k));
			step_a1.setImage("http://img15.imageshack.us/img15/9802/stepav.jpg");
        Step step_a2 = new Step(2, "На слегка посыпанной мукой поверхности, раскатать до толщины 10 рублевой монеты.", recipeList.get(k));
			step_a2.setImage("http://img15.imageshack.us/img15/9802/stepav.jpg");
        Step step_a3 = new Step(3, "Порезать на полоски 1 см, затем скрутить полоски 3−4 раза. Положить полоски на бумагу для выпечки, посыпать оставшимся сыром и запекать в течение 12 минут до золотистого цвета.", recipeList.get(k));
			step_a3.setImage("http://img15.imageshack.us/img15/9802/stepav.jpg");
        Step step_a4 = new Step(4, "Дать остыть, а затем переложить в герметичный контейнер, где они могут храниться в течение 2 дней.", recipeList.get(k));
			step_a4.setImage("http://img15.imageshack.us/img15/9802/stepav.jpg");


        /**
         * {@code list0} unities steps that belong to one recipe.
         */


        List<Step> list0 = new ArrayList<Step>(Arrays.asList(step_a1, step_a2, step_a3, step_a4));


        /**
         * {@code step_b1..step_b2} describes steps and their properties.
         * This steps are adding to the second recipe.
         */


        k++;
        Step step_b1 = new Step(1, "Измельчить лук и грибы, обжарить с солью и перцем на сливочном масле. Добавить муку и перемешать.", recipeList.get(k));
			step_b1.setImage("http://img15.imageshack.us/img15/9802/stepav.jpg");
        Step step_b2 = new Step(2, "Разложить грибную смесь по формочкам, залить сливками, посыпать тертым сыром и запекать в духовке при 180 градусах 20–25 минут.", recipeList.get(k));
			step_b2.setImage("http://img15.imageshack.us/img15/9802/stepav.jpg");

        /**
         * {@code list1} unities steps that belong to one recipe.
         */


        List<Step> list1 = new ArrayList<Step>(Arrays.asList(step_b1, step_b2));


        /**
         * {@code step_c1..step_c6} describes steps and their properties.
         * This steps are adding to the third recipe.
         */


        /**
         * {@code listOfStepsLists} unities all the lists of steps {@code list0...list19}
         * with using add() method.
         */


        listOfStepsLists = new ArrayList<List<Step>>();
        listOfStepsLists.add(list0);
        listOfStepsLists.add(list1);


    }

    
    @RequestMapping(value = {"/fillFrance"}) //TODO
    public ModelAndView fillDb() {
        addRecipes();




        for (Recipe recipe1 : recipeList) {
            recipeService.addRecipe(recipe1);
        }


        addIngredients();


        /**
         * adding information in DB with a help of the ingridientService
         */


        for (List<Ingredient> listOfIngredient : listOfIngridientsLists) {
            for (Ingredient ingredient : listOfIngredient) {
                ingredientService.addIngredient(ingredient);
            }
        }

        addMeasure();
        
        addMeasureBucket();
        
        for (List<MeasuresBucket> listOfMeasuresBucket : listOfMeasureBucketLists){
             for ( MeasuresBucket measureBucket : listOfMeasuresBucket ){
                measureBucketService.addMeasuresBucket(measureBucket);
            }
        }

        addIngredientBucket();
        
         for (List<IngredientBucket> listOfIngredientBucket : listOfIngredientBucketLists){
             for (IngredientBucket ingredientBucket : listOfIngredientBucket) {
                 ingredientBucketService.addIngredientBucket(ingredientBucket);
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
