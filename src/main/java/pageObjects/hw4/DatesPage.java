package pageObjects.hw4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.LogFactory;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DatesPage {

    @FindBy(css = ".uui-slider")
    private SelenideElement sliderTrack;

    @FindBy(xpath = "//a[contains(@class, 'ui-slider-handle')][1]")
    private SelenideElement leftSlider;

    @FindBy(xpath = "//a[contains(@class, 'ui-slider-handle')][2]")
    private SelenideElement rightSlider;

    @FindBy(xpath = "//div[contains(@class, 'uui-slider')]/preceding-sibling::label")
    private SelenideElement slidersLabel;

    private RightPanel rightPanel;

    private List<String> clickLog = new ArrayList<>();
    private Deque<SelenideElement> sliderStack = new LinkedList<>();


    public DatesPage() {
        rightPanel = Selenide.page(RightPanel.class);
    }

    //methods
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

        String sliderInfo;
        if (slider.equals(leftSlider)) {
            sliderInfo = "(From)";
        } else {
            sliderInfo = "(To)";
        }
        addLog(slidersLabel.getText() + sliderInfo, destinationPercent);
    }

    private void addLog(Object element, Object value) {
        clickLog.add(LogFactory.createLog(element, value));
    }

    private int getCurrentPosPercent(SelenideElement slider) {
        return Integer.parseInt(slider.getAttribute("style")
                .replace("left: ", "")
                .replace("%;", ""));
    }

    //checks
    public void checkLogRowsDisplayed() {
        rightPanel.checkLogRowsDisplayed(clickLog);
    }

    public void checkLoggedNameAndStatusCorrect() {
        rightPanel.checkLoggedNameAndStatusCorrect(clickLog);
    }

}
