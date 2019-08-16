package com.example.application.vo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.json.ObjectContent;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@JsonTest
public class MemoViewTests {

    @Autowired
    private JacksonTester<MemoView> json;

    @Test
    public void test_serialize() throws IOException {
        String expected = "{\"title\":\"memo\",\"description\":\"memo description\",\"completed\":false}";

        MemoView memoView = MemoView.builder().title("memo").description("memo description").done(false).build();
        JsonContent<MemoView> actual = json.write(memoView);
        actual.assertThat().isEqualTo(expected);

        actual.assertThat().hasJsonPathStringValue("$.title");
        actual.assertThat().extractingJsonPathStringValue("$.title").isEqualTo("memo");
        actual.assertThat().hasJsonPathStringValue("$.description");
        actual.assertThat().extractingJsonPathStringValue("$.description").isEqualTo("memo description");
        actual.assertThat().hasJsonPathBooleanValue("$.completed");
        actual.assertThat().extractingJsonPathBooleanValue("$.completed").isEqualTo(false);
    }

    @Test
    public void test_deserialize() throws IOException {
        MemoView expected = MemoView.builder().title("memo").description("memo description").done(false).build();

        String content = "{\"title\":\"memo\",\"description\":\"memo description\",\"completed\":false}";
        ObjectContent<MemoView> actual = json.parse(content);
        actual.assertThat().isEqualTo(expected);
    }

}