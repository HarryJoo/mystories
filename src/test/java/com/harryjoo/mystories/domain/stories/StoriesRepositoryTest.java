package com.harryjoo.mystories.domain.stories;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoriesRepositoryTest {

    @Autowired
    StoriesRepository storiesRepository;

    @After
    public void cleanup() {
        storiesRepository.deleteAll();
    }

    @Test
    public void load_stories() {
        //given
        String title = "테스트 스토리";
        String content = "테스트 본문";

        storiesRepository.save(Stories.builder()
                                .title(title)
                                .content(content)
                                .writer("hstories85@gmail.com")
                                .build());

        //when
        List<Stories> storiesList = storiesRepository.findAll();

        //then
        Stories stories = storiesList.get(0);
        assertThat(stories.getTitle()).isEqualTo(title);
        assertThat(stories.getContent()).isEqualTo(content);
    }
}
