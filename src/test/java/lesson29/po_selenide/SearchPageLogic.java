package lesson29.po_selenide;

import com.codeborne.selenide.CollectionCondition;

public class SearchPageLogic extends SearchPageElements{

    public SearchPageLogic checkProductQuantity(int size){
        tittles.shouldHave(CollectionCondition.size(size));
        return this;
    }
}
