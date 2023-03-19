package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CardReplenishmentPage {

    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement amount = $("[data-test-id=amount] .input__control");
    private SelenideElement transferFrom = $("[data-test-id=from] .input__control");
    private SelenideElement topUpButton = $("[data-test-id=action-transfer] .button__text");
    private SelenideElement cancelButton = $("[data-test-id=action-cancel] .button__text");
    public CardReplenishmentPage() {
        heading.shouldBe(visible);
    }

    public DashboardPage transferFromCardToCard(String transferAmount, DataHelper.Card from ) {
        amount.click();
        amount.setValue(transferAmount);
        transferFrom.click();
        transferFrom.setValue(from.getNumber());
        topUpButton.click();
        return new DashboardPage();
    }

    public void cancelTransaction() {
        cancelButton.click();
        new DashboardPage();
    }

}
