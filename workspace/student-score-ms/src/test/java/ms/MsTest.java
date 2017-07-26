package ms;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MsTest {
    private Constant constant = new Constant();

    @Test
    public void should_return_menu_string_when_process_run() throws Exception {
        //Given
        String menuString = this.constant.getMenuString();
        String input = null;
        //when
        MsTest.should_return_assertThat_when_input_test_data(input, menuString);
    }

    @Test
    public void should_return_add_student_info_when_input_1() throws Exception {
        //Given
        String addStudentPromptString = this.constant.getAddStudentPromptString();
        String input = "1";
        //when
        MsTest.should_return_assertThat_when_input_test_data(input, addStudentPromptString);

    }

    private static void should_return_assertThat_when_input_test_data(String input, String expectedData) throws Exception {
        ms.Ms ms = new ms.Ms();
        String actualData = ms.print_studnent_score_ms(input);
        assertThat(actualData, is(expectedData));
    }

}
