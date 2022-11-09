package lesson29.po_selenide;

import com.codeborne.selenide.CollectionCondition;

public class SearchPageLogic_cw extends SearchPageElements{

    public SearchPageLogic_cw checkProductQuantity(int size){
        tittles.shouldHave(CollectionCondition.size(size));
        return this;
    }
}
