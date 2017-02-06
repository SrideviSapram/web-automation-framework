package com.blogspot.notes.automation.qa.pages;

import com.blogspot.notes.automation.qa.annotations.HTML;
import com.blogspot.notes.automation.qa.elements.Button;
import com.blogspot.notes.automation.qa.elements.CheckBox;
import com.blogspot.notes.automation.qa.elements.TextInput;
import com.blogspot.notes.automation.qa.interfaces.PageObjectsSupplier;
import com.blogspot.notes.automation.qa.wrappers.BasePage;
import ru.yandex.qatools.allure.annotations.Step;
import static com.blogspot.notes.automation.qa.elements.HTMLElement.SearchBy.*;

public class LoginPage extends BasePage implements PageObjectsSupplier {

	@HTML(searchBy = ID, value = "inputEmail")
    private TextInput inputEmailID;

    @HTML(searchBy = ID, value = "inputPassword")
    private TextInput inputPasswd;
    
    @HTML(searchBy = ID, value = "login")
    private Button buttonLogin;
    
	@HTML(searchBy = ID, value = "Email")
    private TextInput inputEmail;

    @HTML(searchBy = ID, value = "Passwd")
    private TextInput inputPassword;

    @HTML(searchBy = ID, value = "next")
    private Button buttonNext;

    @HTML(searchBy = ID, value = "signIn")
    private Button buttonSignIn;

    @HTML(searchBy = ID, value = "PersistentCookie")
    private CheckBox checkBoxStaySignedIn;

    public HomePage loginWith(final String email, final String password) {
        return setEmailId(email)
                .setPasswd(password)
                .logIn();
    }
    public HomePage loginWith(final String email, final String password, final boolean staySignedIn) {
        return setEmail(email)
                .clickNext()
                .setPassword(password)
                .staySignedIn(staySignedIn)
                .signIn();
    }
    
    
    @Step("Type inputEmailID = \"{0}\".")
    public LoginPage setEmailId(final String email) {
        inputEmailID.type(email);
        return this;
    }

    @Step("Type inputPasswd = \"{0}\".")
    public LoginPage setPasswd(final String password) {
        inputPasswd.type(password);
        return this;
    }
    
    @Step("Click \"Login\" button.")
    public HomePage logIn() {
        buttonLogin.click();
        return homePage();
    }
    
    @Step("Type email = \"{0}\".")
    public LoginPage setEmail(final String email) {
        inputEmail.type(email);
        return this;
    }

    @Step("Type password = \"{0}\".")
    public LoginPage setPassword(final String password) {
        inputPassword.type(password);
        return this;
    }

    @Step("Set \"Stay signed in\" option = {0}.")
    public LoginPage staySignedIn(final boolean staySignedIn) {
        if (staySignedIn) {
            checkBoxStaySignedIn.check();
        } else {
            checkBoxStaySignedIn.unCheck();
        }
        return this;
    }

    @Step("Click \"Next\" button.")
    public LoginPage clickNext() {
        buttonNext.click();
        return this;
    }

    @Step("Click \"Sign in\" button.")
    public HomePage signIn() {
        buttonSignIn.click();
        return homePage();
    }
}
