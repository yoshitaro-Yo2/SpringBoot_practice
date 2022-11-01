package jp.co.IssueTrackingSystem.PracticeForWebApp.domain.issue;

import org.springframework.stereotype.Service;

import java.util.List;

public class IssueService {
    public List<IssueEntity> findAllIssues() {
        var issueList = List.of(
                new IssueEntity(1, "概要1", "説明1"),
                new IssueEntity(2, "概要2", "説明2"),
                new IssueEntity(3, "概要3", "説明3")
        );
        return issueList;
    }
}
