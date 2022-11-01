import App.Model.Homework;
import App.Repository.HomeworkRepository;
import App.Service.HomeworkService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class HomeworkTest {
    @InjectMocks
    HomeworkService mockHomeworkService;
    @Mock
    HomeworkRepository mockHomeworkRepository;

    /**
     * Test find homework by id method
     */
    @Test
    public void findHomeworkByHwIdTest() {
        Homework homeSub = new Homework();
        Mockito.when(mockHomeworkRepository.findByHwId(Mockito.anyInt())).thenReturn(homeSub);
        Homework homeworkTest = mockHomeworkService.getHwById(1);
        Assert.assertThat("result", homeworkTest, is(sameInstance(homeSub)));
        Mockito.verify(mockHomeworkRepository).findByHwId(1);
    }

    /**
     * Test find homework by subject id and user id method
     */
    @Test
    public void findHomeworkBySubjectIdAndUserIdTest() {
        List<Homework> homeSubsList = new ArrayList<Homework>();
        Mockito.when(mockHomeworkRepository.findByUserIdAndSubjectId(Mockito.anyInt(),Mockito.anyInt())).thenReturn(homeSubsList);
        List<Homework> homeworkTest = mockHomeworkService.getHomeworkByUserAndSubjectId(1,1);
        Assert.assertThat("result", homeworkTest, is(sameInstance(homeSubsList)));
        Mockito.verify(mockHomeworkRepository).findByUserIdAndSubjectId(1,1);
    }
}

