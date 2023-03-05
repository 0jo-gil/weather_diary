package com.example.weather.repository;

import com.example.weather.domain.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional // 테스트 코드에서 transactional을 사용하면 모두 롤백 처리를 한다.
public class JpaMemoRepositoryTest {
    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest(){
        //given
        Memo newMemo = new Memo(10, "this is jpa memo!");
        //when
        jpaMemoRepository.save(newMemo);

        //then
        List<Memo> memoList = jpaMemoRepository.findAll();

        assertTrue(memoList.size() > 0);
    }

    @Test
    void findById(){
        //given
        Memo newMemo = new Memo(11, "jpa");

        // when
        Memo memo = jpaMemoRepository.save(newMemo);
        //then
        Optional<Memo> result = jpaMemoRepository.findById(memo.getId());

        assertEquals(result.get().getText(), "jpa");
    }
}
//https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}

//
