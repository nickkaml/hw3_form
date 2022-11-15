import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestForms {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        //Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void studentForm () {

        String firstName = "Иван";
        String lastName = "Иванов";
        String email = "ivan@mail.ru";
        String phoneNumber = "1234567890";
        String address = "улица Ленина, 35, кв. 1";


        open("/automation-practice-form");
        //executeJavaScript("$('#adplus-anchor').remove()");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");



        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(email);

        $(byText("Male")).click();

        $("#userNumber").val(phoneNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month-select").selectOption("January");
        $(byText("1")).click();

        $("#subjectsInput").val("English").pressEnter();
        $("#subjectsInput").val("Maths").pressEnter();

        $(byText("Sports")).click();
        $(byText("Music")).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/picture.jpeg"));

        $("#currentAddress").val(address);
        $("#state").click();
        $("#state").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#city").$(byText("Jaiselmer")).click();
        $("#submit").click();


        $(".table-responsive").shouldBe(Condition.visible);
        $(".table-responsive").shouldHave(
                text(firstName),
                text(lastName),
                text(email),
                text("Male"),
                text(phoneNumber),
                text("01 January,2000"),
                text("English, Maths"),
                text("Sports, Music"),
                text("picture.jpeg"),
                text(address),
                text("Rajasthan Jaiselmer")
        );
    }

    @AfterAll
    static void afterAll() {
        Configuration.holdBrowserOpen = false;
    }
}
