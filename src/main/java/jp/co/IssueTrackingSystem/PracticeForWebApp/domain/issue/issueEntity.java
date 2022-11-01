package jp.co.IssueTrackingSystem.PracticeForWebApp.domain.issue;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class issueEntity {
    private long id;
    private String summary;
    private String description;
}
