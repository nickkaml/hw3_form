import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestForms {

    @Test
    void fillFormTest() {
        Configuration.holdBrowserOpen = true;

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").val("Ivan");
        $("#lastName").val("Ivanov");
        $("#userEmail").val("ivan@mail.ru");

        //$(By.name("gender")).selectRadio("Male");
        $(byText("Male")).click();

        $("#userNumber").val("79991234567");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__day--001").click();


    }
}
