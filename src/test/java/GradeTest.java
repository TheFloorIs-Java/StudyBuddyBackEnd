import App.Model.Grade;
import App.Repository.GradeRepository;
import App.Service.GradeService;
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
public class GradeTest {
    @InjectMocks
    GradeService gradeServiceMock;
    @Mock
    GradeRepository gradeRepoMock;


    @Test
    public void findGradesByUserIdTest() {
        List<Grade> gradeSub = new ArrayList<Grade>();
        Mockito.when(gradeRepoMock.getGradesByUserId(Mockito.anyInt())).thenReturn(gradeSub);
        List<Grade> subTest = gradeServiceMock.getGradesByUserId(1);
        Assert.assertThat("result", subTest, is(sameInstance(gradeSub)));
        Mockito.verify(gradeRepoMock).getGradesByUserId(1);
    }
    @Test
    public void findSubjectByNameTest() {
        Grade gradeSub = new Grade();
        Mockito.when(gradeRepoMock.getGradesByUserIdAndSubjectId(Mockito.anyInt(),Mockito.anyInt())).thenReturn(gradeSub);
        Grade subTest = gradeServiceMock.getGradesByUserIdAndSubjectId(1,1);
        Assert.assertThat("result", subTest, is(sameInstance(gradeSub)));
        Mockito.verify(gradeRepoMock).getGradesByUserIdAndSubjectId(1,1);
    }
}
