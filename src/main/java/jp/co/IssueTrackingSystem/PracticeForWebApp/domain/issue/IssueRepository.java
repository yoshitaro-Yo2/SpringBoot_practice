package jp.co.IssueTrackingSystem.PracticeForWebApp.domain.issue;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// Mybatis の場合、Bean登録に @Repository は不要 @Mapper で登録される
@Mapper
public interface IssueRepository {

    @Select("select * from issues")
    List<IssueEntity> findAllIssues();

    // Mybatis では引数の値を使用したい場合、#{} で指定する
    @Insert("insert into issues (summary, description) values (#{summary}, #{description})")
    void insert(String summary, String description);
}
