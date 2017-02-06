package com.blogspot.notes.automation.qa.pages;

import com.blogspot.notes.automation.qa.annotations.HTML;
import com.blogspot.notes.automation.qa.annotations.Image;
import com.blogspot.notes.automation.qa.elements.Button;
import com.blogspot.notes.automation.qa.elements.Hyperlink;
import com.blogspot.notes.automation.qa.elements.ImageElement;
import com.blogspot.notes.automation.qa.elements.Label;
import com.blogspot.notes.automation.qa.elements.TextInput;
import com.blogspot.notes.automation.qa.wrappers.BasePage;
import ru.yandex.qatools.allure.annotations.Step;
import static com.blogspot.notes.automation.qa.elements.HTMLElement.SearchBy.*;
import static com.blogspot.notes.automation.qa.interfaces.GenericPage.*;

public class HomePage extends BasePage {

    @HTML(searchBy = CSS_SELECTOR, value = ".gb_8a.gb_r")
    private Label labelUsername;

    @Image(name = "inputFilePath.png", similarity = 0.8f)
    private ImageElement inputFilePath;

    @Image(name = "buttonUpload.png", similarity = 0.8f)
    private ImageElement buttonUpload;

    @HTML(searchBy = XPATH, value = "//li[@id='Secondary_Navbar-Account' and @menuitemname='Account']")
    private Hyperlink hyperlinkDropdownUsersetting;
    
    @HTML(searchBy = XPATH, value = "//li[@id='Secondary_Navbar-Account-Edit_Account_Details']")
    private Hyperlink hyperlinkEditaccount;
    
    @HTML(searchBy = XPATH, value = "//a[@id='Primary_Sidebar-My_Account-Contacts_Sub-Accounts' and @menuitemname='Contacts/Sub-Accounts']")
    private Hyperlink hyperlinkContacts;
    
    @HTML(searchBy = XPATH, value = "//input[@id='inputFirstName']")
    private TextInput inputFirstName;
    
    @HTML(searchBy = XPATH, value = "//input[@class='btn btn-primary']")
    private Button buttonSaveChanges;
    
    
    @Step("Upload a file \"{0}\".")
    public HomePage uploadFile(final String path) {
        inputFilePath.type(path);
        buttonUpload.click();
        return this;
    }

    public String getUsername() {
        return labelUsername.getText();
    }
    
    @Step("Dropdown click \"{0}\".")
    public HomePage clickDropdownUsersettings() {
    	hyperlinkDropdownUsersetting.click();
        return this;
    }
    
    @Step("Dropdown option select \"{0}\".")
    public HomePage clickEditAccountDetails() {
    	hyperlinkEditaccount.click();
        return this;
    }
    
    @Step("Sidebar click \"{0}\".")
    public HomePage clickcontactsSubAccounts() {
    	hyperlinkContacts.click();
        return this;
    }
    
    @Step("Type Firstname = \"{0}\".")
    public HomePage setFirstName(final String firstname) {
        inputFirstName.type(firstname);
        return this;
    }
    
    @Step("Click \"Save Changes\" button.")
    public HomePage clicksaveChanges() {
        buttonSaveChanges.click();
        return this;
    }
    
    @Step("Click \"Save Changes\" button.")
    public HomePage refreshWebPage() {
        refreshPage();
        acceptAlert();
        return this;
    }
    
    
    public String getFirstName() {
        return inputFirstName.getText();
    }

}
