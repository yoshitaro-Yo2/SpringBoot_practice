package jp.co.IssueTrackingSystem.PracticeForWebApp.domain.issue;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// Mybatis の場合、Bean登録に @Repository は不要 @Mapper で登録される
@Mapper
public interface IssueRepository {

    @Select("select * from issues")
    List<IssueEntity> findAllIssues();
}
