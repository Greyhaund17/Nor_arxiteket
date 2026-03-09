package base;

import org.testng.annotations.Test;
import pages.AdminPage;

public class AdminTest extends BaseTest {
    @Test(groups = {"smoke"})
    public void testAdminSearch() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.searchInAdmin("Admin");
    }
}
