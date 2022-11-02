package jp.co.IssueTrackingSystem.PracticeForWebApp.domain.issue;

import jp.co.IssueTrackingSystem.PracticeForWebApp.issue.IssueForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// @RequiredArgsConstructor final がついてる初期化されていないフィールドを
// 初期化するコンストラクタを自動で生成、インジェクションの受け口となりフィールド
@Service
@RequiredArgsConstructor
public class IssueService {

    // final → 初期化時に一度だけ代入されるのみで、再代入を禁止
    private final IssueRepository issueRepository;

    public List<IssueEntity> findAllIssues() {
        return issueRepository.findAllIssues();
    }
    // TODO トランザクション
    public void create(String summary, String description) {
        issueRepository.insert(summary, description);
    }
}
