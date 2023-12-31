package consonants.flex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests for the RetrieveFormUseCase.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class RetrieveFormUseCaseTests {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Tests if Claim #1002 has its appropriate Form data.
     * We decided to test this by arbitrarily choosing a String that should be checked from the output on the page.
     */
    @Test
    void testFormDataExists() throws Exception {
        String subdirectory = "/retrieve-info/1002";
        String stringToCheck = "\"formId\":2,\"clientId\":10002,\"claimId\":1002,";

        this.mockMvc.perform(get(subdirectory)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(stringToCheck)));
    }

    /**
     * Tests that no information is correctly returned when attempting to access the Form data of a
     * Claim that *does not* exist in the system. In this example, Claim #222 do not exist in our database.
     */
    @Test
    void testClaimDoNotExist() throws Exception {
        String subdirectory = "/retrieve-info/222";
        String stringToCheck = "";

        this.mockMvc.perform(get(subdirectory)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(stringToCheck)));
    }
}