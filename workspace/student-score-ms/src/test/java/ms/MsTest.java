package ms;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MsTest {
    @Test
    public void should_return_menu_string_when_process_run() throws Exception {
        //Given
        Constant constant = new Constant();
        String menuString = constant.getMenuString();
        //when
        MsTest.should_return_assertThat_when_input_test_data(menuString);
    }


    private static void should_return_assertThat_when_input_test_data(String expectedData) throws Exception {
        ms.Ms ms = new ms.Ms();
        String actualData = ms.print_studnent_score_ms();
        assertThat(actualData, is(expectedData));
    }

}
