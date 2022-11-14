import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestForms extends Base {

    @Test
    void StudentForm () {

        String firstName = "Ivan";
        String lastName = "Ivanov";

        open("/automation-practice-form");

        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val("ivan@mail.ru");

        //$(By.name("gender")).selectRadio("Male");
        $(byText("Male")).click();

        $("#userNumber").val("79991234567");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__day--001").click();

        $("#subjectsInput").setValue("English");
        $(".subjects-auto-complete__menu").$(byText("English")).click();











    }
}
