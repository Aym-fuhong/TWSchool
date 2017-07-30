package managerScore;

import managerScore.controller.ManagerScore;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ManagerScoreTest {
    private ManagerScore ms = new ManagerScore();

    @Test
    public void should_return_menu_string_when_process_run() throws Exception {
        //Given
        String menuString = Constant.menuString;
        String input = null;
        //when
        this.should_return_assertThat_when_input_test_data(input, menuString);
    }

    @Test
    public void should_return_menu_string_when_menu_input_error() throws Exception {
        //Given
        String menuString = Constant.menuString;
        String input = "";
        //when
        this.should_return_assertThat_when_input_test_data(input, menuString);
    }

    @Test
    public void should_return_add_student_info_when_input_1() throws Exception {
        //Given
        String addStudentPromptString = Constant.addStudentBegining + Constant.addStudentFormat;
        ms.setCurrentStatus("1");
        String input = "1";
        //when
        this.should_return_assertThat_when_input_test_data(input, addStudentPromptString);
    }

    @Test
    public void should_return_add_student_info_when_input_error_at_status_1() throws Exception {
        //Given
        String errAddStudentPromptString = Constant.errString + Constant.addStudentFormat;
        ms.setCurrentStatus("1-*");
        String input = "t";
        //when
        this.should_return_assertThat_when_input_test_data(input, errAddStudentPromptString);
    }

    @Test
    public void should_return_add_studnent_info_when_input_info_at_stauts_1() throws Exception {
        //Given
        String errgetStudentIdPromptString = "学生小明的成绩被添加\n" + Constant.menuString;
        ms.setCurrentStatus("1-*");
        String input = "小明，1，数学：99，语文：88，英语：100，编程：99";
        //when
        this.should_return_assertThat_when_input_test_data(input, errgetStudentIdPromptString);
    }

    @Test
    public void should_return_get_student_id_when_input_2() throws Exception {
        //Given
        String getStudentIdPromptString = Constant.studentIdPrompt;
        ms.setCurrentStatus("2");
        String input = "2";
        //when
        this.should_return_assertThat_when_input_test_data(input, getStudentIdPromptString);
    }

    @Test
    public void should_return_get_student_id_when_input_error_at_status_2() throws Exception {
        //Given
        String errAddStudentPromptString = Constant.errString + Constant.studentIdPrompt;
        ms.setCurrentStatus("2-*");
        String input = "t";
        //when
        this.should_return_assertThat_when_input_test_data(input, errAddStudentPromptString);
    }

    @Test
    public void should_return_get_student_score_when_input_id_at_stauts_2() throws Exception {
        //Given
        String studentScoretString = Constant.studentScoreString + Constant.menuString;
        ms.setCurrentStatus("1-*");
        String input1 = "小明，1，数学：99，语文：88，英语：100，编程：99";
        ms.print_studnent_score_ms(input1);
        ms.setCurrentStatus("2-*");
        String input = "1，2";
        //when
        this.should_return_assertThat_when_input_test_data(input, studentScoretString);
    }

    @Test
    public void should_return_get_student_score_when_input_not_exist_id_at_stauts_2() throws Exception {
        //Given
        String studentScoretString = Constant.noStudentScoreString + Constant.menuString;
        ms.setCurrentStatus("2-*");
        String input = "5";
        //when
        this.should_return_assertThat_when_input_test_data(input, studentScoretString);
    }

    @After
    public void tearDown() throws Exception {
        ms.setCurrentStatus("");
    }

    private void should_return_assertThat_when_input_test_data(String input, String expectedData) throws Exception {
        String actualData = ms.print_studnent_score_ms(input);
        assertThat(actualData, is(expectedData));
    }

}
