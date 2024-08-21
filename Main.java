import org.openqa.selenium.By;

public class Main {
   // public static By firstName;
   public static  By firstName = (By.id("firstName"));
    public static  By lastName = (By.id("lastName"));
    public static  By email = (By.id("userEmail"));
    public static By femaleRadioButton = (By.cssSelector("label[for='gender-radio-2']"));
    public static By userNumber = (By.id("userNumber"));
    public static  By dateOfBirth = (By.id("dateOfBirthInput"));
    public static  By subjects = (By.id("subjectsInput"));
    public static By subjectsActive = By.cssSelector(".subjects-auto-complete__input");
    public static By picture = (By.id("uploadPicture"));
    public static By address = (By.id("currentAddress"));
    public static By state = (By.id("state"));
    public static By city = (By.id("city"));
    public static By submit = (By.id("submit"));
    public static By selectState = (By.id("react-select-3-option-2"));
    public static By selectCity = (By.id("react-select-4-option-1"));
    public static By modalContent = By.cssSelector("div.modal-content");
    public static By title = (By.id("example-modal-sizes-title-lg"));
}
