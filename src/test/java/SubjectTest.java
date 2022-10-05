import App.Model.Subjects;
import App.Repository.SubjectRepository;
import App.Service.SubjectService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class SubjectTest {
    @InjectMocks
    SubjectService subjectServiceMock;
    @Mock
    SubjectRepository mockSubjectRepo;


    @Test
    public void findSubjectByIdTest() {
        Subjects mathSub = new Subjects();
        Mockito.when(mockSubjectRepo.findBySubjectId(Mockito.anyInt())).thenReturn(mathSub);
        Subjects subTest = subjectServiceMock.getSubjectById(1);
        Assert.assertThat("result", subTest, is(sameInstance(mathSub)));
        Mockito.verify(mockSubjectRepo).findBySubjectId(1);
    }
    @Test
    public void findSubjectByNameTest() {
        Subjects mathSub = new Subjects();
        Mockito.when(mockSubjectRepo.findBySubjectName(Mockito.anyString())).thenReturn(mathSub);
        Subjects subTest = subjectServiceMock.getSubjectByName("Math");
        Assert.assertThat("result", subTest, is(sameInstance(mathSub)));
        Mockito.verify(mockSubjectRepo).findBySubjectName("Math");
    }
}