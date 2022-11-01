package jp.co.IssueTrackingSystem.PracticeForWebApp.issue;

import jp.co.IssueTrackingSystem.PracticeForWebApp.domain.issue.issueEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class issueController {
    // GET / issues
    @GetMapping("/issues")
    public String showList(Model model){
        var issueList = List.of(
                new issueEntity(1, "概要1", "説明1"),
                new issueEntity(2, "概要2", "説明2"),
                new issueEntity(3, "概要3", "説明3")
        );
        model.addAttribute("issueList", issueList);
        return "issues/list";
    }
}
