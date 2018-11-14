package pageObjects.hw6;

import com.codeborne.selenide.SelenideElement;
import dto.LogItem;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pageObjects.hw6.center.RightSection;

import java.util.Deque;
import java.util.LinkedList;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Dates {

    @FindBy(css = ".uui-slider")
    private SelenideElement sliderTrack;

    @FindBy(xpath = "//a[contains(@class, 'ui-slider-handle')][1]")
    private SelenideElement leftSlider;

    @FindBy(xpath = "//a[contains(@class, 'ui-slider-handle')][2]")
    private SelenideElement rightSlider;

    @FindBy(xpath = "//div[contains(@class, 'uui-slider')]/preceding-sibling::label")
    private SelenideElement slidersLabel;

    private RightSection rightSection;

    private Deque<SelenideElement> sliderStack = new LinkedList<>();


    public Dates() {
        page(this);
        rightSection = page(RightSection.class);
    }

    //methods
    @Step
    public void setSliders(int from, int to) {
        if (from == to) {
            if (sliderStack.isEmpty()) {
                moveSlider(leftSlider, from);
                sliderStack.push(leftSlider);
                moveSlider(rightSlider, to);
                sliderStack.push(rightSlider);
            } else {
                if (sliderStack.poll().equals(leftSlider)) {
                    moveSlider(leftSlider, from);
                    moveSlider(sliderStack.poll(), to);
                    sliderStack.push(leftSlider);
                    sliderStack.push(rightSlider);
                } else {
                    moveSlider(rightSlider, to);
                    moveSlider(sliderStack.poll(), from);
                    sliderStack.push(rightSlider);
                    sliderStack.push(leftSlider);
                }
            }
        } else {
            if (sliderStack.isEmpty()) {
                moveSlider(leftSlider, from);
                moveSlider(rightSlider, to);
            } else {
                if (sliderStack.poll().equals(leftSlider)) {
                    moveSlider(leftSlider, from);
                    moveSlider(sliderStack.poll(), to);
                } else {
                    moveSlider(rightSlider, to);
                    moveSlider(sliderStack.poll(), from);
                }
            }
        }
    }

    private void moveSlider(SelenideElement slider, int destinationPercent) {
        double step = sliderTrack.getSize().getWidth() / 100.0;

        double sliderCenterPx = Double.parseDouble(slider.getCssValue("left")
                .replace("px", ""));
        double currPos = sliderCenterPx / step;
        double xOffset = (destinationPercent - currPos) * step - 1;
        int xOffsetInt;
        if (xOffset < 0) {
            xOffsetInt = (int) Math.floor(xOffset);
        } else {
            xOffsetInt = (int) Math.ceil(xOffset);
        }

        Actions action = new Actions(getWebDriver());
        action.dragAndDropBy(slider, xOffsetInt, 0).build().perform();
        rightSection.addLog();
    }

    //checks
    public void checkSlidersLoggedNameAndStatusCorrect(int from, int to) {
        rightSection.checkLoggedNameAndStatusCorrect(new LogItem("Range 2(From)", String.valueOf(from)), new LogItem("Range 2(To)", String.valueOf(to)));

    }
}
